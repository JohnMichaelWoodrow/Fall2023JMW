import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.time.LocalDate;
/**
 * Main class for the Retro Computers Invoicing System
 * This class provides a console based user interface for managing invoices
 * Contains a menu to display Products and Services catalog, Display saved Invoices and Create Invoice
 *
 * @author john-michael.woodrow
 */
public class RetroComputersInvoicingSystem {
    private static Catalog catalog = new Catalog();
    private static InvoicePrinter printer = new InvoicePrinter();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Invoice invoice = null;
        int choice = 0;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Display Products/Services Catalog");
            System.out.println("2. Display Saved Invoices");
            System.out.println("3. Create Invoice");
            System.out.println("4. Display Given Invoice");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.println("\nProducts:");
                for (Product product : catalog.getProductArrayList()) {
                    System.out.println(product);
                }
                System.out.println("\nServices:");
                for (Service service : catalog.getServiceArrayList()) {
                    System.out.println(service);
                }
            } else if (choice == 2) {
                if (invoice == null) {
                    System.out.println("No invoice to display.");
                } else {
                    printer.printInvoice(invoice);
                }
            } else if (choice == 3) {
                System.out.println("Enter Customer Details:\n");
                System.out.println("Enter customer name:");
                String customerName = scanner.nextLine();
                System.out.println("Enter street address:");
                String street = scanner.nextLine();
                System.out.println("Enter city:");
                String city = scanner.nextLine();
                System.out.println("Enter zip code:");
                String zipCode = scanner.nextLine();
                LocalDate dueDate = null;
                while (dueDate == null) {
                    System.out.print("Enter due date (yyyy-mm-dd): ");
                    String dueDateString = scanner.nextLine();
                    try {
                        dueDate = LocalDate.parse(dueDateString);
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date format. Please enter the date in the format yyyy-mm-dd.");
                    }
                }
                Invoice newInvoice = new Invoice(LocalDate.now(), dueDate, new Customer(customerName, new Address(street, city, zipCode)));
                addItemsToInvoice(scanner, newInvoice);
                printer.printInvoice(newInvoice);
            } else if (choice == 4) {
                Invoice demoInvoice = createDemoInvoice(catalog);
                printer.printInvoice(demoInvoice);
            } else if (choice == 5) {
                System.out.println("Goodbye");
                scanner.close();
                return;
            } else {
                System.out.println("Invalid option");
            }
        } while (choice != 5);
    }

    private static void addItemsToInvoice(Scanner scanner, Invoice invoice) {
        int productOrServiceChoice;
        do {
            System.out.println("\nWould you like to:");
            System.out.println("1. Add a product");
            System.out.println("2. Add a service");
            System.out.println("0. Finish and print invoice");
            System.out.print("Enter your choice: ");
            productOrServiceChoice = scanner.nextInt();
            scanner.nextLine();
            if (productOrServiceChoice == 1) {
                addProductToInvoice(scanner, invoice);
            } else if (productOrServiceChoice == 2) {
                addServiceToInvoice(scanner, invoice);
            }
        } while (productOrServiceChoice != 0);
    }

    /**
     * Add products to an invoice
     * @param invoice
     */
    private static void addProductToInvoice(Scanner scanner, Invoice invoice) {
        System.out.println("\nSelect a product to add (or 0 to return):");
        for (int i = 0; i < catalog.getProductArrayList().size(); i++) {
            System.out.println((i + 1) + ". " + catalog.getProductArrayList().get(i));
        }
        System.out.print("Your choice: ");
        int itemChoice = scanner.nextInt();
        scanner.nextLine();
        if (itemChoice > 0 && itemChoice <= catalog.getProductArrayList().size()) {
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            Product selectedProduct = catalog.getProductArrayList().get(itemChoice - 1);
            invoice.addItem(selectedProduct, quantity); // Adjusted to pass quantity
            System.out.println("Added: " + selectedProduct.getDescription());
        }
    }

    /**
     * Add services to an invoice
     * @param invoice
     */
    private static void addServiceToInvoice(Scanner scanner, Invoice invoice) {
        System.out.println("\nSelect a service to add (or 0 to return):");
        for (int i = 0; i < catalog.getServiceArrayList().size(); i++) {
            System.out.println((i + 1) + ". " + catalog.getServiceArrayList().get(i));
        }
        System.out.print("Your choice: ");
        int itemChoice = scanner.nextInt();
        scanner.nextLine();
        if (itemChoice > 0 && itemChoice <= catalog.getServiceArrayList().size()) {
            Service selectedService = catalog.getServiceArrayList().get(itemChoice - 1);
            invoice.addItem(selectedService, 1);
            System.out.println("Added: " + selectedService.getDescription());
        }
    }

    /**
     * Create a demo invoice for demonstration purposes
     * @return demoInvoice
     */
    public static Invoice createDemoInvoice(Catalog catalog) {
        Customer demoCustomer = new Customer("Tosh Baylor", new Address("123 Real Street", "St. John’s", "NL"));
        Invoice demoInvoice = new Invoice(LocalDate.now(), LocalDate.now().plusDays(30), demoCustomer);
        for (Product product : catalog.getProductArrayList()) {
            int quantity = 1;
            if (product.getDescription().equals("Intel Pentium III Processor") ||
                    product.getDescription().equals("ASUS P3B Motherboard") ||
                    product.getDescription().equals("Seagate Barracuda 20GB HDD") ||
                    product.getDescription().equals("ATI Rage 128 Pro Graphics Card") ||
                    product.getDescription().equals("Generic 350W Power Supply") ||
                    product.getDescription().equals("Large metal case")) {
                demoInvoice.addItem(product, quantity);
            } else if (product.getDescription().equals("Kingston ValueRAM 128MB SDRAM")) {
                demoInvoice.addItem(product, 2);
            }
        }
        for (Service service : catalog.getServiceArrayList()) {
            if (service.getDescription().equals("Computer Assemble")) {
                demoInvoice.addItem(service, 1);
                break;
            }
        }
        return demoInvoice;
    }
}




