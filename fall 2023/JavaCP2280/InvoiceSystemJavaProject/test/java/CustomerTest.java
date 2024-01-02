import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test the Customer class
 *
 * @author john-michael.woodrow
 */
public class CustomerTest {
    /**
     * Test the Customer constructor
     */
    @Test
    public void testCustomerConstructor() {
        String expectedName = "John Doe";
        Address expectedAddress = new Address("123 Main St", "Paradise", "12345");
        Customer customer = new Customer(expectedName, expectedAddress);
        assertNotNull("Customer object should not be null", customer);
        assertEquals("Expected name should match actual name", expectedName, customer.getName());
        assertEquals("Expected address should match actual address", expectedAddress, customer.getAddress());
    }

    /**
     * Test the getName method
     */
    @Test
    public void testGetName() {
        String expectedName = "John Doe";
        Address address = new Address("123 Main St", "Paradise", "12345");
        Customer customer = new Customer(expectedName, address);
        assertEquals("Expected name should match actual name", expectedName, customer.getName());
    }

    /**
     * Test the setName method
     */
    @Test
    public void testSetName() {
        String initialName = "John Doe";
        String newName = "Jane Doe";
        Address address = new Address("123 Main St", "Paradise", "12345");
        Customer customer = new Customer(initialName, address);
        customer.setName(newName);
        assertEquals("Expected name after set should match actual name", newName, customer.getName());
    }

    /**
     * Test the getAddress method
     */
    @Test
    public void testGetAddress() {
        Address expectedAddress = new Address("123 Main St", "Paradise", "12345");
        Customer customer = new Customer("John Doe", expectedAddress);
        assertEquals("Expected address should match actual address", expectedAddress, customer.getAddress());
    }

    /**
     * Test the setAddress method
     */
    @Test
    public void testSetAddress() {
        Address initialAddress = new Address("123 Main St", "Paradise", "12345");
        Address newAddress = new Address("456 Elm St", "Tech Town", "67890");
        Customer customer = new Customer("John Doe", initialAddress);
        customer.setAddress(newAddress);
        assertEquals("Expected address after set should match actual address", newAddress, customer.getAddress());
    }
}

