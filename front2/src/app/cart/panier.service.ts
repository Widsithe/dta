import { Injectable } from '@angular/core';
import { Product } from './../products/product';

@Injectable()
export class PanierService {

  constructor() { }

  getCurrentPanier(): Product[] {
    const prodList = sessionStorage.getItem('panier');

    if (prodList != null) {
      return (JSON.parse(prodList) as any[]).map(obj => Product.fromJson(obj));
    } else {
      return null;
    }
  }

  addProductToPanier(p: Product, qty: number) {
    let currPanier = JSON.parse(sessionStorage.getItem('panier'));
    p.stock = qty;
    if (currPanier === null) {
      currPanier = [];
    }
    let isThere = false;
    for (const prodPan of currPanier) {
      if (prodPan.id === p.idproduit) {
        isThere = true;
        prodPan.qty = qty;
        break;
      }
    }
    if (!isThere) {
      currPanier.push(p);
    }
    sessionStorage.setItem('panier', JSON.stringify(currPanier));
  }

  removeProductFromPanier(prod_id: number) {
    let currPanier = JSON.parse(sessionStorage.getItem('panier'));
    if (currPanier == null) {
      return;
    }
    currPanier = currPanier.filter(p => p.id !== prod_id);
    sessionStorage.setItem('panier', JSON.stringify(currPanier));
  }

  setProductQtyInPanier(prod_id: number, qty: number) {
    const currPanier = JSON.parse(sessionStorage.getItem('panier'));
    if (currPanier == null) {
      return;
    }
    for (const p of currPanier) {
      if (p.idproduit === prod_id) {
        p.stock = qty;
      }
    }
    sessionStorage.setItem('panier', JSON.stringify(currPanier));
  }

  clearPanier() {
    sessionStorage.setItem('panier', JSON.stringify([]));
  }

}
