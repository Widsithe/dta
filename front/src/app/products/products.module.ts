import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModule } from '../shared/shared.module';

import { AnimauxListComponent } from './animaux-list/animaux-list.component';
import { AnimauxListItemComponent } from './animaux-list-item/animaux-list-item.component';
import { AnimauxDetailComponent } from './animaux-detail/animaux-detail.component';

import { SortPipe } from './shared/sort.pipe';

@NgModule({
  declarations: [
    AnimauxListItemComponent,
    AnimauxListComponent,
    AnimauxDetailComponent,
    SortPipe,
  ],
  imports: [SharedModule],
  exports: [
    AnimauxListItemComponent,
    AnimauxListComponent,
    AnimauxDetailComponent,
    SortPipe,
  ],
  providers: [SortPipe]
})
export class ProductsModule {}
