import java.util.*;
public class Customer {
    private String name;
    private String contactNumber;
    private ArrayList<Vehicle> vehicles;

    Customer(String name, String contactNumber){

        this.name = name;
        this.contactNumber = contactNumber;
        this.vehicles = new ArrayList<>();

    }

    public void addVehicles(Vehicle vehicle){
        this.vehicles.add(vehicle);
    }

    public void displayVehicleDetails() {
        for (Vehicle v : vehicles) {
            System.out.println(v.oem);
        }
    }

}
