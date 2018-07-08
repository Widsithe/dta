import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './core/home/home.component';
import { CartComponent } from './cart/cart.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { RegisterLoginComponent } from './account/register-login/register-login.component';
import { OrdersComponent } from './account/orders/orders.component';
import { ProfileComponent } from './account/profile/profile.component';
import { AccountComponent } from './account/account.component';
import { CompleteComponent } from './checkout/complete/complete.component';
import { AdminSearchComponent } from './admin-search/admin-search.component';
import { PanierComponent } from './panier/panier.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { AdminProduitComponent } from './admin-produit/admin-produit.component';
import { AdminCommandesComponent } from './admin-commandes/admin-commandes.component';
import { LoginadminComponent } from './loginadmin/loginadmin.component';
import { AdminComponent } from './admin/admin.component';
import { AdopterComponent } from './adopter/adopter.component';

const routes: Routes = [
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
    component: AdminSearchComponent,
    data: { title: 'Recherche' }
  },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'products', component: ProductsListComponent },
  { path: 'products/:id', component: ProductDetailComponent },
  { path: 'cart', component: CartComponent },
  { path: 'admin/add', component: AddEditComponent, canActivate: [AdminGuard] },
  {
    path: 'admin/edit/:id',
    component: AddEditComponent,
    canActivate: [AdminGuard]
  },
  { path: 'checkout', component: CheckoutComponent },
  { path: 'register-login', component: RegisterLoginComponent },
  {
    path: 'account',
    component: AccountComponent,
    children: [
      { path: '', redirectTo: 'profile', pathMatch: 'full' },
      { path: 'orders', component: OrdersComponent },
      { path: 'profile', component: ProfileComponent }
    ]
  },
  { path: 'order-complete', component: CompleteComponent },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [
    AdminGuard,
  ]
})
export class AppRoutingModule { }
