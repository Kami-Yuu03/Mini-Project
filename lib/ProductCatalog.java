package lib;
import java.util.ArrayList;

public class ProductCatalog {

    ArrayList<Product> Catalog;

    // Representation Invariant (RI)
    // - ArrayList ต้องไม่เป็น null และห้ามมี Product ที่ซ้ำกัน

    public ProductCatalog(){
        Catalog = new ArrayList<>();
        checkRep();
    }

    public void checkRep(){
        if(Catalog == null){
            throw new RuntimeException("Catalog must not be null");
        }
        if(Catalog.equals(Catalog)){
            throw new RuntimeException("Product must not be same");
        }  
    }

    public void addProduct(Product product){
        //ตรวจสอบว่าค่าซ้ำกับที่มีอยู่ไหม
        if(product.getproductId() != null){
            System.out.println("มีสินค้านี้อยู่แล้ว");
            return;
        }
        Catalog.add(product);
        checkRep();
    }

    public Product findById(String productId){
        for(Product Id : Catalog){
            if(Id.getproductId().equals(productId)){
                return Id;
            }
        }
        checkRep();
        return null;
    }


}
