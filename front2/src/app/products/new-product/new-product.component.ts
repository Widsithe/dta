import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { NgForm } from '@angular/forms';
import { FileUploadModule } from 'primeng/fileupload';
import { Message } from 'primeng/components/common/api';
import { UserService } from './../../user/user.service';
import { Router } from '@angular/router';
import { SelectItem } from 'primeng/api';
import { DropdownModule } from 'primeng/dropdown';

@Component({
  selector: 'app-new-product',
  templateUrl: './new-product.component.html',
  styleUrls: ['./new-product.component.scss']
})

export class NewProductComponent implements OnInit {
  cat: SelectItem[];
  product: Product = new Product(0, '', '', 0, 0, '', true, '');
  msgs: Message[] = [];
  selectedFile: File = null;
  modifCategory;

  readonly categ = { 'MAMMIFERE': 'Mammifère', 'OISEAU': 'Oiseau', 'INSECTE': 'Insecte' };

  constructor(private productService: ProductService, private uServ: UserService, private router: Router) {
    this.productService = productService;
    this.uServ = uServ;
    this.router = router;
  }


  resetForm(form?: NgForm) {
    if (form != null) {
      form.reset();
    }
    this.product = new Product(0, '', '', 0, 0, '', true, '');
  }

  ngOnInit() {
    if (!this.uServ.getConnectedUserInSession()) {
      this.router.navigate(['/authentification'], {
        queryParams: {
          severity: 'warn',
          summary: 'Vous n\'êtes pas connecté',
          message: 'Connectez-vous afin de pouvoir accéder à votre profil.'
        }
      });
    }

    this.cat = [
      { label: 'Alpinisme / Escalade', value: 'CLIMBING' },
      { label: 'Plongée', value: 'DIVING' },
      { label: 'Randonnée', value: 'HIKING'}
    ];
  }

  OnSubmit(form: NgForm) {
    this.msgs = [];
    this.product.idproduit = null;
    if (!form.valid) {
      this.msgs.push({
        severity: 'error',
        summary: 'Champs invalides',
        detail: 'Certains champs du formulaire sont incomplets ou invalide.'
      });
      return;
    }
    // save first time to get new id
    this.product.type = this.modifCategory.value;
    this.productService.saveProduct(this.product).subscribe(newProduct => {
      // save image with id of product
      this.productService.saveImage(newProduct.id, this.selectedFile).subscribe(filePath => {
        // update new product with new src
        if (filePath.body) {
          newProduct.category = this.modifCategory.value;
          newProduct.src = filePath.body;
          this.productService.saveProduct(newProduct).subscribe(data => {
            this.msgs.push({
              severity: 'success',
              summary: 'Produit créé',
              detail: 'Le produit à bien été crée'
            });
            this.resetForm(form);
          });
        }

      },
        error => {
          this.msgs.push({
            severity: 'error',
            summary: 'Problème serveur',
            detail: 'Le produit n\'a pas pu être créer suite à une erreur du serveur.'
          });
        });
    },
      error => {
        this.msgs.push({
          severity: 'error',
          summary: 'Problème serveur',
          detail: 'Le produit n\'a pas pu être créer suite à une erreur du serveur.'
        });
      });
  }

  onUpload(event) {
    this.selectedFile = event.files[0];
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

