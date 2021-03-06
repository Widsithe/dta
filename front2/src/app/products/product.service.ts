import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpRequest, HttpEvent } from '@angular/common/http';
import { Product } from './product';

@Injectable()
export class ProductService {
  static readonly restApi = 'http://localhost:8080/DeTendresAnimaux/api/admin/produits';

  constructor(private http: HttpClient) {
    this.http = http;
  }

  getProducts(): Observable<any> {
    return this.http.get(ProductService.restApi);
  }

  saveProduct(product: Product): Observable<any> {
    return this.http.post(ProductService.restApi, product);
  }

  removeProductById(id: number): Observable<any> {
    return this.http.delete(ProductService.restApi + '/' + id);
  }

  getProductById(id): Observable<any> {
    return this.http.get(ProductService.restApi + '/' + id);
  }

  search(name, category, page, resultByPage): Observable<any> {
    return this.http.get(ProductService.restApi  +
      '?name=' + name);
      // +
      //'&category=' + category +
      //'&page=' + page +
      //'&resultByPage=' + resultByPage);
  }

  getCategories(): Observable<any> {
    return this.http.get(ProductService.restApi + '/categories');  }

  saveImage(imagename, image: File): Observable<any> {
    const formdata: FormData = new FormData();

    formdata.append('file', image);
    formdata.append('filename', imagename);

    const req = new HttpRequest('POST', 'http://localhost:8080/formafond/api/image', formdata, {
      reportProgress: false,
      responseType: 'text'
    });

    return this.http.request(req);
  }

  activProduct(id: number, activ: boolean) {
    return this.http.get(ProductService.restApi + '/' + id + (activ ? '/activate' : '/deactivate'));
  }
}
