/**
 * Abstract class representing a billable item with a description and unit price
 */
/**
 * Abstract class representing a billable item with a description and unit price
 *
 * @author john-michael.woodrow
 */
public abstract class BillableItem {
    private String id;
    private String description;
    private double price;
    private int quantity;

    /**
     * Constructs a BillableItem with an ID, description, unit price, and quantity
     *
     * @param id ID of the item
     * @param description Description of the item
     * @param price Unit price of the item
     * @param quantity Quantity of the item
     */
    public BillableItem(String id, String description, double price, int quantity) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Get the ID
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Set the ID
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the Description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the Description
     * @param description Description of the item
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the Unit Price
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the Unit Price
     * @param price Unit price of the item
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get the quantity
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Abstract method to calculate the subtotal for the item
     * @return subtotal as a double
     */
    public abstract double calculateSubtotal();
}
