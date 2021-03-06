import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { finalize } from 'rxjs/operators';
import { LoginAdminService } from '../../admin/loginadmin/login-admin.service';

@Component({
  selector: 'app-menuadmin',
  templateUrl: './menuadmin.component.html',
  styleUrls: ['./menuadmin.component.scss']
})
export class MenuadminComponent implements OnInit {

  constructor(private loginService: LoginAdminService, private http: HttpClient, private router: Router) { }

  ngOnInit() {
  }
  logout() {
    this.http.post('', {}).pipe(finalize(() => {
      this.loginService.authenticated = false;
      this.router.navigateByUrl('/login-admin');
    })).subscribe();
  }
}
