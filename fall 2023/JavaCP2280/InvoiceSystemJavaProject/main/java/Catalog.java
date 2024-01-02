import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class to demonstrate the Catalog
 *
 * @author john-michael.woodrow
 */
public class Catalog {
    private ArrayList<Product> productArrayList;
    private ArrayList<Service> serviceArrayList;

    /**
     * Constructor that builds a standard product list and service list
     */
    public Catalog() {
        this.productArrayList = new ArrayList<>();
        this.serviceArrayList = new ArrayList<>();
        this.buildProductList();
        this.buildServiceList();
    }

    /**
     * Find a product
     * @param id
     * @return
     */
    public Product getProduct(String id){
        for (Product product: productArrayList) {
            if(Objects.equals(product.getId(), id)){
                return product;
            }
        }
        return null;
    }

    /**
     * Find a service
     * @param id
     * @return
     */
    public Service getService(String id){
        for (Service service: serviceArrayList) {
            if(Objects.equals(service.getId(), id)){
                return service;
            }
        }
        return null;
    }

    /**
     * Get the Products list
     * @return productArrayList
     */
    public List<Product> getProductArrayList(){
        return productArrayList;
    }

    /**
     * Get the Services list
     * @return serviceArrayList
     */
    public ArrayList<Service> getServiceArrayList() {
        return serviceArrayList;
    }

    /**
     * Build up the product list
     */
    private void buildProductList() {
        productArrayList.add(new Product("1","Intel Pentium III Processor", 120.00, 1));
        productArrayList.add(new Product("2","ASUS P3B Motherboard", 150.00, 1));
        productArrayList.add(new Product("3","Seagate Barracuda 20GB HDD", 100.00, 1));
        productArrayList.add(new Product("4","Kingston ValueRAM 128MB SDRAM", 30.00, 1));
        productArrayList.add(new Product("5","ATI Rage 128 Pro Graphics Card", 70.00, 1));
        productArrayList.add(new Product("6","Sony CD-RW Drive", 45.00, 1));
        productArrayList.add(new Product("7","Generic 350W Power Supply", 35.00, 1));
        productArrayList.add(new Product("8","Creative Sound Blaster Live! Sound Card", 50.00, 1));
        productArrayList.add(new Product("9","Dell 17-inch CRT Monitor", 80.00, 1));
        productArrayList.add(new Product("10","Logitech PS/2 Keyboard", 20.00, 1));
        productArrayList.add(new Product("11","Microsoft Intellimouse", 15.00, 1));
        productArrayList.add(new Product("12","Case Fan 80mm", 10.00, 1));
        productArrayList.add(new Product("13","Large metal case", 70.00, 1));
    }

    /**
     * Build up the service list
     */
    private void buildServiceList() {
        // Here, we add the services
        serviceArrayList.add(new Service(Service.Services.ASSEMBLE));
        serviceArrayList.add(new Service(Service.Services.DEFRAG));
        serviceArrayList.add(new Service(Service.Services.REPAIR));
    }
}

