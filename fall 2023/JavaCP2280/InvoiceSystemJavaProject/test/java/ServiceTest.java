import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A class to test the Service class
 *
 * @author john-michael.woodrow
 */
public class ServiceTest {

    /**
     * Test the Service constructor
     */
    @Test
    public void testServiceConstructor() {
        Service service = new Service(Service.Services.REPAIR);
        assertNotNull(service, "Service object should be created");
    }

    /**
     * Test the getId method
     */
    @Test
    public void testGetId() {
        String expectedId = "REPAIR";
        Service service = new Service(Service.Services.REPAIR);
        assertEquals(expectedId, service.getId(), "ID getter should return the expected ID");
    }

    /**
     * Test the getDescription method
     */
    @Test
    public void testGetDescription() {
        String expectedDescription = "General Repair (hour)";
        Service service = new Service(Service.Services.REPAIR);
        assertEquals(expectedDescription, service.getDescription(), "Description getter should return the expected service description");
    }

    /**
     * Test the getPrice method
     */
    @Test
    public void testGetPrice() {
        double expectedPrice = 27.50;
        Service service = new Service(Service.Services.REPAIR);
        assertEquals(expectedPrice, service.getPrice(), 0.001, "Price getter should return the expected service price");
    }

    /**
     * Test the calculateSubtotal method
     */
    @Test
    public void testCalculateSubtotal() {
        double expectedSubtotal = 27.50;
        Service service = new Service(Service.Services.REPAIR);
        assertEquals(expectedSubtotal, service.calculateSubtotal(), 0.001, "calculateSubtotal should return the expected subtotal");
    }

    /**
     * Test the toString method
     */
    @Test
    public void testToString() {
        String expectedString = "Service ID: REPAIR, Description: General Repair (hour), Price: 27.5";
        Service service = new Service(Service.Services.REPAIR);
        assertEquals(expectedString, service.toString(), "toString should return the expected string representation of the service");
    }
}


