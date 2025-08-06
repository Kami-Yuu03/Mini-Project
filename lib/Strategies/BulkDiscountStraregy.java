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
        double originalPrice = item.getproduct().getprice() * item.getquantity();
        if(item.getquantity() >= minimumQuantity){
            return (originalPrice) * (1.0 - (discountPercentage * 0.01));
        } else {
            return originalPrice;
        }
    }
}
