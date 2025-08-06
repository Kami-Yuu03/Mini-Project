package lib.Strategies;
import lib.CartItem;

public class BulkDiscountStrategy implements DiscountStrategy{
    private final int minimumQuantity;
    private final double discountPercentage;
        
    public BulkDiscountStrategy(int minimumQuantity, double discountPercentage){
        this.minimumQuantity = minimumQuantity;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculatePrice(CartItem item){
        double originalPrice = item.getproduct().getprice() * item.getquantity();
        if(item.getquantity() >= minimumQuantity){
            return (originalPrice) * (1.0 - discountPercentage);
        } else {
            return originalPrice;
        }
    }
}
