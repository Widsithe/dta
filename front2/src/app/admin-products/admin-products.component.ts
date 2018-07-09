import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { DataTableModule } from 'primeng/datatable';
import { TableModule } from 'primeng/table';
import { CheckboxModule } from 'primeng/checkbox';
import { DataGridModule } from 'primeng/datagrid';
import { PanelModule } from 'primeng/panel';
import { DialogModule } from 'primeng/dialog';
import { ScrollPanelModule } from 'primeng/scrollpanel';
import { Router, ActivatedRoute } from '@angular/router';
import { InputSwitchModule } from 'primeng/inputswitch';
import { forEach } from '@angular/router/src/utils/collection';
import { DropdownModule } from 'primeng/dropdown';
import { SelectItem } from 'primeng/api';
import { ButtonModule } from 'primeng/button';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { CommandeService } from '../commande.service';
import { Message } from 'primeng/components/common/api';
import { callNgModuleLifecycle } from '@angular/core/src/view/ng_module';
import { UserService } from './../user.service';

interface Category {
  label: string;
  value: string;
}

@Component({
  selector: 'app-admin-products',
  templateUrl: './admin-products.component.html',
  styleUrls: ['./admin-products.component.scss']
})


export class AdminProductsComponent implements OnInit {
  cat: SelectItem[];
  selectedCat: Category;
  checked1: boolean = false;
  checked2: boolean = true;
  myProducts: Product[];
  selectedProduct: Product;
  cols: any[];
  page: number = 1;
  resultByPage: number = 1000;
  model: Product = new Product(0, "", "", 0, "", 0, "", false, "");
  name: string = "";
  category: string = "";
  id: number = 0;
  submitted = false;
  display: boolean = false;
  activ: boolean;
  avalaibleCategories: SelectItem[] = [];
  selectedTypes: string[];
  msgs: Message[] = [];
  readonly categ = { 'CLIMBING': 'Alpinisme / Escalade', 'DIVING': 'Plongée', 'HIKING': 'Randonnée' };

  modifCategory;



  constructor(private productService: ProductService, private commandeService: CommandeService,
    private route: ActivatedRoute, private router: Router, private uServ: UserService) {

    this.productService = productService;
    this.commandeService = commandeService;
    this.route = route;
    this.router = router;

    this.productService.getCategories().subscribe(myAvalaibleCategories => {
      for (let catStr of myAvalaibleCategories) {
        this.avalaibleCategories.push({ label: catStr, value: catStr });
      }
    });
  }

  ngOnInit() {
    if (!this.uServ.getConnectedUserInSession()) {
      this.router.navigate(["/authentification"], {
        queryParams: {
          severity: "warn",
          summary: "Vous n'êtes pas connecté",
          message: "Connectez-vous afin de pouvoir accéder à votre profile."
        }
      });
    }
    this.productService.getProducts().subscribe(result => {
      this.myProducts = result.map(p => Product.fromJson(p));
      this.myProducts = this.myProducts.sort((a, b) => a.id - b.id);
    });




    this.cat = [
      { label: 'Alpinisme / Escalade', value: 'CLIMBING' },
      { label: 'Plongée', value: 'DIVING' },
      { label: 'Randonnée', value: 'HIKING' }
    ];

    this.cols = [
      { field: 'id', header: 'Id' },
      { field: 'name', header: 'Nom' },
      { field: 'type', header: 'Type' },
      { field: 'price', header: 'Prix' },
      { field: 'category', header: 'Catégorie' },
      { field: 'qty', header: 'Quantité' }
    ];
  }

  onSubmit() {
    this.submitted = true;
    let catStr = this.selectedTypes ? this.selectedTypes.join("-") : '';
    if (this.name == "" && catStr == "") {
      this.ngOnInit();
    }
    this.productService.search(this.name, catStr, this.page, this.resultByPage)
      .subscribe(result => this.myProducts = result.listSearch.sort((a, b) => a.id - b.id), error => console.log(error));
  }

  redirect() {
    this.router.navigate(['/newProduct']);
  }

  saveProduct(productName: string, productQty: number, productPrice: number, productType: string, productDescript: string) {
    this.selectedProduct.category = this.modifCategory.value;
    this.productService.saveProduct(this.selectedProduct).subscribe(() => this.ngOnInit());
  }

  removeProduct(id: number) {
    this.id = id;
    this.productService.removeProductById(id).subscribe(() => this.ngOnInit());
  }

  selectProduct(product: Product) {
    this.display = true;
    this.selectedProduct = product;
    this.modifCategory = this.getCat(this.selectedProduct.category);
  }

  activProduct(product: Product) {
    this.selectedProduct = product;
  }

  onOffProduct(activ) {

    this.commandeService.isInOrder(this.selectedProduct.id).subscribe(
      data => {
        if (data.orders.length == 0) {
          this.productService.activProduct(this.selectedProduct.id, activ).subscribe(() => this.ngOnInit());

        } else {
          this.productService.getProducts().subscribe(() => this.ngOnInit());
          this.alertOffProduct(this.selectedProduct.name);
        }
      });

  }

  alertOffProduct(productName: string) {
    this.msgs = [];
    this.msgs.push({
      severity: 'error', summary: 'Désactivation du produit',
      detail: 'Vous ne pouvez pas désactiver le produit ' + productName + ' car il est déjà commandé '
    });
  }

  onDialogHide() {
    this.selectedProduct = null;
  }

  getCat(str) {
    for (let i of this.cat) {
      if (i.value == str || i.label == str) return i;
    }
    return "";
  }
}
