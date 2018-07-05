import { HttpInterceptor, HttpHandler, HttpRequest, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable()
export class TokenInterceptor implements HttpInterceptor {
    constructor() {}

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        if (sessionStorage.getItem('credentials')) {
            request = request.clone({
                setHeaders: {
                Authorization: `BASIC ${sessionStorage.getItem('credentials')}`
                }
            });
        }

      return next.handle(request);
    }
}
