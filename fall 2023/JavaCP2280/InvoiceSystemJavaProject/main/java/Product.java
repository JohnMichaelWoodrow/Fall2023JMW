/**
 * Class representing a product, extending the BillableItem class
 *
 * @author john-michael.woodrow
 */
public class Product extends BillableItem {
    /**
     * Constructs a Product with an ID, description, price, and quantity
     *
     * @param id ID of the product
     * @param description Description of the product
     * @param price Price of the product
     * @param quantity Quantity of the product
     */
    public Product(String id, String description, double price, int quantity) {
        super(id, description, price, quantity);
    }

    /**
     * Calculates the subtotal of product
     * @return subtotal
     */
    public double calculateSubtotal() {
        return getPrice() * getQuantity();
    }

    /**
     * Print the string nicely
     * @return String
     */
    @Override
    public String toString() {
        return "Product ID: " + getId() + ", Description: " + getDescription() + ", Price: " + getPrice();
    }
}
