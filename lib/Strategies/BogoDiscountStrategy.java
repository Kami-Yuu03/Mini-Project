package lib.Strategies;
import lib.CartItem;

public class BogoDiscountStrategy implements DiscountStrategy{ 
    
    @Override   
    public double calculatePrice(CartItem item){
        double quantity = item.getquantity();
        double price = item.getproduct().getprice();
        if(quantity == 1){
            return price * quantity;
        } else {
            return price * (quantity / 2)+(quantity % 2);
        }
    }
}
