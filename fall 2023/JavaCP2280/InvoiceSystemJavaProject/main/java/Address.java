/**
 * Represents a physical address with street, city, and zip code
 *
 * @author john-michael.woodrow
 */
public class Address {
    private String street;
    private String city;
    private String zipCode;

    /**
     * Constructs an Address with specified street, city, and zip code
     * @param street Street of the address
     * @param city City of the address
     * @param zipCode Zip code of the address
     */
    public Address(String street, String city, String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    /**
     * Get the Street
     * @return street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Set the Street
     * @param street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Get the City
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Get the City
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get the ZipCode
     * @return zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Set the ZipCode
     * @param zipCode
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Print the string nicely
     * @return String
     */
    @Override
    public String toString() {
        return street + ", " + city + ", " + zipCode;
    }
}
