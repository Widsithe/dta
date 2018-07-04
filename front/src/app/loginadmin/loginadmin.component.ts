import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoginAdminServiceService } from '../login-admin-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-loginadmin',
  templateUrl: './loginadmin.component.html',
  styleUrls: ['./loginadmin.component.scss']
})
export class LoginadminComponent {

  credentials = { username: '', password: '' };

  constructor(private loginService: LoginAdminServiceService, private http: HttpClient, private router: Router) {
    this.loginService = loginService;
  }
  login() {
    this.loginService.authenticate(this.credentials, () => {
      this.router.navigateByUrl('/admin');
    });
    return false;

  }
}
