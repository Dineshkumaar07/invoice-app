import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Invoice {
    private Vehicle vehicle;
    private List<Service> services;

    public Invoice(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.services = vehicle.getServices();
    }

    public void generateInvoice() {
        System.out.println("Invoice for Vehicle (OEM: " + vehicle.getOem() + ", VIN: " + vehicle.getVin() + "):");
        double totalCost = 0;
        for (Service service : services) {
            double discountedCost = service.getDiscountedCost();
            System.out.printf("Service: %s, Cost: %.2f, Discounted Cost: %.2f%n",
                    service.getServiceName(), service.getCost(), discountedCost);
            totalCost += discountedCost;
        }
        System.out.printf("Total Invoice Amount for Vehicle: %.2f%n", totalCost);
        System.out.println("----------------------------------------");
    }

    public void writeInvoiceToCSV(String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            writer.printf("Invoice for Vehicle (OEM: %s, VIN: %s):%n", vehicle.getOem(), vehicle.getVin());
            double totalCost = 0;
            for (Service service : services) {
                double discountedCost = service.getDiscountedCost();
                writer.printf("Service: %s, Cost: %.2f, Discounted Cost: %.2f%n",
                        service.getServiceName(), service.getCost(), discountedCost);
                totalCost += discountedCost;
            }
            writer.printf("Total Invoice Amount for Vehicle: %.2f%n", totalCost);
            writer.println("----------------------------------------");
        } catch (IOException e) {
            throw new RuntimeException("Error writing invoice to CSV file", e);
        }
    }
}
