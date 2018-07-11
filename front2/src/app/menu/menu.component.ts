import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { User } from './../user/user.model';
import { UserService } from './../user/user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})

export class MenuComponent implements OnInit {
  items: MenuItem[];
  user: User;

  constructor(private uServ: UserService, private route: ActivatedRoute, private router: Router) {
    this.uServ = uServ;
    this.route = route;
    this.router = router;
  }

  ngOnInit() {
    console.log(this.user.id);
    this.uServ.getConnectedUser().subscribe(user => {
      if (user.state && user.state === 'failed') {
        this.buildItems();
      } else {
        this.buildItems(User.fromJSON(user));
      }
    });
  }

  buildItems(u?: User) {
    if (u && u.role && u.role.toLowerCase() === 'admin') {
      this.items.push({ label: 'Produits', routerLink: '/AdminProducts' }, { label: 'Commandes', routerLink: '/AdminOrders' });
    }
  }

  goToCart() {
    this.router.navigate(['/profil'], {
      queryParams: {
        page: 'panier'
      }
    });
  }

  goToProfile() {
    if (this.uServ.getConnectedUserInSession()) {
      this.router.navigate(['/profil']);
    } else { this.router.navigate(['/authentification'], {
      queryParams: {
        severity: 'warn',
        summary: 'Attention ! Vous n"êtes pas connecté',
        message: 'Connectez-vous pour accéder à votre profil.'
      }
    });
    }
  }

  logout() {
    this.uServ.logout();
    sessionStorage.clear();
    this.router.navigate(['/authentification']);
  }

}
