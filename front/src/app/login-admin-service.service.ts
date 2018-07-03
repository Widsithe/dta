import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Admin } from './admin';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};
@Injectable({
  providedIn: 'root'
})
export class LoginAdminServiceService {
  urlService: string;
  constructor(private http: HttpClient) {
    this.urlService = 'http://localhost:8080/';
  }
  addAdmin(admin: Admin) {
    this.http.post<Admin>(this.urlService, admin, httpOptions).subscribe();
  }
}

