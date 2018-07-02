import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-loginadmin',
  templateUrl: './loginadmin.component.html',
  styleUrls: ['./loginadmin.component.scss']
})
export class LoginadminComponent implements OnInit {
  private _box = true;
  private _outlined = false;
  rtl = false;
  disabled = false;
  required = false;
  persistent = false;
  dense = false;
  field1: string;
  field2: string;

  get dir() {
    return this.rtl ? 'rtl' : null;
  }

  get box() {
    return this._box;
  }

  set box(value: boolean) {
    this._box = value;
    if (value) {
      this._outlined = false;
    }
  }

  get outlined() {
    return this._outlined;
  }

  set outlined(value: boolean) {
    this._outlined = value;
    if (value) {
      this._box = false;
    }
  }
  constructor() { }

  ngOnInit() {
  }

}
