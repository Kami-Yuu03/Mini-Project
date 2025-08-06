package lib;
    /** ADT
     */
public final class Product {

    private final String productId;
    private final String productName;
    private final double price;
    // Representation Invariant (RI):
    // - productId และ productName ต้องไม่เป็นค่าว่าง (null/blank)
    // - price ต้องไม่ติดลบ
    
    /**
     * ตรวจสอบว่า Rep เป็นจริงหรือไม่
     */
    public void checkRep(){
        if((productId == null) || (productId.isEmpty())){
            throw new RuntimeException("Product ID must not be null or blank.");
        }
        if((productName == null) || (productName.isEmpty())){
            throw new RuntimeException("Product name must not be null or blank.");
        }
        if(price < 0){
            throw new RuntimeException("Price must not be negative.");
        }
    }
    
    /**
     * Constructor เริ่มต้นรับ productId, productName, price และเรียก checkRep()
     * @param productId 
     * @param productName
     * @param price
     */
    public Product(String productId, String productName, double price){
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        checkRep();
    }


    
    public String getproductId(){
        return productId;
    }

    public String getproductName(){
        return productName;
    }

    public double getprice(){
        return price;
    }

    public boolean equals(String productId) {
        if(this.productId.equals(productId)) 
            return true;
        else
            return false;
    }
}
