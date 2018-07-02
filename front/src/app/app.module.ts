import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import {MatMenuModule} from '@angular/material/menu';

import { AdopterComponent } from './adopter/adopter.component';
import { AnimauxComponent } from './animaux/animaux.component';
import { AnimauxDetailComponent } from './animaux-detail/animaux-detail.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { AdminComponent } from './admin/admin.component';
import { LoginadminComponent } from './loginadmin/loginadmin.component';
import { PanierComponent } from './panier/panier.component';

@NgModule({
  declarations: [
    AppComponent,
    AdopterComponent,
    AnimauxComponent,
    AnimauxDetailComponent,
    ConnexionComponent,
    AdminComponent,
    LoginadminComponent,
    PanierComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
    MatMenuModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
