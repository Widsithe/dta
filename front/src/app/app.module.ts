import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Injectable } from '@angular/core';

import { HttpClientModule, HttpInterceptor, HttpRequest, HttpHandler, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { AuthInterceptor } from './auth-interceptor';

import { MaterialModule } from '@blox/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { MatMenuModule } from '@angular/material/menu';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatBadgeModule } from '@angular/material/badge';
import { MatIconModule } from '@angular/material/icon';
import { MatGridListModule } from '@angular/material/grid-list';

import { AdopterComponent } from './adopter/adopter.component';
import { AnimauxComponent } from './animaux/animaux.component';
import { AnimauxDetailComponent } from './animaux-detail/animaux-detail.component';
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
import { AdminSearchService } from './admin-search.service';

@Injectable()
export class XhrInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    const xhr = req.clone({
      headers: req.headers.set('X-Requested-With', 'XMLHttpRequest')
    });
    return next.handle(xhr);
  }
}

const appRoutes: Routes = [
  {
    path: 'adopter',
    component: AdopterComponent,
    data: { title: 'Tous nos animaux' }
  },
  {
    path: 'admin',
    component: AdminComponent,
    data: { title: 'Votre interface d"administration' }
  },
  {
    path: 'login-admin',
    component: LoginadminComponent,
    data: { title: 'Connectez vous' }
  },
  {
    path: 'admin/commandes',
    component: AdminCommandesComponent,
    data: { title: 'Toutes les commandes' }
  },
  {
    path: 'admin/produits',
    component: AdminProduitComponent,
    data: { title: 'Tous les produits' }
  },
  {
    path: 'connexion',
    component: ConnexionComponent,
    data: { title: 'Connexion' }
  },
  {
    path: 'panier',
    component: PanierComponent,
    data: { title: 'Votre panier' }
  },
  {
    path: 'admin/search',
    component: AdminSearchService,
    data: { title: 'Recherche'}
  }
];

@NgModule({
  declarations: [
    AppComponent,
    AdopterComponent,
    AnimauxComponent,
    AnimauxDetailComponent,
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
    AdminSearchComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    ),
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
  ],
  providers: [
    LoginAdminService,
    { provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
