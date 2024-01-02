/**
 * Class for printing invoices in a formatted ASCII style
 *
 * @author john-michael.woodrow
 */
public class InvoicePrinter {
    private static final int lineWidth = 70;
    private static final String ANSI_GREEN = "\033[32m";
    public static final String ANSI_RED = "\u001B[31m";

    /**
     * Prints a line of a specified character for a specified length
     * @param length
     * @param character
     */
    private void printLine(int length, String character) {
        for (int i = 0; i < length; i++) {
            System.out.print(character);
        }
        System.out.println();
    }

    /**
     * Prints the invoice with detailed information and calculations
     * @param invoice
     */
    public void printInvoice(Invoice invoice) {
        System.out.print(ANSI_GREEN);
        printLine(lineWidth, "=");
        System.out.printf("%" + (lineWidth / 2 + "Retro Computers".length() / 2) + "s%n", "Retro Computers");
        System.out.printf("%" + (lineWidth / 2 + "123 Vintage Tech Street".length() / 2) + "s%n", ANSI_RED + "123" + ANSI_GREEN + " Vintage Tech Street");
        System.out.printf("%" + (lineWidth / 2 + "Nostalgia City, PC 54321".length() / 2) + "s%n", "Nostalgia City, PC " + ANSI_RED + "54321");
        System.out.printf("%" + (lineWidth / 2 + "Phone: (555) 133-4567".length() / 2) + "s%n", "Phone: " + ANSI_GREEN + "(555)" + ANSI_RED + " 133-4567");
        System.out.printf("%" + (lineWidth / 2 + "Email: info@retrocomputers.com".length() / 2) + "s%n", ANSI_RED + "Email: " + ANSI_GREEN + "info@retrocomputers.com");
        printLine(lineWidth, "=");
        System.out.println(ANSI_RED +"\nInvoice Number: " + ANSI_GREEN + invoice.getInvoiceNumber());
        System.out.println(ANSI_RED +"Date: " + ANSI_GREEN + invoice.getCreationDate());
        System.out.println(ANSI_RED +"Due Date: " + ANSI_GREEN + invoice.getDueDate());
        System.out.println(ANSI_RED +"\nBill To:");
        System.out.println(ANSI_RED +"Customer Name: " + ANSI_GREEN + invoice.getCustomer().getName());
        System.out.println(ANSI_RED +"Address: " + ANSI_GREEN + invoice.getCustomer().getAddress());
        System.out.println(ANSI_GREEN + "\nShip To (if different):");
        System.out.println(ANSI_RED +"Customer Name: " + ANSI_GREEN + invoice.getCustomer().getName());
        System.out.println(ANSI_RED +"Address: " + ANSI_GREEN + invoice.getCustomer().getAddress()+"\n");
        printLine(lineWidth, "=");
        System.out.printf("%-30s %-10s %-10s %-10s%n", "Description", "Quantity", "Unit Price", "Total");
        printLine(lineWidth, "-");
        for (InvoiceItem item : invoice.getItems()) {
            String itemType;
            int quantity;
            double unitPrice = item.getBillableItem().getPrice();
            double total = item.calculateSubtotal();
            if (item.getBillableItem() instanceof Product) {
                itemType = "Product";
                quantity = item.getQuantity();
            } else {
                itemType = "Service";
                quantity = 1;
            }
            String description = item.getBillableItem().getDescription();
            description = description.length() > 20 ? description.substring(0, 17) + "..." : description;
            System.out.printf("%-10s %-20s %-10d %-10.2f %-10.2f%n", itemType, description, quantity, unitPrice, total);
        }
        printLine(lineWidth, "-");
        double subtotal = invoice.calculateSubtotal();
        double tax = invoice.calculateTax();
        double totalDue = invoice.calculateSubtotalWithTax();
        System.out.printf("%-50s %20.2f%n", ANSI_RED + "Subtotal:" + ANSI_GREEN, subtotal);
        System.out.printf("%-39s %20.2f%n", "Tax (15%):", tax);
        System.out.printf("%-50s %20.2f%n", ANSI_RED + "Total Amount Due:" + ANSI_GREEN, totalDue);
        printLine(lineWidth, "=");
        System.out.println(ANSI_RED +"\nPayment Instructions:");
        System.out.println(ANSI_GREEN +"Please make payment by the due date mentioned above.");
        System.out.println("You can send your payment via check to the address provided.");
        System.out.println("\nThank you for choosing Retro Computers!");
    }
}




