package lib;

public class ConcreteStrategies implements DiscountStrategy{
    public double calculatePrice(CartItem item){
        return item.getincreaseQuantity();
    }
}
