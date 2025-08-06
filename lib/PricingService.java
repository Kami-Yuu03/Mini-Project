package lib;

import java.util.ArrayList;
import lib.Strategies.*;

public class PricingService {

    private record StrategyRule(String sku, DiscountStrategy strategy) {}

    private ArrayList<StrategyRule> strategies = new ArrayList<>();
    private DiscountStrategy defaultStrategy = new DefaultPricingStrategy();

    public void addStrategy(String sku, DiscountStrategy strategy){
        StrategyRule skuRemove = null;
        for(StrategyRule rule : strategies){
            if(rule.sku().equals(sku)){
                skuRemove = rule;
                break;
            }
        }
        if(skuRemove != null){
            strategies.remove(skuRemove);
        }
        strategies.add(new StrategyRule(sku, strategy));
    }

    public double calculateItemPrice(CartItem item){
        String sku = item.getproduct().getproductId();
        for(StrategyRule rule : strategies){
            if(rule.sku().equals(sku)){
                return rule.strategy().calculatePrice(item);
            }
        }
        return defaultStrategy.calculatePrice(item);
    }
}
