
import { combineLatest as observableCombineLatest, Observable, from as fromPromise, of, config } from 'rxjs';
import { Injectable } from '@angular/core';

import { catchError, tap, switchMap, map } from 'rxjs/operators';

import { AuthService } from '../../account/shared/auth.service';
import { FileUploadService } from './file-upload.service';
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
    private uploadService: FileUploadService,
    private http: HttpClient
  ) {
    this.products = PRODUCTS;
  }

  /** Log a ProductService message with the MessageService */
  private log(message: string) {
    this.messageService.add('ProductService: ' + message);
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error); // log to console instead
      this.log(`${operation} failed: ${error.message}`);
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
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
