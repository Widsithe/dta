import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoginAdminService } from '../login-admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-loginadmin',
  templateUrl: './loginadmin.component.html',
  styleUrls: ['./loginadmin.component.scss']
})
export class LoginadminComponent {

  credentials = { identifiant: '', mdp: '' };

  constructor(private loginService: LoginAdminService, private http: HttpClient, private router: Router) {
    this.loginService = loginService;
  }
  login() {
    console.log(this.credentials);
    this.loginService.authenticate(this.credentials, () => {
      this.router.navigateByUrl('/admin');
    });
    return false;

  }
}
