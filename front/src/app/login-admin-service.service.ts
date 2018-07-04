import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Admin } from './admin';

@Injectable({
  providedIn: 'root'
})
export class LoginAdminServiceService {

  authenticated = false;
  loginUrl = 'http://localhost:8080/DeTendresAnimaux/api/admin/user';

  constructor(private http: HttpClient) {
  }

  authenticate(credentials, callback) {

    const headers = new HttpHeaders(credentials ? {
      authorization: 'Basic ' + btoa(credentials.username + ':' + credentials.password)
    } : {});

    if (this.authenticated === false && credentials) {
      sessionStorage.setItem('credentials', btoa(credentials.username + ':' + credentials.password));
      console.log('Credentials dans la session ' + sessionStorage.getItem('credentials'));
    }

    this.http.get(this.loginUrl, { headers: headers }).subscribe(response => {
      console.log('Headers : ' + headers);
      console.log('Headers : ' + headers.get('authorization'));
      console.log('Response : ' + response);
      if (response && response['name']) {
        this.authenticated = true;
      } else {
        this.authenticated = false;
      }
      return this.authenticated === true && callback && callback();
    });

  }

}

