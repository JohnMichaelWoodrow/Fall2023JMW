/**
 * Represents a customer with a name and address
 *
 * @author john-michael.woodrow
 */
public class Customer {
    private String name;
    private Address address;

    /**
     * Constructs a Customer with a given name and address
     * @param name Name of the customer
     * @param address Address object of the customer
     */
    public Customer(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    /**
     * Retrieves the name of the customer
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the address of the customer
     * @return address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the address of the customer
     * @param address
     */
    public void setAddress(Address address) {
        this.address = address;
    }
}
