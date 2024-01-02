import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A class to test the catalog class
 *
 * @author john-michael.woodrow
 */
public class CatalogTest {

    /**
     * Test getProduct method
     */
    @Test
    public void testGetProduct() {
        Catalog catalog = new Catalog();
        Product product = catalog.getProduct("1");
        assertNotNull(product, "Product should not be null");
    }

    /**
     * Test getService method
     */
    @Test
    public void testGetService() {
        Catalog catalog = new Catalog();
        Service service = catalog.getService(Service.Services.REPAIR.getId());
        assertNotNull(service, "Service should not be null");
    }

    /**
     * Test getProductArrayList method
     */
    @Test
    public void testGetProductArrayList() {
        Catalog catalog = new Catalog();
        assertNotNull(catalog.getProductArrayList(), "Product list should not be null");
        assertFalse(catalog.getProductArrayList().isEmpty(), "Product list should not be empty");
    }

    /**
     * Test getServiceArrayList method
     */
    @Test
    public void testGetServiceArrayList() {
        Catalog catalog = new Catalog();
        assertNotNull(catalog.getServiceArrayList(), "Service list should not be null");
        assertFalse(catalog.getServiceArrayList().isEmpty(), "Service list should not be empty");
    }

    /**
     * Test buildProductList method
     */
    @Test
    public void testBuildProductList() {
        Catalog catalog = new Catalog();
        assertFalse(catalog.getProductArrayList().isEmpty(), "Product list should be populated");
    }

    /**
     * Test buildServiceList method
     */
    @Test
    public void testBuildServiceList() {
        Catalog catalog = new Catalog();
        assertFalse(catalog.getServiceArrayList().isEmpty(), "Service list should be populated");
    }
}
