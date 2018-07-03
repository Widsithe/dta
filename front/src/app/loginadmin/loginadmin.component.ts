import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoginAdminServiceService } from '../login-admin-service.service';

@Component({
  selector: 'app-loginadmin',
  templateUrl: './loginadmin.component.html',
  styleUrls: ['./loginadmin.component.scss']
})
export class LoginadminComponent implements OnInit {

  constructor(private loginService: LoginAdminServiceService) {
    this.loginService = loginService;
   }

  ngOnInit() {
  }

}
