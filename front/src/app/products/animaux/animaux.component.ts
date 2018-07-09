import { Component, OnInit } from '@angular/core';
import { Product } from '../../models/product.model';
import { ProductService } from '../shared/product.service';

@Component({
  selector: 'app-animaux',
  templateUrl: './animaux.component.html',
  styleUrls: ['./animaux.component.scss']
})
export class AnimauxComponent implements OnInit {
  products: Array<Product>;
  constructor(private productService: ProductService) {
    this.productService = productService;
    this.products = [];
   }

  ngOnInit() {
    this.productService.getProducts().subscribe(myProds => this.products = myProds);
  }

}
