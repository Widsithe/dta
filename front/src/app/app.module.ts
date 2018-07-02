import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';

import { FormsModule } from '@angular/forms';

import { MaterialModule } from '@blox/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { MatMenuModule } from '@angular/material/menu';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatBadgeModule } from '@angular/material/badge';
import { MatIconModule } from '@angular/material/icon';


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



const appRoutes: Routes = [
  {
    path: 'adopter',
    component: AdopterComponent,
    data: { title: 'Tous nos animaux' }
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
    MenuloginComponent
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
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
