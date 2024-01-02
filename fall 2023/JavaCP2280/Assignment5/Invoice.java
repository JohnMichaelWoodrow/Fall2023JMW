package assignment5;
import java.util.ArrayList;
/**
 * Assignment 5
 * Represents an invoice containing a list of InvoiceItems
 * @author john-michael.woodrow
 */
public class Invoice {
    private ArrayList<InvoiceItem> items;

    public Invoice() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds an InvoiceItem to the invoice
     * @param item the invoice item to be added
     */
    public void addItem(InvoiceItem item) {
        this.items.add(item);
    }

    /**
     * Returns the InvoiceItem at the specified index
     * Prints an error message if the index is negative or too large
     * @param index the index of the invoice item
     * @return the invoice item at the specified index or null if the index is invalid
     */
    public InvoiceItem getItem(int index) {
        if(index < 0) {
            System.err.println("Negative Index");
            return null;
        } else if(index >= items.size()) {
            System.err.println("Index too large");
            return null;
        } else {
            return items.get(index);
        }
    }

    /**
     * Computes and returns the total for the invoice
     * @return the invoice total
     */
    public double getInvoiceTotal() {
        double total = 0;
        for (InvoiceItem item : items) {
            total += item.getItemTotal();
        }
        return total;
    }
}

