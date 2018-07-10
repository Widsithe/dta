import { Injectable } from '@angular/core';
import { User } from './user.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class UserService {
  static readonly restApi = 'http://localhost:8080/DeTendresAnimaux/api/user';

  constructor(private httpClient: HttpClient) {
    this.httpClient = httpClient;
  }

  userAuthentification(username, password): Observable<any> {
    return this.httpClient.post('http://localhost:8080/DeTendresAnimaux/authenticate?username=' + username + '&password=' + password, null);
  }

  registerUser(user: User): Observable<any> {
    return this.httpClient.post(UserService.restApi, user);
  }

  // get user name from session then get from server
  getConnectedUser(): Observable<any> {
    return this.getUser(sessionStorage.getItem('user'));
  }

  getConnectedUserInSession() {
    return sessionStorage.getItem('user');
  }

  setConnectedUser(u: User) {
    sessionStorage.setItem('user', u.mail);
  }

  updateUser(u: User): Observable<any> {
    return this.httpClient.put(UserService.restApi, u);
  }

  getUser(username): Observable<any> {
    username = username || '';
    return this.httpClient.get(UserService.restApi + '/byName?name=' + username);
  }

  getUserById(id): Observable<any> {
    return this.httpClient.get(UserService.restApi + '/' + id);
  }

  removeConnectedUser() {
    return sessionStorage.removeItem('user');
  }

  logout() {
    return this.httpClient.post('http://localhost:8080/DeTendresAnimaux/logout', {}).subscribe();
  }
}
