public class Problem3 {

    public static void parseInventoryRecord(String csvLine) {
        // Validation check for null input
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        // Split CSV line by commas
        String[] fields = csvLine.split(",");

        // Validate that exactly 3 fields are present
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        // Trim leading and trailing spaces from each field
        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String qty = fields[2].trim();

        // Output formatted record
        System.out.println("Product: " + productName + " | SKU: " + sku + " | Qty: " + qty);
    }

    public static void main(String[] args) {
        // Sample inputs from problem statement
        parseInventoryRecord("Wireless Mouse, WM-2201,150"); 
        // Output: Product: Wireless Mouse | SKU: WM-2201 | Qty: 150

        parseInventoryRecord("Wireless Mouse, 150");          
        // Output: Invalid Record
    }
}