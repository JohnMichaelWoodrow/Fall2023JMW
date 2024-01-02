import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A class to test the Address class
 *
 * @author john-michael.woodrow
 */
public class AddressTest {
    /**
     * Test the Address constructor
     */
    @Test
    public void testAddressConstructor() {
        String street = "123 Main St";
        String city = "Paradise";
        String zipCode = "12345";
        Address address = new Address(street, city, zipCode);
        assertNotNull(address, "Address object should be created");
    }

    /**
     * Test the getStreet method
     */
    @Test
    public void testGetStreet() {
        String expectedStreet = "123 Main St";
        Address address = new Address(expectedStreet, "Paradise", "12345");
        assertEquals(expectedStreet, address.getStreet(), "Street getter should return the expected street");
    }

    /**
     * Test the setStreet method
     */
    @Test
    public void testSetStreet() {
        Address address = new Address("123 Main St", "Paradise", "12345");
        String newStreet = "456 Elm St";
        address.setStreet(newStreet);
        assertEquals(newStreet, address.getStreet(), "Street should be updated to the new value");
    }

    /**
     * Test the getCity method
     */
    @Test
    public void testGetCity() {
        String expectedCity = "Paradise";
        Address address = new Address("123 Main St", expectedCity, "12345");
        assertEquals(expectedCity, address.getCity(), "City getter should return the expected city");
    }

    /**
     * Test the setCity method
     */
    @Test
    public void testSetCity() {
        Address address = new Address("123 Main St", "Paradise", "12345");
        String newCity = "Othertown";
        address.setCity(newCity);
        assertEquals(newCity, address.getCity(), "City should be updated to the new value");
    }

    /**
     * Test the getZipCode method
     */
    @Test
    public void testGetZipCode() {
        String expectedZipCode = "12345";
        Address address = new Address("123 Main St", "Paradise", expectedZipCode);
        assertEquals(expectedZipCode, address.getZipCode(), "ZipCode getter should return the expected zip code");
    }

    /**
     * Test the setZipCode method
     */
    @Test
    public void testSetZipCode() {
        Address address = new Address("123 Main St", "Paradise", "12345");
        String newZipCode = "67890";
        address.setZipCode(newZipCode);
        assertEquals(newZipCode, address.getZipCode(), "Zip code should be updated to the new value");
    }

    /**
     * Test the toString method
     */
    @Test
    public void testToString() {
        String expectedToString = "123 Main St, Paradise, 12345";
        Address address = new Address("123 Main St", "Paradise", "12345");
        assertEquals(expectedToString, address.toString(), "toString should return the correctly formatted address");
    }
}

