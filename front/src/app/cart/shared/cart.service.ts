import { EventEmitter, Injectable } from '@angular/core';
import { Product } from '../../models/product.model';
import { CartItem } from '../../models/cart-item.model';
import { MessageService } from '../../messages/message.service';

@Injectable()
export class CartService {
  // Init and generate some fixtures
  private cartItems: CartItem[];
  public itemsChanged: EventEmitter<CartItem[]> = new EventEmitter<CartItem[]>();

  constructor(private messageService: MessageService) {
    this.cartItems = [];
  }

  public getItems() {
    return this.cartItems.slice();
  }

  // Get Product ids out of CartItem[] in a new array
  private getItemIds() {
    return this.getItems().map(cartItem => cartItem.product.idproduit);
  }

  public addItem(item: CartItem) {
    // If item is already in cart, add to the amount, otherwise push item into cart
    if (this.getItemIds().includes(item.product.idproduit)) {
      this.cartItems.forEach(function (cartItem) {
        if (cartItem.product.idproduit === item.product.idproduit) {
          cartItem.amount += item.amount;
        }
      });
      this.messageService.add('Amount in cart changed for: ' + item.product.nom);
    } else {
      this.cartItems.push(item);
      this.messageService.add('Added to cart: ' + item.product.nom);
    }
    this.itemsChanged.emit(this.cartItems.slice());
  }

  public addItems(items: CartItem[]) {
    items.forEach((cartItem) => {
      this.addItem(cartItem);
    });
  }

  public removeItem(item: CartItem) {
    const indexToRemove = this.cartItems.findIndex(element => element === item);
    this.cartItems.splice(indexToRemove, 1);
    this.itemsChanged.emit(this.cartItems.slice());
    this.messageService.add('Deleted from cart: ' + item.product.nom);
  }

  public updateItemAmount(item: CartItem, newAmount: number) {
    this.cartItems.forEach((cartItem) => {
      if (cartItem.product.idproduit === item.product.idproduit) {
        cartItem.amount = newAmount;
      }
    });
    this.itemsChanged.emit(this.cartItems.slice());
    this.messageService.add('Updated amount for: ' + item.product.nom);
  }

  public clearCart() {
    this.cartItems = [];
    this.itemsChanged.emit(this.cartItems.slice());
    this.messageService.add('Cleared cart');
  }

  public getTotal() {
    let total = 0;
    this.cartItems.forEach((cartItem) => {
      total += cartItem.amount * cartItem.product.prix;
    });
    return total;
  }

}
