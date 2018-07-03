export class Admin {
    idadmin: number;
    identifiant: string;
    mdp: string;

    constructor(identifiant: string, mdp: string, idadmin?: number) {
        this.identifiant = identifiant;
        this.mdp = mdp;
        this.idadmin = idadmin;
    }
}
