

import { HttpClientModule, HttpInterceptor, HttpRequest, HttpHandler, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
// Modules
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule, Injectable } from '@angular/core';
import { ToastrModule } from 'ngx-toastr';
import { ProductsModule } from './products/products.module';
import { SharedModule } from './shared/shared.module';
import { CoreModule } from './core/core.module';
import { CheckoutModule } from './checkout/checkout.module';
import { AccountModule } from './account/account.module';
import { AdminModule } from './admin/admin.module';
import { environment } from '../environments/environment';
import { FormsModule } from '@angular/forms';
import { MaterialModule } from '@blox/material';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { MatMenuModule } from '@angular/material/menu';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatBadgeModule } from '@angular/material/badge';
import { MatIconModule } from '@angular/material/icon';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatPaginatorModule } from '@angular/material/paginator';

// Components
import { AppComponent } from './app.component';
import { CartComponent } from './cart/cart.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

import { AuthInterceptor } from './auth-interceptor';


import { AdopterComponent } from './adopter/adopter.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { AdminComponent } from './admin/admin.component';
import { LoginadminComponent } from './loginadmin/loginadmin.component';
import { PanierComponent } from './panier/panier.component';
import { MenuComponent } from './menu/menu.component';
import { MenuadminComponent } from './menuadmin/menuadmin.component';
import { MenuloginComponent } from './menulogin/menulogin.component';
import { AdminProduitComponent } from './admin-produit/admin-produit.component';
import { AdminCommandesComponent } from './admin-commandes/admin-commandes.component';
import { AdminCommandesDetailComponent } from './admin-commandes-detail/admin-commandes-detail.component';
import { AdminProduitDetailComponent } from './admin-produit-detail/admin-produit-detail.component';
import { LoginAdminService } from './login-admin.service';
import { AdminSearchComponent } from './admin-search/admin-search.component';
import { AdminSearchService } from './admin/admin-search.service';
import { LoginUserService } from './account/login-user.service';
import { SearchComponent } from './search/search.component';
import { PaginatorComponent } from './paginator/paginator.component';

@Injectable()
export class XhrInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    const xhr = req.clone({
      headers: req.headers.set('X-Requested-With', 'XMLHttpRequest')
    });
    return next.handle(xhr);
  }
}

@NgModule({
  declarations: [
    AppComponent,
    AdopterComponent,
    ConnexionComponent,
    AdminComponent,
    LoginadminComponent,
    PanierComponent,
    MenuComponent,
    MenuadminComponent,
    MenuloginComponent,
    AdminProduitComponent,
    AdminCommandesComponent,
    AdminCommandesDetailComponent,
    AdminProduitDetailComponent,
    AdminSearchComponent,
    SearchComponent,
    PaginatorComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    RouterModule,
    NoopAnimationsModule,
    FormsModule,
    MaterialModule,
    MatMenuModule,
    MatToolbarModule,
    MatButtonModule,
    MatBadgeModule,
    MatIconModule,
    HttpClientModule,
    MatGridListModule,
    MatCardModule,
    MatPaginatorModule
  ],
  providers: [
    LoginAdminService,
    LoginUserService,
    { provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
