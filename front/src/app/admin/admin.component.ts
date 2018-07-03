import { Component, OnInit } from '@angular/core';
import { LoginAdminServiceService } from '../login-admin-service.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {
  title = 'Demo';
  greeting = {};

  constructor(private loginService: LoginAdminServiceService, private http: HttpClient) {
    http.get('resource').subscribe(data => this.greeting = data);
  }
  authenticated() {
    return this.loginService.authenticated;
  }

  ngOnInit() {
  }

}
