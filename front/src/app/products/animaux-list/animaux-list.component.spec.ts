import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnimauxListComponent } from './animaux-list.component';

describe('AnimauxListComponent', () => {
  let component: AnimauxListComponent;
  let fixture: ComponentFixture<AnimauxListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnimauxListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnimauxListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
