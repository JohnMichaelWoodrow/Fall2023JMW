package assignment5;

/**
 * Assignment 5
 * Tests the functionality of the Invoice class
 * @author john-michael.woodrow
 */
public class InvoiceTester {

    public static void main(String[] args) {
        Product product1 = new Product(1, "TV", 500);
        Product product2 = new Product(2, "Phone", 750);
        Product product3 = new Product(3, "Couch", 1500);

        InvoiceItem item1 = new InvoiceItem(product1, 2);
        InvoiceItem item2 = new InvoiceItem(product2, 3);
        InvoiceItem item3 = new InvoiceItem(product3, 10);

        Invoice invoice = new Invoice();
        invoice.addItem(item1);
        invoice.addItem(item2);
        invoice.addItem(item3);


        System.out.println("Invoice Details:\n");

        for (int i = 1; i <= 3; i++) {
            InvoiceItem item = invoice.getItem(i - 1);
            if (item != null) {
                System.out.printf("Item %d: %s%n", i, item.getProduct().getDescription());
                System.out.printf("ID: %d%n", item.getProduct().getId());
                System.out.printf("Quantity: %d%n", item.getQuantity());
                System.out.printf("Item Total: $%.2f%n%n", item.getItemTotal());
            } else {
                System.out.printf("Item %d details are missing.%n", i);
            }
        }

        System.out.printf("Invoice Total: $%.2f%n%n", invoice.getInvoiceTotal());

        System.out.println("Edge Cases:");
        item1.setQuantity(-1);
        product1.setPrice(-2);
        product1.setId(-3);
        invoice.getItem(-1);
        invoice.getItem(4);
    }
}







