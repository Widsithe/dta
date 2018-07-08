import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnimauxDetailComponent } from './animaux-detail.component';

describe('AnimauxDetailComponent', () => {
  let component: AnimauxDetailComponent;
  let fixture: ComponentFixture<AnimauxDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnimauxDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnimauxDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
