import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { finalize } from 'rxjs/operators';
import { LoginAdminService } from './login-admin.service';
import { LoginUserService } from './login-user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'De Tendres Animaux';

  constructor(private loginService: LoginAdminService,
    private userloginService: LoginUserService, private http: HttpClient, private router: Router) {
  }
  adminAuthenticated() {
    return this.loginService.authenticated;
  }
  userAuthenticated() {
    return this.userloginService.userauthenticated;
  }
  logout() {
    this.http.post('logout', {}).pipe(finalize(() => {
      this.loginService.authenticated = false;
      this.router.navigateByUrl('/login-admin');
    })).subscribe();
  }
}
