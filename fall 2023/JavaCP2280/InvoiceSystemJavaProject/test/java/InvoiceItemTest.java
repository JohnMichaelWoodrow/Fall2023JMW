import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A class to test the InvoiceItem class
 *
 * @author john-michael.woodrow
 */
public class InvoiceItemTest {
    /**
     * Test the InvoiceItem constructor
     */
    @Test
    public void testInvoiceItemConstructor() {
        BillableItem expectedProduct = new Product("1","Graphics Card", 250.00, 2);
        int expectedQuantity = 3;
        InvoiceItem invoiceItem = new InvoiceItem(expectedProduct, expectedQuantity);
        assertNotNull(invoiceItem, "InvoiceItem object should be created");
    }

    /**
     * Test the getBillableItem method
     */
    @Test
    public void testGetBillableItem() {
        BillableItem expectedProduct = new Product("1", "Graphics Card", 250.00, 2);
        InvoiceItem invoiceItem = new InvoiceItem(expectedProduct, 3);
        assertEquals(expectedProduct, invoiceItem.getBillableItem(), "getBillableItem should return the expected Product object");
    }

    /**
     * Test the getQuantity method
     */
    @Test
    public void testGetQuantity() {
        int expectedQuantity = 3;
        BillableItem product = new Product("1", "Graphics Card", 2, 3);
        InvoiceItem invoiceItem = new InvoiceItem(product, expectedQuantity);
        assertEquals(expectedQuantity, invoiceItem.getQuantity(), "getQuantity should return the expected quantity");
    }

    /**
     * Test the calculateSubtotal method
     */
    @Test
    public void testCalculateSubtotal() {
        double pricePerUnit = 250.00;
        int quantity = 3;
        double expectedSubtotal = pricePerUnit * quantity;
        BillableItem product = new Product("1", "Graphics Card", pricePerUnit, quantity);
        InvoiceItem invoiceItem = new InvoiceItem(product, quantity);
        assertEquals(expectedSubtotal, invoiceItem.calculateSubtotal(), 0.001, "calculateSubtotal should return the expected subtotal");
    }
}

