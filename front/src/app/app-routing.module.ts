import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './core/home/home.component';
import { CartComponent } from './cart/cart.component';
import { RegisterLoginComponent } from './account/register-login/register-login.component';
import { OrdersComponent } from './account/orders/orders.component';
import { ProfileComponent } from './account/profile/profile.component';
import { AccountComponent } from './account/account.component';
import { AdminSearchComponent } from './admin/admin-search/admin-search.component';
import { AdminProduitComponent } from './admin/admin-produit/admin-produit.component';
import { AdminCommandesComponent } from './admin/admin-commandes/admin-commandes.component';
import { LoginadminComponent } from './admin/loginadmin/loginadmin.component';
import { AdminComponent } from './admin/admin.component';
import { AdopterComponent } from './adopter/adopter.component';
import { AnimauxListComponent } from './products/animaux-list/animaux-list.component';
import { AnimauxDetailComponent } from './products/animaux-detail/animaux-detail.component';
import { AdminGuard } from './admin/shared/admin.guard';
import { AddEditComponent } from './admin.1/add-edit/add-edit.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { OrderCompleteComponent } from './cart/order-complete/order-complete.component';

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
    path: 'admin/login-admin',
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
    path: 'cart',
    component: CartComponent,
    data: { title: 'Votre panier' }
  },
  {
    path: 'admin/search',
    component: AdminSearchComponent,
    data: { title: 'Recherche' }
  },
  { path: '', redirectTo: '/accueil', pathMatch: 'full' },
  { path: 'accueil', component: HomeComponent },
  { path: 'animaux', component: AnimauxListComponent },
  { path: 'animaux/:id', component: AnimauxDetailComponent },
  { path: 'cart', component: CartComponent },
  { path: 'admin/add', component: AddEditComponent, canActivate: [AdminGuard] },
  {
    path: 'admin/edit/:id',
    component: AddEditComponent,
    canActivate: [AdminGuard]
  },
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
  { path: 'order-complete', component: OrderCompleteComponent },
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
