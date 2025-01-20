import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String contactNumber;
    private List<Vehicle> vehicles;

    public Customer(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.vehicles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void generateInvoices(String customerName) {
        System.out.println("Invoices for Customer: " + name);
        for (Vehicle vehicle : vehicles) {
            Invoice invoice = new Invoice(vehicle);
            invoice.generateInvoice();
            invoice.writeInvoiceToCSV("resources/"+customerName+" "+vehicle.getOem()+".csv");
        }
    }
}
