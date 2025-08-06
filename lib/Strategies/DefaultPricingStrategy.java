package lib.Strategies;
import lib.CartItem;

public class DefaultPricingStrategy implements DiscountStrategy{
    @Override
    public double calculatePrice(CartItem item) {
        return item.getproduct().getprice() * item.getquantity();
    }
 }
