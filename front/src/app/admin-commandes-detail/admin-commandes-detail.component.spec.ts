import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCommandesDetailComponent } from './admin-commandes-detail.component';

describe('AdminCommandesDetailComponent', () => {
  let component: AdminCommandesDetailComponent;
  let fixture: ComponentFixture<AdminCommandesDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminCommandesDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCommandesDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
