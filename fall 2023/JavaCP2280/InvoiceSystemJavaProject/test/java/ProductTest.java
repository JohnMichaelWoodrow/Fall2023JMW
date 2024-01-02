import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A class to test the Product class
 *
 * @author john-michael.woodrow
 */
public class ProductTest {
    /**
     * Test the Product constructor
     */
    @Test
    public void testProductConstructor() {
        String expectedId = "1";
        String expectedDescription = "Graphics Card";
        double expectedPrice = 250.00;
        int expectedQuantity = 2;
        Product product = new Product(expectedId, expectedDescription, expectedPrice, expectedQuantity);
        assertNotNull(product, "Product object should be created");
    }

    /**
     * Test the getId method
     */
    @Test
    public void testGetId() {
        String expectedId = "4";
        BillableItem product = new Product(expectedId, "Graphics Card", 2, 3);
        assertEquals(expectedId, product.getId(), "ID getter should return the default ID value");
    }

    /**
     * Test the getDescription method
     */
    @Test
    public void testGetDescription() {
        String expectedDescription = "Graphics Card";
        BillableItem product = new Product("1", "Graphics Card", 2, 3);
        assertEquals(expectedDescription, product.getDescription(), "Description getter should return the expected description");
    }

    /**
     * Test the getPrice method
     */
    @Test
    public void testGetPrice() {
        double expectedPrice = 250.00;
        BillableItem product = new Product("1", "Graphics Card", expectedPrice, 3);
        assertEquals(expectedPrice, product.getPrice(), 0.001, "Price getter should return the expected price");
    }

    /**
     * Test the getQuantity method
     */
    @Test
    public void testGetQuantity() {
        int expectedQuantity = 2;
        BillableItem product = new Product("1", "Graphics Card", 2, expectedQuantity);
        assertEquals(expectedQuantity, product.getQuantity(), "Quantity getter should return the expected quantity");
    }

    /**
     * Test the setQuantity method
     */
    @Test
    public void testSetQuantity() {
        int newQuantity = 5;
        BillableItem product = new Product("1", "Graphics Card", 2, newQuantity);
        product.setQuantity(newQuantity);
        assertEquals(newQuantity, product.getQuantity(), "Quantity setter should update the quantity to the expected value");
    }

    /**
     * Test the calculateSubtotal method
     */
    @Test
    public void testCalculateSubtotal() {
        double price = 250.00;
        int quantity = 2;
        double expectedSubtotal = price * quantity;
        BillableItem product = new Product("1", "Graphics Card", price, quantity);
        assertEquals(expectedSubtotal, product.calculateSubtotal(), 0.001, "calculateSubtotal should return the expected subtotal");
    }

    /**
     * Test the toString method
     */
    @Test
    public void testToString() {
        String expectedString = "Product ID: 1, Description: Graphics Card, Price: 250.0"; // Adjusted to match the toString format
        BillableItem product = new Product("1", "Graphics Card", 250, 2);
        assertEquals(expectedString, product.toString(), "toString should return the expected string representation of the product");
    }
}


