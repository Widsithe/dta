import { Component, OnInit } from '@angular/core';
import { LoginAdminService } from '../login-admin.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.scss']
})
export class ConnexionComponent {

  credentials = { identifiant: '', mdp: '' };

  constructor(private loginService: LoginAdminService, private http: HttpClient, private router: Router) {
    this.loginService = loginService;
   }
   login() {
    console.log(this.credentials);
    this.loginService.authenticate(this.credentials, () => {
      this.router.navigateByUrl('/');
    });
    return false;

  }


}
