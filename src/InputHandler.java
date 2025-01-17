import java.util.*;
public class InputHandler {
    Scanner scanner;
    InputHandler(Scanner scanner){
        this.scanner = scanner;
    }

    public Customer createCustomer(){
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Contact number: ");
        String contactNumber = scanner.next();

        Customer customer = new Customer(name, contactNumber);

        while(true){
            Vehicle vehicle = createVehicle();
            customer.addVehicles(vehicle);
            System.out.print("Want to add more Veicle? ");
            boolean isMore = scanner.nextBoolean();
            if(!isMore){
                break;
            }
        }
        return customer;
    }
    public Vehicle createVehicle(){
        System.out.println("Enter vehicle Details: ");
        System.out.print("Enter OEM: ");
        String oem = scanner.next();
        System.out.print("Enter VIN: ");
        String vin = scanner.next();
        Vehicle vehicle = new Vehicle(oem, vin);
        return vehicle;
    }
}
