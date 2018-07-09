import { Component, OnInit } from '@angular/core';
import { LoginAdminService } from './loginadmin/login-admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {
  title = 'Demo';
  greeting = {};


  constructor(private loginService: LoginAdminService) {

  }
  authenticated() {
    return this.loginService.authenticated;
  }
  ngOnInit() {
  }

}
