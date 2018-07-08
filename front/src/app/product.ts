export class Product {
    constructor(public id: number, public first_name: String, public added: boolean, public last_name: String, public current_location: String, public current_company: String, public total_experience: String, profile_picture: String, current_role: String) { 

    }
}

export const productsCollection = [
    {
        id: 1,
        name: 'United Color beniton',
        price: 499.99,
        currency: 'EUR',
        image: 'images/01.jpg',
        url: 'https://static2.jassets.com/p/Puma-917-Mid-2.0-Ind.-Blue-Sneakers-4118-935263-1-product2.jpg'
    }
];
