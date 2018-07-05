import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpUserEvent } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginUserService {

  userauthenticated = false;
  loginUrl = 'http://localhost:8080/DeTendresAnimaux/api/user';

  constructor(private http: HttpClient) { }
  userAuthenticate(credentials, callback) {

    const headers = new HttpHeaders(credentials ? {
      authorization: 'Basic ' + btoa(credentials.identifiant + ':' + credentials.mdp)
    } : {});


    this.http.get(this.loginUrl, { headers: headers }).subscribe(response => {
      console.log(response);
      if (response && response['name']) {
        if (credentials) {
          sessionStorage.setItem('auth', btoa(credentials.identifiant + ':' + credentials.mdp));
        }
        this.userauthenticated = true;
      } else {
        this.userauthenticated = false;
      }
      return this.userauthenticated === true && callback && callback();
    });
  }
}
