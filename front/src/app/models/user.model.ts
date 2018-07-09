import { Order } from './order.model';

export interface Roles {
  admin: boolean;
}

export class User {
  public email: string;
  public photoURL?: string;
  public roles?: Roles;
  public firstName?: string;
  public lastName?: string;
  public password?: string;
  public orders?: object;
  public confirmPassword?: string;
  public uid?: string;

  constructor(authData) {
    this.email = authData.email;
  //  this.firstName = firstName;
  //  this.lastName = lastName;
    this.roles = {
      admin: false
    };
  }
}
