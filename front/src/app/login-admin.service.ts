import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpUserEvent } from '@angular/common/http';
import { Admin } from './admin';

@Injectable({
  providedIn: 'root'
})
export class LoginAdminService {

  authenticated = false;
  loginUrl = 'http://localhost:8080/DeTendresAnimaux/api/user';

  constructor(private http: HttpClient) {
  }

  authenticate(credentials, callback) {

    const headers = new HttpHeaders(credentials ? {
      authorization: 'Basic ' + btoa(credentials.identifiant + ':' + credentials.mdp)
    } : {});


    this.http.get(this.loginUrl, { headers: headers }).subscribe(response => {
      console.log(response);
      if (response && response['name']) {
        if (credentials) {
          sessionStorage.setItem('auth', btoa(credentials.identifiant + ':' + credentials.mdp));
        }
        this.authenticated = true;
      } else {
        this.authenticated = false;
      }
      return this.authenticated === true && callback && callback();
    });
  }
}

