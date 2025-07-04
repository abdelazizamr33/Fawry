package Products;

public class Product {
    protected String name;
    protected int quantity;
    protected double price;

    protected Expirable expirable;
    protected Shipable shipable;
    public Product(String name,int quantity,double price ,Expirable expirable, Shipable shipable)
    {
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.expirable = expirable;
        this.shipable = shipable;
    }

    public String GetName() {
        return name;
    }

    public double GetPrice() {
        return price;
    }

    public int GetQuantity() {
        return quantity;
    }

    public Shipable GetShipable()
    {
        return shipable;
    }

    public void ReduceQuantity(int amount) {
        quantity -= amount;
    }

    public boolean IsShippable() {
        return shipable != null;
    }

    public boolean IsExpirable() {
        return expirable != null;
    }

    public boolean CheckExpiration() {
        return expirable != null && expirable.IsExpired();
    }

}
