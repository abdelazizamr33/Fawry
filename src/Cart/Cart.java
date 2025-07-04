package Cart;

import Products.Product;
import Products.Shipable;

import java.util.ArrayList;
import java.util.List;

public class Cart
{
    protected List<CartItem> Items=new ArrayList<>();
    protected double TotalPrice=0;

    public void Add2Cart(Product product,int quantity)
    {
        if(product.CheckExpiration()&& product.IsExpirable())throw new RuntimeException(product.GetName() + " is expired and can't be added.");
        if(product.GetQuantity()<quantity) throw new RuntimeException("Not enough quantity for " + product.GetName());
        Items.add(new CartItem(product,quantity));
    }

    public boolean IsEmpty() {
        return Items.isEmpty();
    }

    public double CalculateTotalPrice()
    {
        for(CartItem item : Items)
        {
            double ItemPrice=item.product.GetPrice()* item.quantity;
            TotalPrice+=ItemPrice;
        }
        return TotalPrice;
    }
    public double GetTotalPrice()
    {
        return TotalPrice;
    }
    public List<CartItem> GetCartItems()
    {
        return Items;
    }

    public List<CartItem> GetShipableItems() {
        List<CartItem> shippables = new ArrayList<>();
        for (CartItem item : Items) {
            if (item.product.IsShippable()) {
                shippables.add(new CartItem(item.GetProduct(), item.quantity));
            }
        }
        return shippables;
    }
}
