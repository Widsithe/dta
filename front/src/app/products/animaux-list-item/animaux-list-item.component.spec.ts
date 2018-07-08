import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnimauxListItemComponent } from './animaux-list-item.component';

describe('AnimauxListItemComponent', () => {
  let component: AnimauxListItemComponent;
  let fixture: ComponentFixture<AnimauxListItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnimauxListItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnimauxListItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
