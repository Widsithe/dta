export class Product {
    idproduit: number;
    nom: string;
    stock: number;
    prix: number;
    description: string;
    type: string;
    image: string;

    constructor(
    nom: string,
    stock: number,
    prix: number,
    description: string,
    type: string,
    image: string,
    idproduit?: number,
    ) {
        this.nom = nom;
        this.stock = stock;
        this.prix = prix;
        this.description = description;
        this.type = type;
        this.image = image;
        this.idproduit = idproduit;
    }
}

export const PRODUCTS = [
    {
        nom: 'Manon le dindon',
        stock: 50,
        prix: 49.99,
        description: 'Ceci est un dindon',
        type: 'Aves',
        image: '../assets/images/products/dindon.png',
        id: 1,
    }
];
