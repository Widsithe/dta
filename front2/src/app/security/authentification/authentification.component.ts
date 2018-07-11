import { Component, OnInit } from '@angular/core';
import { User } from './../../user/user.model';
import { NgForm, Validators, FormControl } from '@angular/forms';
import { UserService } from './../../user/user.service';
import { Message } from 'primeng/components/common/api';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-authentification',
  templateUrl: './authentification.component.html',
  styleUrls: ['./authentification.component.scss']
})

export class AuthentificationComponent implements OnInit {
  user: User = new User(0, '', '', '', '', '', '', '');
  msgs: Message[] = [];

  constructor(private userService: UserService, private activRoute: ActivatedRoute, private router: Router) {
    this.userService = this.userService;
    this.activRoute = activRoute;
    this.router = router;
    this.activRoute.queryParamMap.subscribe(map => {
      if (!map.get('severity')) {
        return;
      }
      this.msgs.push({ severity: map.get('severity'), summary: map.get('summary'), detail: map.get('message') });
    });
  }

  resetForm(form?: NgForm) {
    if (form != null) {
      form.reset();
    }

    this.user = new User(0, '', '', '', '', '', '', '');
  }

  ngOnInit() {
  }

  OnSubmit(form: NgForm) {
    this.msgs = [];
    this.userService.userAuthentification(form.value.UserName, form.value.Password)
      .subscribe((data: any) => {
        this.userService.getUser(form.value.UserName).subscribe(user => this.userService.setConnectedUser(User.fromJSON(user)));
        this.router.navigate(['/Products']);
      },
        error => this.msgs.push({
          severity: 'error',
          summary: 'Oups !',
          detail: 'Votre authentification à échoué. Vérifiez les valeurs saisies ou créez votre compte.'
        }));
  }


}
