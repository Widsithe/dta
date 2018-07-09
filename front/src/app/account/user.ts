export class User {
    iduser?: number;
    identifiant: string;
    mdp: string;

    constructor(identifiant: string, mdp: string, iduser?: number) {
        this.identifiant = identifiant;
        this.mdp = mdp;
        this.iduser = iduser;
    }
}
