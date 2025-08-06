package lib.Strategies;
import lib.CartItem;

public class BogoDiscountStrategy implements DiscountStrategy{ 
    
    @Override   
    public double calculatePrice(CartItem item){
        double originalPrice = item.getproduct().getprice() * item.getquantity();
        if(item.getquantity() % 2 == 0){
            return originalPrice / 2;
        } else if (item.getquantity() % 2 == 1){
            return (originalPrice - item.getproduct().getprice());
        } else {
            return originalPrice;
        }
    }
}
