export class Product {
  constructor(
    public nom: string = '',
    public stock: number = 0,
    public prix: number = 0,
    public description: string = '',
    public type: string = '',
    public image: string = '',
    public idproduit?: number,
  ) { }
}
