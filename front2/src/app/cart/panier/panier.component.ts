import { Component, OnInit } from '@angular/core';
import { Product } from './../../products/product';
import { PanierService } from '../panier.service';
import { CommandeService } from '../commande.service';
import { UserService } from './../../user/user.service';
import { Message } from 'primeng/components/common/api';
import { Router } from '@angular/router';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.scss']
})
export class PanierComponent implements OnInit {
  monPanier = new Array<Product>();

  msgs: Message[] = [];

  constructor(private panierService: PanierService,
              private commandeService: CommandeService,
              private userService: UserService,
              private router: Router) {
    this.panierService = panierService;
    this.commandeService = commandeService;
    this.userService = userService;
    this.router = router;
  }

  ngOnInit() {
    if (this.panierService.getCurrentPanier()) {
      this.monPanier = this.panierService.getCurrentPanier();
    }

  }

  deleteArticle(index: number) {
    this.panierService.removeProductFromPanier(index);
    this.monPanier = this.panierService.getCurrentPanier();
  }

  updateTotal() {
    // return this.monPanier.reduce((acc,elt)=>acc+=elt.price*elt.qty,0);
    let total = 0;

    for (const element of this.monPanier) {
      total += element.prix * element.stock;
    }
    return total;
  }
  nbrProduit() {
    // return this.monPanier.reduce((acc,elt)=>acc+=elt.price*elt.qty,0);
    let nbr = 0;

    for (const prod of this.monPanier) {
      nbr += prod.stock;
    }
    return nbr;
  }
  quantityChange(event, id_produit) {
    this.panierService.setProductQtyInPanier(id_produit, event.target.valueAsNumber);
    this.monPanier = this.panierService.getCurrentPanier();
  }

  checkout() {// Validation de la commande
    if (!this.userService.getConnectedUserInSession()) {
      this.router.navigate(['/authentification'], {
        queryParams: {
          severity: 'warn',
          summary: 'Vous n\'êtes pas authentifié ! ',
          message: 'Veuillez vous connectez ou créer votre compte afin de valider votre panier'
        }
      });
      return;
    }
    this.userService.getConnectedUser().subscribe(user => {
      this.commandeService.createCommande(user).subscribe(data => {
        // display message success
        this.msgs.push({
          severity: 'success',
          summary: 'Commande validée ',
          detail: 'Votre panier est validé ! \nVous pouvez consulter vos commandes dans votre profil.'
        });
        // empty panier
        this.panierService.clearPanier();
        this.ngOnInit();
      });
    }, error => {
      // display error message
      this.msgs.push({
        severity: 'error',
        summary: 'Erreur. ',
        detail: 'Une erreur est survenue lors de la création de votre commande.'
      });
    });
  }
}
