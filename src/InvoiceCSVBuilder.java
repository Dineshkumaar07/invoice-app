import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class InvoiceCSVBuilder {
    private StringBuilder csvContent;

    public InvoiceCSVBuilder() {
        csvContent = new StringBuilder();
        csvContent.append("OEM,VIN,Service Name,Cost,Discount,Discounted Cost\n");
    }

    public void addServiceToCSV(Vehicle vehicle, Service service) {
        csvContent.append(vehicle.getOem()).append(",")
                .append(vehicle.getVin()).append(",")
                .append(service.getServiceName()).append(",")
                .append(service.getCost()).append(",")
                .append(service.getDiscountPercentage()).append(",")
                .append(service.getDiscountedCost()).append("\n");
    }

    public void exportToFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(csvContent.toString());
            System.out.println("Invoice CSV written to " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing CSV file: " + e.getMessage());
        }
    }
}
