import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StepsModule } from 'primeng/steps';
import { MenuItem } from 'primeng/api';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { FileUploadModule } from 'primeng/fileupload';
import { AccordionModule } from 'primeng/accordion';
import { TableModule } from 'primeng/table';
import { DataTableModule } from 'primeng/datatable';
import { CheckboxModule } from 'primeng/checkbox';
import { MenubarModule } from 'primeng/menubar';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { ButtonModule } from 'primeng/button';
import { Observable } from 'rxjs';
import { DataGridModule } from 'primeng/datagrid';
import { PanelModule } from 'primeng/panel';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SelectItem } from 'primeng/api';
import { SelectButtonModule } from 'primeng/selectbutton';
import { DialogModule } from 'primeng/dialog';
import { MenuModule } from 'primeng/menu';
import { InputTextModule } from 'primeng/inputtext';
import { GrowlModule } from 'primeng/growl';
import { MessagesModule } from 'primeng/messages';
import { MessageModule } from 'primeng/message';
import { InputSwitchModule } from 'primeng/inputswitch';
import { SpinnerModule } from 'primeng/spinner';
import { DropdownModule } from 'primeng/dropdown';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { ScrollPanelModule } from 'primeng/scrollpanel';
import { TabMenuModule } from 'primeng/tabmenu';
import {CardModule} from 'primeng/card';


import { AppComponent } from './app.component';
import { ProductsComponent } from './products/products.component';
import { ProductService } from './products/product.service';
import { MenuComponent } from './menu/menu.component';
import { NewProductComponent } from './products/new-product/new-product.component';
import { NewUserComponent } from './user/new-user/new-user.component';
import { AdminProductsComponent } from './admin/admin-products/admin-products.component';
import { AdminOrdersComponent } from './admin/admin-orders/admin-orders.component';
import { AuthentificationComponent } from './security/authentification/authentification.component';
import { UserService } from './user/user.service';
import { UserProfileComponent } from './user/user-profile/user-profile.component';
import { PanierComponent } from './cart/panier/panier.component';
import { PanierService } from './cart/panier.service';
import { ProfileDetailComponent } from './user/profile-detail/profile-detail.component';
import { UserOrderComponent } from './user/user-order/user-order.component';
import { CommandeService } from './cart/commande.service';
import { FooterComponent } from './footer/footer.component';
import { AccueilComponent } from './accueil/accueil.component';

// Material for angular
import {MatButtonModule} from '@angular/material/button';

const appRoutes: Routes = [
  { path: '', redirectTo: '/accueil', pathMatch: 'full' },
  { path: 'accueil', component: AccueilComponent },
  { path: 'Products', component: ProductsComponent },
  { path: 'AdminProducts', component: AdminProductsComponent },
  { path: 'AdminOrders', component: AdminOrdersComponent },
  { path: 'authentification', component: AuthentificationComponent },
  { path: 'newUser', component: NewUserComponent },
  { path: 'newProduct', component: NewProductComponent },
  { path: 'panier', component: PanierComponent },
  { path: 'profil', component: UserProfileComponent },
  { path: 'order', component: UserOrderComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    AuthentificationComponent,
    ProductsComponent,
    AdminProductsComponent,
    AdminOrdersComponent,
    NewUserComponent,
    MenuComponent,
    NewProductComponent,
    PanierComponent,
    UserProfileComponent,
    ProfileDetailComponent,
    UserOrderComponent,
    FooterComponent,
    AccueilComponent,

  ],
  imports: [
    CardModule,
    TabMenuModule,
    InputTextareaModule,
    DropdownModule,
    InputSwitchModule,
    SpinnerModule,
    MessagesModule,
    MessageModule,
    ReactiveFormsModule,
    GrowlModule,
    InputTextModule,
    ScrollPanelModule,
    MenuModule,
    DialogModule,
    SelectButtonModule,
    BrowserAnimationsModule,
    SelectButtonModule,
    PanelModule,
    DataGridModule,
    AngularFontAwesomeModule,
    MenubarModule,
    CheckboxModule,
    TableModule,
    DataTableModule,
    AccordionModule,
    HttpClientModule,
    FileUploadModule,
    FormsModule,
    BrowserModule,
    ButtonModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    ),
    MatButtonModule
  ],
  providers: [ProductService, UserService, PanierService, CommandeService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
