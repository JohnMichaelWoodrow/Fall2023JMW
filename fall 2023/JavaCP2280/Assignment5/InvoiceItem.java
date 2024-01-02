package assignment5;
/**
 * Assignment 5
 * Represents an invoice item with a Product and quantity
 * @author john-michael.woodrow
 */
public class InvoiceItem {
    private Product product;
    private int quantity;

    /**
     * Constructs a new InvoiceItem
     * @param product  the product
     * @param quantity the quantity of the product
     * If quantity less than 0 program will break
     */
    public InvoiceItem(Product product, int quantity) {
        this.product = product;
        if (quantity >= 0){
            this.quantity = quantity;
        }
    }

    /**
     * Returns the product
     * @return the product
     */
    public Product getProduct() {

        return product;
    }

    /**
     * Sets the product
     * @param product the new product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Returns the quantity of the product
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity. Prints an error message if the quantity is negative
     * @param quantity the new quantity
     */
    public void setQuantity(int quantity) {
        if (quantity < 0) {
            System.err.println("Invalid Quantity");
        } else {
            this.quantity = quantity;
        }
    }

    /**
     * Computes and returns the total for the invoice item
     * @return the item total (product price * quantity)
     */
    public double getItemTotal() {
        return product.getPrice() * quantity;
    }
}
