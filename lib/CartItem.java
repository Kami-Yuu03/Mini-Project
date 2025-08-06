package lib;

/**
 * ADT
 */
public class CartItem {
    
    private final Product product;
    private int quantity;

    // Representation Invariant (RI)
    // - product ต้องไม่เป็น null
    // - quantity ต้องมากกว่า 0


    /**
     * Constructor เริ่มต้น รับ product, quantity และเรียก checkRep()
     * @param product
     * @param quantity
     */
    public CartItem(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
        checkRep();
    }

    /**
     *  ตรวจสอบว่า Rep เป็นจริงหรือไม่
     */
    public void checkRep(){
        if(product == null){
            throw new RuntimeException("Product must not be null");
        }
        if(quantity <= 0){
            throw new RuntimeException("Quantity must more than 0");
        }
    }

    public Product getproduct(){
        return product;
    }

    public double getquantity() {
        return quantity;
    }

    public void increaseQuantity(int amount){
        if(amount > 0){
            this.quantity += amount;
        }
        checkRep();
    }
}