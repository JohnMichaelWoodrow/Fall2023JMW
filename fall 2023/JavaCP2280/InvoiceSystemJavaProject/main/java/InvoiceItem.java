/**
 * Class representing an item on an invoice
 *
 * @author john-michael.woodrow
 */
public class InvoiceItem {
    private final BillableItem billableItem;
    private final int quantity;

    /**
     * Constructs an InvoiceItem with a BillableItem and its quantity
     * @param billableItem The billable item being invoiced
     * @param quantity The quantity of the billable item
     */
    public InvoiceItem(BillableItem billableItem, int quantity) {
        this.billableItem = billableItem;
        this.quantity = quantity;
    }

    /**
     * Get the BillableItem
     * @return billableItem
     */
    public BillableItem getBillableItem() {
        return billableItem;
    }

    /**
     * Get the Quantity
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Calculates and returns the subtotal for this InvoiceItem
     * @return The product of the unit price and quantity of a billableItem
     */
    public double calculateSubtotal() {
        return billableItem.getPrice() * this.quantity;
    }
}