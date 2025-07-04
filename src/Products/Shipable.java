package Products;

import Interfaces.IShipable;

public class Shipable implements IShipable {
    protected double weight;
    protected String name;

    public Shipable(double weight)
    {
        this.weight=weight;
    }
    @Override
    public double GetWeight() {
        return weight;
    }

    @Override
    public String GetName() {
        return name;
    }

}
