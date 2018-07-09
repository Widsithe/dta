import { Component, OnInit, Input } from '@angular/core';
import { Product } from '../../products/product';

@Component({
  selector: 'app-price',
  templateUrl: './price.component.html',
  styleUrls: ['./price.component.scss']
})
export class PriceComponent {
  @Input() public product: Product;

}
