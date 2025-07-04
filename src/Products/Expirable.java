package Products;

import Interfaces.IExpirable;

import java.time.LocalDate;

public class Expirable implements IExpirable {

    protected LocalDate ExpireDate;

    public Expirable(LocalDate ExpireDate)
    {
        this.ExpireDate=ExpireDate;
    }

    public boolean IsExpired()
    {
        if(LocalDate.now().isAfter(ExpireDate)) return true;
        return false;
    }


}
