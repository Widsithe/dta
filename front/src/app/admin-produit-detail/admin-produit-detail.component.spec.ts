import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminProduitDetailComponent } from './admin-produit-detail.component';

describe('AdminProduitDetailComponent', () => {
  let component: AdminProduitDetailComponent;
  let fixture: ComponentFixture<AdminProduitDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminProduitDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminProduitDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
