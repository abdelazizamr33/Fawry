package Customer;

public class Customer {
    protected String name;
    protected double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }


    public double GetBalance()
    {
        return balance;
    }
}
