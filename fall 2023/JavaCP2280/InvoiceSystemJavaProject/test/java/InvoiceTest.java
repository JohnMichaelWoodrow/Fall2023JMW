import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

/**
 * A class to test the Invoice class
 *
 * @author john-michael.woodrow
 */
public class InvoiceTest {

    /**
     * Test the Invoice constructor
     */
    @Test
    public void testInvoiceConstructor() {
        LocalDate creationDate = LocalDate.now();
        LocalDate dueDate = LocalDate.now().plusDays(30);
        Customer expectedCustomer = new Customer("John Doe", new Address("123 Main St", "Paradise", "12345"));
        Invoice invoice = new Invoice(creationDate, dueDate, expectedCustomer);
        assertNotNull(invoice, "Invoice object should be created");
    }

    /**
     * Test the addItem method
     */
    @Test
    public void testAddItem() {
        Customer customer = new Customer("John Doe", new Address("123 Main St", "Paradise", "12345"));
        Invoice invoice = new Invoice(LocalDate.now(), LocalDate.now().plusDays(30), customer);
        BillableItem product = new Product("1", "Graphics Card", 2, 3);
        invoice.addItem(product, 2);
        boolean itemFound = false;
        for (InvoiceItem item : invoice.getItems()) {
            if (item.getBillableItem().equals(product) && item.getQuantity() == 2) {
                itemFound = true;
                break;
            }
        }
        assertTrue(itemFound, "Invoice should contain the added item with the correct product and quantity");
    }

    /**
     * Test the calculateSubtotal method
     */
    @Test
    public void testCalculateSubtotal() {
        double price = 250.00;
        int quantity = 2;
        double expectedSubtotal = price * quantity;
        Customer customer = new Customer("John Doe", new Address("123 Main St", "Paradise", "12345"));
        Invoice invoice = new Invoice(LocalDate.now(), LocalDate.now().plusDays(30), customer);
        BillableItem product = new Product("1", "Graphics Card", price, quantity);
        invoice.addItem(product, quantity);
        assertEquals(expectedSubtotal, invoice.calculateSubtotal(), 0.001, "Subtotal should be calculated correctly based on the items added");
    }

    /**
     * Test the calculateTax method
     */
    @Test
    public void testCalculateTax() {
        double pricePerUnit = 250.00; // Correct price per unit
        int quantity = 2; // Correct quantity
        double subtotal = pricePerUnit * quantity;
        double taxRate = 0.15; // Assuming a 15% tax rate
        double expectedTax = subtotal * taxRate;
        Customer customer = new Customer("John Doe", new Address("123 Main St", "Paradise", "12345"));
        Invoice invoice = new Invoice(LocalDate.now(), LocalDate.now().plusDays(30), customer);
        BillableItem product = new Product("1", "Graphics Card", pricePerUnit, quantity);
        invoice.addItem(product, quantity);
        assertEquals(expectedTax, invoice.calculateTax(), 0.001, "Tax should be calculated correctly");
    }

    /**
     * Test the calculateSubtotalWithTax method
     */
    @Test
    public void testCalculateSubtotalWithTax() {
        double price = 250.00; // Assuming this is the price per item
        int quantity = 2;
        double subtotal = price * quantity;
        double taxRate = 0.15; // Assuming a 15% tax rate
        double tax = subtotal * taxRate;
        double expectedTotal = subtotal + tax;
        Customer customer = new Customer("John Doe", new Address("123 Main St", "Paradise", "12345"));
        Invoice invoice = new Invoice(LocalDate.now(), LocalDate.now().plusDays(30), customer);
        BillableItem product = new Product("1", "Graphics Card", price, quantity);
        invoice.addItem(product, quantity);
        assertEquals(expectedTotal, invoice.calculateSubtotalWithTax(), 0.001, "Total with tax should be calculated correctly");
    }

    /**
     * Test the getInvoiceNumber method
     */
    @Test
    public void testGetInvoiceNumber() {
        Customer customer = new Customer("John Doe", new Address("123 Main St", "Paradise", "12345"));
        Invoice invoice = new Invoice(LocalDate.now(), LocalDate.now().plusDays(30), customer);
        assertTrue(invoice.getInvoiceNumber() > 0, "Invoice number should be positive and greater than 0");
    }

    /**
     * Test the getDates method
     */
    @Test
    public void testGetDates() {
        LocalDate expectedCreationDate = LocalDate.now();
        LocalDate expectedDueDate = LocalDate.now().plusDays(30);
        Customer customer = new Customer("John Doe", new Address("123 Main St", "Paradise", "12345"));
        Invoice invoice = new Invoice(expectedCreationDate, expectedDueDate, customer);
        assertEquals(expectedCreationDate, invoice.getCreationDate(), "Creation date should match the expected date");
        assertEquals(expectedDueDate, invoice.getDueDate(), "Due date should match the expected date 30 days from creation date");
    }

    /**
     * Test the getCustomer method
     */
    @Test
    public void testGetCustomer() {
        Customer expectedCustomer = new Customer("John Doe", new Address("123 Main St", "Paradise", "12345"));
        Invoice invoice = new Invoice(LocalDate.now(), LocalDate.now().plusDays(30), expectedCustomer);
        assertEquals(expectedCustomer, invoice.getCustomer(), "The getter for customer should return the expected customer object");
    }
}

