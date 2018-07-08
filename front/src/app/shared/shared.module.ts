import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PriceComponent } from './price/price.component';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from '../app-routing.module';
import { PageTitleComponent } from '../core/page-title/page-title.component';

@NgModule({
  declarations: [
      PriceComponent,
      PageTitleComponent
  ],
  imports: [
      CommonModule,
      AppRoutingModule,
      FormsModule
  ],
  exports: [
      PriceComponent,
      PageTitleComponent,
      CommonModule,
      AppRoutingModule,
      FormsModule
  ]
})
export class SharedModule {}
