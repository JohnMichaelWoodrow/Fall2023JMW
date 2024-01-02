package assignment5;
/**
 * Assignment 5
 * Represents a product with an ID, description, and price
 * @author john-michael.woodrow
 */
public class Product {
    private int id;
    private String description;
    private double price;

    /**
     * Constructs a new Product
     * @param id          the product ID
     * @param description the product description
     * @param price       the product price
     */
    public Product(int id, String description, double price){
        this.id = id;
        this.description = description;
        this.price = price;
    }

    /**
     * Returns the product ID
     * @return the product ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the product ID. Prints an error message if ID is negative
     * @param id the new product ID
     */
    public void setId(int id) {
        if (id < 0) {
            System.err.println("Invalid ID");
        } else {
            this.id = id;
        }
    }

    /**
     * Returns the product description
     * @return the product description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the product description
     * @param description the new product description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the product price
     * @return the product price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the product price. Prints an error message if the price is negative
     * @param price the new product price
     */
    public void setPrice(double price) {
        if (price < 0) {
            System.err.println("Invalid Price");
        } else {
            this.price = price;
        }
    }
}
