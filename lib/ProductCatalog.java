package lib;
import java.util.ArrayList;

public class ProductCatalog {

    ArrayList<Product> products = new ArrayList<>();

    // Representation Invariant (RI)
    // - ArrayList ต้องไม่เป็น null และห้ามมี Product ที่ซ้ำกัน

    public void checkRep(){
        if(products == null){
            throw new RuntimeException("Product must not be null");
        }
        for (int i = 0; i < products.size(); i++){
            for(int j = i + 1 ; j < products.size(); j++){
                if (products.get(i).equals(products.get(j))){
                    throw new RuntimeException("RI violated : Catalog contains duplicate products.");
                }
            }
        }
    }

    public ProductCatalog(){
        checkRep();
    }

    public void addProduct(Product product){
        if((product != null) && (!products.contains(product))){
            products.add(product);
        }
        checkRep();
    }

    public Product findById(String productId){
        for(Product Id : products){
            if(Id.getproductId().equals(productId)){
                return Id;
            }
        }
        return null;
    }


}
