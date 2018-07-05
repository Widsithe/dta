import { Component, OnInit } from '@angular/core';
import { LoginAdminService } from '../login-admin.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {
  title = 'Demo';
  greeting = {};


  constructor(private loginService: LoginAdminService, private http: HttpClient) {
    http.get('resource').subscribe(data => this.greeting = data);
  }
  authenticated() {
    return this.loginService.authenticated;
  }
  getHello() {
    return this.http.get('http://localhost:8080/DeTendresAnimaux/api/admin/hello', httpOptions).subscribe();
  }
  ngOnInit() {
  }

}
