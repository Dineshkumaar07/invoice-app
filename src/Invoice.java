import java.util.List;

public class Invoice {
    private Vehicle vehicle;
    private List<Service> services;

    public Invoice(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.services = vehicle.getServices(); // Get services from the vehicle
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
}
