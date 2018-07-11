export class Product {
    idproduit: number;
    nom: string;
    type: string;
    prix: number;
    stock: number;
    image: string;
    active: Boolean;
    description: string;

    constructor(idproduit: number,
        nom: string,
        type: string,
        prix: number,
        stock: number,
        image: string,
        active: boolean,
        description: string) {

        this.idproduit = idproduit;
        this.nom = nom;
        this.type = type;
        this.prix = prix;
        this.stock = stock;
        this.image = image ;
        this.active = active;
        this.description = description;
    }

    static fromJson(jsonObj) {
        return new Product(jsonObj.idproduit,
            jsonObj.nom,
            jsonObj.type,
            jsonObj.prix,
            jsonObj.stock,
            jsonObj.image,
            jsonObj.active,
            jsonObj.description);
    }
}
