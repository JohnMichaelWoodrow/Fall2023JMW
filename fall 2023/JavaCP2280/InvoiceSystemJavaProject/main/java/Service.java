/**
 * Class representing a service, extending the BillableItem class
 *
 * @author john-michael.woodrow
 */
public class Service extends BillableItem {
    /**
     * Constructs a Service with an ID, name, and price
     *
     * @param service Enum value representing the service
     */
    public Service(Services service) {
        super(service.getId(), service.getDescription(), service.getPrice(), 1);
    }

    @Override
    public double calculateSubtotal() {
        return getPrice() * getQuantity();
    }

    /**
     * Enum to store all the services being offered. Gets around not using DB or files.
     */
    public enum Services {
        ASSEMBLE("ASSEMBLE", "Computer Assembly", 125.00),
        REPAIR("REPAIR", "General Repair (hour)", 27.50),
        DEFRAG("DEFRAG", "Defragment Hard Drive", 25.00);

        private final String id;
        private final String description;
        private final double price;

        /**
         * Simple constructor for the enum to represent the service.
         * @param id Unique identifier for the service
         * @param description Description of the service
         * @param price Unit price of the service
         */
        Services(String id, String description, double price) {
            this.id = id;
            this.description = description;
            this.price = price;
        }

        /**
         * Get the ID
         * @return id
         */
        public String getId() {
            return id;
        }

        /**
         * Get the description
         * @return description
         */
        public String getDescription() {
            return description;
        }

        /**
         * Get the price
         * @return price
         */
        public double getPrice() {
            return price;
        }
    }

    /**
     * Print the string nicely
     * @return String
     */
    @Override
    public String toString() {
        return "Service ID: " + getId() + ", Description: " + getDescription() + ", Price: " + getPrice();
    }
}



