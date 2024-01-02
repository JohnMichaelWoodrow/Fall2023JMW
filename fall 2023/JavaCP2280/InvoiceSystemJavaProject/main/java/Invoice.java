import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Class representing an invoice with its details
 *
 * @author john-michael.woodrow
 */
public class Invoice {
    private static int invoiceCount = 0;
    private final int invoiceNumber;
    private LocalDate creationDate;
    private LocalDate dueDate;
    private Customer customer;
    private final List<InvoiceItem> items;
    private final double taxRate = 0.15;

    /**
     * Constructs an Invoice with creation date, due date, and customer
     * @param creationDate The date the invoice is created
     * @param dueDate The date by which the invoice is due
     * @param customer The customer associated with the invoice
     */
    public Invoice(LocalDate creationDate, LocalDate dueDate, Customer customer) {
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.invoiceNumber = ++invoiceCount;
    }

    /**
     * Get the Invoice Number
     * @return invoiceNumber
     */
    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * Get the Creation Date
     * @return creationDate
     */
    public LocalDate getCreationDate() {
        return creationDate;
    }

    /**
     * Get the Due Date
     * @return dueDate
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Get the Customer
     * @return customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Get the List of Invoice Items
     * @return items
     */
    public List<InvoiceItem> getItems() {
        return items;
    }

    /**
     * Get the Tax Rate
     * @return taxRate
     */
    public double getTaxRate() {
        return taxRate;
    }

    /**
     * Adds a billable item with its quantity to the invoice
     * @param billableItem
     * @param quantity
     */
    public void addItem(BillableItem billableItem, int quantity) {
        items.add(new InvoiceItem(billableItem, quantity));
    }

    /**
     * Calculates the subtotal of all items on the invoice
     * @return total
     */
    public double calculateSubtotal() {
        double total = 0.0;
        for (InvoiceItem item : items) {
            total += item.calculateSubtotal();
        }
        return total;
    }

    /**
     * Calculates the tax based on the subtotal
     * @return tax
     */
    public double calculateTax() {
        return calculateSubtotal() * taxRate;
    }

    /**
     * Calculates the total amount due including tax
     * @return SubtotalWithTax
     */
    public double calculateSubtotalWithTax() {
        return calculateSubtotal() + calculateTax();
    }
}