import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { LoginUserService } from '../login-user.service';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.scss']
})
export class ConnexionComponent {

  credentials = { identifiant: '', mdp: '' };

  constructor(private loginService: LoginUserService, private http: HttpClient, private router: Router) {
    this.loginService = loginService;
   }
   login() {
    console.log(this.credentials);
    this.loginService.userAuthenticate(this.credentials, () => {
      this.router.navigateByUrl('/');
    });
    return false;

  }


}
