package lib;

import java.util.ArrayList;

/**
 * ADT
 */
public class ShoppingCart {
    private final ArrayList<CartItem> items = new ArrayList<>();
    private final PricingService service;
    private final ProductCatalog catalog;

    // Representation Invarian (RI)
    //
    //
    public ShoppingCart(PricingService service, ProductCatalog catalog){
        this.service = service;
        this.catalog = catalog;
        checkRep();
    }
    
    public void addItem(String productId, int quantity){
        if(quantity <= 0) return;

        Product product = catalog.findById(productId);
        if(product == null) return;

        for(CartItem item : items){
            if(item.getproduct().getproductId().equals(productId)){
                item.increaseQuantity(quantity);
                checkRep();
                return;
            }
        }

        items.add(new CartItem(product, quantity));
        checkRep();
    }

    public void removeItem(String productId){
        CartItem toRemove = null;
        for(CartItem item : items){
            if(item.getproduct().getproductId().equals(productId)){
                toRemove = item;
                break;
            }
        }
        if(toRemove != null){
            items.remove(toRemove);
        }
        checkRep();
    }

    public double getTotalPrice(){
        double sum = 0;
        for(int i = 0 ; i < items.size() ; i++){
            sum =  sum + service.calculateItemPrice(items.get(i));
        }
        return sum;
    }

    public int getItemCount(){
        return items.size();
    }

    public void clearCart(){
        items.clear();
        checkRep();
    }
    
    public void checkRep(){
        if(items == null){
            throw new RuntimeException("ArrayList must not be null");
        }
        for(int i = 0; i < items.size(); i++){
            for(int j = i + 1; j < items.size(); j++){
                if(items.get(i).getproduct().equals(items.get(j).getproduct())){
                    throw new RuntimeException("RI violated : CartItem must not duplicate products");
                }
            }
        }
    }


}
