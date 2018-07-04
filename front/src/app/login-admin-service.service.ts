import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Admin } from './admin';

@Injectable({
  providedIn: 'root'
})
export class LoginAdminServiceService {
  authenticated = false;

  constructor(private http: HttpClient) {
  }
  authenticate(credentials, callback) {

    const headers = new HttpHeaders(credentials ? {
      authorization: 'Basic ' + btoa(credentials.username + ':' + credentials.password)
    } : {});

    // A modifier avec la bonne url
    this.http.get('http://localhost:8080/De_Tendres_Animaux/api/admin/logadmin', { headers: headers }).subscribe(response => {
      if (response['username']) {
        this.authenticated = true;
      } else {
        this.authenticated = false;
      }
      return callback && callback();
    });

  }

}

