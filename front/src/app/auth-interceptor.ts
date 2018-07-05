import {
    HttpEvent,
    HttpInterceptor,
    HttpHandler,
    HttpRequest,
} from '@angular/common/http';
import { Observable } from 'rxjs';

let clonedRequest;

export class AuthInterceptor implements HttpInterceptor {
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        if (sessionStorage.getItem('auth')) {
            clonedRequest = req.clone({ headers: req.headers.set('Authorization', 'Basic ' + sessionStorage.getItem('auth')) });
        } else {
            clonedRequest = req;
        }
        return next.handle(clonedRequest);
    }
}
