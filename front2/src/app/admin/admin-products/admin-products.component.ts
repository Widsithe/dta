import { Component, OnInit } from '@angular/core';
import { Product } from './../../products/product';
import { ProductService } from './../../products/product.service';
import { Router, ActivatedRoute } from '@angular/router';
import { SelectItem } from 'primeng/api';
import { CommandeService } from './../../cart/commande.service';
import { Message } from 'primeng/components/common/api';
import { UserService } from './../../user/user.service';

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
  checked1: Boolean = false;
  checked2: Boolean = true;
  myProducts: Product[];
  selectedProduct: Product;
  cols: any[];
  page: Number = 1;
  resultByPage: Number = 1000;
  model: Product = new Product(0, '', '', 0, 0, '', false, '');
  name: String = '';
  category: String = '';
  id: Number = 0;
  submitted = false;
  display: Boolean = false;
  activ: boolean;
  avalaibleCategories: SelectItem[] = [];
  selectedTypes: string[];
  msgs: Message[] = [];
  readonly categ = { 'MAMMIFERE': 'Mammifère', 'OISEAU': 'Oiseau', 'INSECTE': 'Insecte' };

  modifCategory;



  constructor(private productService: ProductService, private commandeService: CommandeService,
    private route: ActivatedRoute, private router: Router, private uServ: UserService) {

    this.productService = productService;
    this.commandeService = commandeService;
    this.route = route;
    this.router = router;

    this.productService.getCategories().subscribe(myAvalaibleCategories => {
      for (const catStr of myAvalaibleCategories) {
        this.avalaibleCategories.push({ label: catStr, value: catStr });
      }
    });
  }

  ngOnInit() {
    if (!this.uServ.getConnectedUserInSession()) {
      this.router.navigate(['/authentification'], {
        queryParams: {
          severity: 'warn',
          summary: 'Vous n\'êtes pas connecté',
          message: 'Connectez-vous afin de pouvoir accéder à votre profile.'
        }
      });
    }
    this.productService.getProducts().subscribe(result => {
      this.myProducts = result.map(p => Product.fromJson(p));
      this.myProducts = this.myProducts.sort((a, b) => a.idproduit - b.idproduit);
    });




    this.cat = [
      { label: 'Mammifère', value: 'MAMMIFERE' },
      { label: 'Insecte', value: 'INSECTE' },
      { label: 'Oiseau', value: 'OISEAU' }
    ];

    this.cols = [
      { field: 'idproduit', header: 'Id' },
      { field: 'nom', header: 'Nom' },
      { field: 'type', header: 'Type' },
      { field: 'prix', header: 'Prix' },
      { field: 'stock', header: 'Quantité' }
    ];
  }

  onSubmit() {
    this.submitted = true;
    const catStr = this.selectedTypes ? this.selectedTypes.join('-') : '';
    if (this.name === '' && catStr === '') {
      this.ngOnInit();
    }
    this.productService.search(this.name, catStr, this.page, this.resultByPage)
      .subscribe(result => this.myProducts = result.listSearch.sort((a, b) => a.id - b.id), error => console.log(error));
  }

  redirect() {
    this.router.navigate(['/newProduct']);
  }

  saveProduct(productName: string, productQty: number, productPrice: number, productType: string, productDescript: string) {
    this.selectedProduct.type = this.modifCategory.value;
    this.productService.saveProduct(this.selectedProduct).subscribe(() => this.ngOnInit());
  }

  removeProduct(id: number) {
    this.id = id;
    this.productService.removeProductById(id).subscribe(() => this.ngOnInit());
  }

  selectProduct(product: Product) {
    this.display = true;
    this.selectedProduct = product;
    this.modifCategory = this.getCat(this.selectedProduct.type);
  }

  activProduct(product: Product) {
    this.selectedProduct = product;
  }

  onOffProduct(activ) {

    this.commandeService.isInOrder(this.selectedProduct.idproduit).subscribe(
      data => {
        if (data.orders.length === 0) {
          this.productService.activProduct(this.selectedProduct.idproduit, activ).subscribe(() => this.ngOnInit());

        } else {
          this.productService.getProducts().subscribe(() => this.ngOnInit());
          this.alertOffProduct(this.selectedProduct.nom);
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
    for (const i of this.cat) {
      if (i.value === str || i.label === str) {
        return i;
      }
    }
    return '';
  }
}
