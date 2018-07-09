export class User {
    id:number;
    lastName: string;
    firstName: string;
    mail: string;
    address: string;
    phone: string;
    role: string;
    password: string;

    constructor(id:number, lastName: string, firstName: string, mail: string, address: string, phone: string, role: string, pwd: string) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.mail = mail;
        this.address = address;
        this.phone = phone;
        this.password = pwd;
        this.role = role;
        this.id = id;
    }

    static fromJSON(jsonObj) {
        if (jsonObj == null) return null;
        return new User(jsonObj.id,jsonObj.lastname, jsonObj.firstname, jsonObj.mail, jsonObj.address, jsonObj.phone, jsonObj.role, jsonObj.password);
    }
}
