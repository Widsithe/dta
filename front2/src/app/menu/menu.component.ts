import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { User } from './../user.model';
import { UserService } from '../user.service';
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
    this.uServ.getConnectedUser().subscribe(user => {
      if(user.state && user.state=='failed') this.buildItems();
      else this.buildItems(User.fromJSON(user));
    });
  }

  buildItems(u?: User) {
    this.items = [{ label: "Shopping", icon: "fa fa-shopping-cart", routerLink: "/Products" }];
    if (u && u.role && u.role.toLowerCase() == "admin") {
      this.items.push({ label: "Gestion des produits", routerLink: '/AdminProducts' }, { label: "Gestion des commandes", routerLink: '/AdminOrders' });
    }
  }

  goToCart() {
    this.router.navigate(['/Profile'], {
      queryParams: {
        page: "panier"
      }
    })
  }

  goToProfile() {
    if (this.uServ.getConnectedUserInSession()) this.router.navigate(['/Profile']);
    else this.router.navigate(["/authentification"], {
      queryParams: {
        severity: "warn",
        summary: "Vous n'êtes pas connecté",
        message: "Connectez-vous afin de pouvoir accéder à votre profile."
      }
    });
  }

  logout() {
    this.uServ.logout();
    sessionStorage.clear();
    this.router.navigate(['/authentification']);
  }

}
