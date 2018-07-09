
import { combineLatest as observableCombineLatest, Observable, from as fromPromise, of, config } from 'rxjs';
import { Injectable } from '@angular/core';

import { AuthService } from '../../account/shared/auth.service';
import { MessageService } from '../../messages/message.service';
import { Product } from '../../models/product.model';
import { ProductsUrl } from './productsUrl';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Config } from '../../config';
import { PRODUCTS } from '../product';

@Injectable()
export class ProductService {
  private productsUrl = ProductsUrl.productsUrl;
  products = new Array<Product>();

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
  constructor(
    private messageService: MessageService,
    public authService: AuthService,
    private http: HttpClient
  ) {
    this.products = PRODUCTS;
  }

  getProducts(): Observable<Product[]> {
    return of(this.products);
  }


  uploadImage(image: any) {
  }

  addProduct(product: Product) {
    this.http.post<Product>(Config.restApi + '/addProduit', product, this.httpOptions).subscribe();
  }
}
