package lib.Strategies;
import lib.CartItem;

public class BulkDiscountStraregy implements DiscountStrategy{
    private final int minimumQuantity;
    private final double discountPercentage;
        
    public BulkDiscountStraregy(int minimumQuantity, double discountPercentage){
        this.minimumQuantity = minimumQuantity;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculatePrice(CartItem item){
        if(item.getquantity() >= minimumQuantity){
            return (item.getproduct().getprice() * item.getquantity()) * (1.0 - ())
        }
    }
}
