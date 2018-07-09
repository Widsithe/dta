import { Component, OnInit, OnDestroy, Input } from '@angular/core';
import { Subject } from 'rxjs';
import { Product } from '../../products/product';
import { User } from '../../account/user';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { takeUntil } from 'rxjs/operators';
import { AuthService } from '../../account/shared/auth.service';
import { CartService } from '../../cart/shared/cart.service';
import { ProductsCacheService } from '../shared/products-cache.service';
import { ProductService } from '../shared/product.service';
import { CartItem } from '../../models/cart-item.model';

@Component({
  selector: 'app-animaux-detail',
  templateUrl: './animaux-detail.component.html',
  styleUrls: ['./animaux-detail.component.scss']
})
export class AnimauxDetailComponent implements OnInit, OnDestroy {
  private unsubscribe$ = new Subject();
  @Input() public product: Product;
  public productLoading: boolean;

  public user: User;

  public imagesLoaded: string[];
  public activeImageUrl: string;
  public activeImageIndex: number;

  public selectedQuantity: number;

  public ratingCount: number;
  public ratingValues: number[];
  public selectedRating: any;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private location: Location,
    private authService: AuthService,
    private cartService: CartService,
    private productsCacheService: ProductsCacheService,
    private productService: ProductService,
  ) { }

  ngOnInit(): void {
    this.selectedQuantity = 1;
    this.imagesLoaded = [];

    this.route.params
      .pipe(takeUntil(this.unsubscribe$))
      .subscribe((params: Params) => {
        this.getProduct();
      });
  }

  private getProduct(): void {
    this.productLoading = true;

    const id = +this.route.snapshot.paramMap.get('id');

    this.productsCacheService
      .get(id, this.productService.getProducts())
      .pipe(takeUntil(this.unsubscribe$))
      .subscribe((product: Product) => {
        if (product) {
          this.product = product;
          this.setupProduct();
          this.productLoading = false;
        } else {
          this.router.navigate(['/404-product-not-found']);
        }
      });
  }
  public onAddToCart() {
    this.cartService.addItem(new CartItem(this.product, this.selectedQuantity));
  }

  public onSelectQuantity(event) {
    this.selectedQuantity = <number>+event.target.value;
  }

  public onImageLoad(e: any) {
    this.imagesLoaded.push(e.target.src);
  }

  private setupProduct() {
    if (this.product) {
      this.checkCategories();
    }
  }

  private checkCategories() {
    const categories = Object.keys(this.product.type).map(
      (category, index, inputArray) => {
        category = index < inputArray.length - 1 ? category + ',' : category;
        return category;
      }
    );
  }

  ngOnDestroy() {
    this.unsubscribe$.next();
    this.unsubscribe$.complete();
  }
}
