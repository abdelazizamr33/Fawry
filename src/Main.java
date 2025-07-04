import Cart.Cart;
import Customer.Customer;
import Products.Expirable;
import Products.Shipable;
import Products.Product;
import Services.CheckoutService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Customer customer=new Customer("Abdelaziz Amr",9000);

        // Case 1
        Product Cheese=new Product("cheese",10,44.5,new Expirable(LocalDate.of(2025,7,20)),new Shipable(400));
        Product Milk=new Product("Juhayna Milk",30,35,new Expirable(LocalDate.of(2025,4,25)),new Shipable(1000));
        Product tv=new Product("tv",15,1000,null,new Shipable(3000));
        Product ScratchCard=new Product("Mobile Scratch Card",50,5,null,null);
        Product Medicine=new Product("Medicine",20,22.5,new Expirable(LocalDate.of(2026,11,27)),null);

        System.out.println("case 1\n");
        System.out.println("working regular case \n");
        Cart MyCart=new Cart();
        try {
            MyCart.Add2Cart(Cheese, 2);
            MyCart.Add2Cart(tv, 1);
            MyCart.Add2Cart(ScratchCard, 5);
            CheckoutService.CheckOut(customer,MyCart);
        }catch (Exception e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }

        // case 2
        System.out.println("\n\ncase 2\n");
        System.out.println("not enough product case \n");

        try {
            MyCart.Add2Cart(Cheese, 11);
            CheckoutService.CheckOut(customer,MyCart);
        }catch (Exception e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }

        System.out.println("\n\ncase 3\n");
        System.out.println("No balance enough case \n");

        try {
            MyCart.Add2Cart(tv,10 );
            CheckoutService.CheckOut(customer,MyCart);
        }catch (Exception e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }

        System.out.println("\n\ncase 4\n");
        System.out.println("empty cart case \n");
        MyCart=new Cart();
        try {
            CheckoutService.CheckOut(customer,MyCart);
        }catch (Exception e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }

        System.out.println("\n\ncase 5\n");
        System.out.println("expired product case \n");
        try {
            MyCart.Add2Cart(Milk,1);
            CheckoutService.CheckOut(customer,MyCart);
        }catch (Exception e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }

    }
}