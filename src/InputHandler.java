import java.util.Scanner;

public class InputHandler {
    Scanner scanner;

    InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public Customer createCustomer() {
        System.out.print("Name: ");
        String name = scanner.next();
        scanner.nextLine();
        System.out.print("Contact number: ");
        String contactNumber = scanner.next();

        Customer customer = new Customer(name, contactNumber);

        while (true) {
            Vehicle vehicle = createVehicle();
            customer.addVehicle(vehicle);
            addServicesToVehicle(vehicle);

            System.out.print("Want to add another vehicle? (true/false): ");
            boolean addMoreVehicles = scanner.nextBoolean();
            if (!addMoreVehicles) {
                break;
            }
        }

        return customer;
    }

    public Vehicle createVehicle() {
        System.out.println("Enter vehicle details:");
        System.out.print("Enter OEM: ");
        String oem = scanner.next();
        System.out.print("Enter VIN: ");
        String vin = scanner.next();
        return new Vehicle(oem, vin);
    }

    public void addServicesToVehicle(Vehicle vehicle) {
        while (true) {
            System.out.println("Available Services:");
            ServiceFactory.displayServiceMenu();
            System.out.print("Enter service ID (1-3): ");
            int serviceId = scanner.nextInt();

            try {
                Service service = ServiceFactory.getServiceById(serviceId);
                vehicle.addService(service);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.print("Add another service? (true/false): ");
            boolean addMoreServices = scanner.nextBoolean();
            if (!addMoreServices) {
                break;
            }
        }
    }
    
}
