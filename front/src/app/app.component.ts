import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { finalize } from 'rxjs/operators';
import { LoginAdminService } from './login-admin.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'De Tendres Animaux';

  constructor(private loginService: LoginAdminService, private http: HttpClient, private router: Router) {
  }
  authenticated() {
    return this.loginService.authenticated;
  }
  logout() {
    this.http.post('logout', {}).pipe(finalize(() => {
      this.loginService.authenticated = false;
      this.router.navigateByUrl('/login-admin');
    })).subscribe();
  }
}
