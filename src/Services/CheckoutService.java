package Services;

import Cart.Cart;
import Cart.CartItem;
import Customer.Customer;

import java.util.List;

public class CheckoutService {
    protected static final double ShippingCost = 10;
    public static void CheckOut(Customer customer, Cart cart)
    {
        cart.CalculateTotalPrice();
        if(customer.GetBalance()<cart.GetTotalPrice()) throw new RuntimeException("Your Balace isn't enough");
        if(cart.IsEmpty())throw new RuntimeException("Empty Cart");
        double Total = cart.GetTotalPrice();
        double SubTotal = Total;
        double TotalShippingCost = 0;
        double TotalListQuantities=0;
        List<CartItem> shipables = cart.GetShipableItems();

        if (!shipables.isEmpty()) {
            for(CartItem item :shipables)
            {
                TotalListQuantities+=item.GetQuantity();
            }
            TotalShippingCost=TotalListQuantities*ShippingCost;
            Total += TotalShippingCost;
            ShippingService.ship(shipables);
        }

        System.out.println("\n** Checkout receipt **");
        for (CartItem item : cart.GetCartItems()) {
            System.out.println(item.GetQuantity() + "x " + item.GetProduct().GetName() + "  " + (int)(item.GetProduct().GetPrice() * item.GetQuantity()));
            item.GetProduct().ReduceQuantity(item.GetQuantity());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f\n", SubTotal);
        if (!shipables.isEmpty())
            System.out.printf("Shipping %.0f\n", TotalShippingCost);
        System.out.printf("Amount %.0f\n", Total);


    }
}
