package Cart;

import Products.Product;

public class CartItem {
    Product product;
    int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product GetProduct()
    {
        return product;
    }
    public int GetQuantity()
    {
        return quantity;
    }

}
