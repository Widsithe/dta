import { Injectable } from '@angular/core';
import {
  CanActivate,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  Router
} from '@angular/router';
import { Observable } from 'rxjs';

import { take ,  tap ,  map } from 'rxjs/operators';
import { LoginUserService } from '../login-user.service';

@Injectable()
export class UserGuard {
  constructor(private authService: LoginUserService, private router: Router) {}
/*
  public canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<boolean> | Promise<boolean> | boolean {
    return this.authService.user.pipe(
      take(1),
      map((user) => (user ? true : false)),
      tap((authorized) => {
        if (!authorized) {
          this.router.navigate(['/register-login']);
        }
      })
    );
  }*/
}
