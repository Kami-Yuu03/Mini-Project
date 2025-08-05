package lib;

public class ConcreteStrategies{

    private double Overallprice = 0, sum_price = 0;

    public class DefaultPricingStrategy implements DiscountStrategy{
        public double calculatePrice(CartItem item) {
            return item.getproduct().getprice() * item.getquantity();
        }
    }

    public class BogoDiscountStrategy implements DiscountStrategy{
        public double calculatePrice(CartItem item){
            if((item.getquantity() < 0) || (item.getproduct().getprice() < 0)){
                return 0.0 ;
            } else if ((item.getproduct().getproductId().equals("BOGO"))) {
                if (item.getquantity() % 2 == 0)
                    Overallprice += ( (item.getquantity() / 2) * item.getproduct().getprice() ) ;
                if (item.getquantity() % 2 == 1)
                    Overallprice += ( (((item.getquantity() - 1) / 2) * item.getproduct().getprice()) + item.getproduct().getprice() ) ;
            }
            return Overallprice ;
        }
    }
    
    public class BulkDiscountStraregy implements DiscountStrategy{
        
        public double calculatePrice(CartItem item){
            if ((item.getproduct().getproductId().equals("BULK"))) {
                Overallprice += sum_price * 0.9 ;
            } else {
                Overallprice += sum_price ;
            }   
        }
    }
}
