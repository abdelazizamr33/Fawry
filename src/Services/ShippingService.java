package Services;

import Cart.CartItem;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShippingService {

    public static void ship(List<CartItem> items)
    {
        if (items.isEmpty()) return;

        System.out.println("** Shipment notice **");
        Map<String, Integer> count = new HashMap<>();
        double totalWeight = 0;

        for (CartItem item : items) {
            String label = item.GetProduct().GetName() + "       " + (int)(item.GetProduct().GetShipable().GetWeight()) + "g\n";
            System.out.print(label);
            count.put(label, count.getOrDefault(label, 0) + 1);
            totalWeight += item.GetProduct().GetShipable().GetWeight();
        }



        System.out.printf("Total package weight %.1fkg\n", totalWeight/1000,"\n\n");
    }
}
