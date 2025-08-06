package lib.Strategies;
import lib.CartItem;

public interface DiscountStrategy {
    public double calculatePrice(CartItem item);
}
