import java.io.*;
import java.util.*;

public class CSVInputAdapter implements DataInput {
    private String filePath;

    public CSVInputAdapter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Customer getCustomerFromData() {
        Customer customer = null;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String currentCustomerName = "";
            String currentContactNumber = "";

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println("Parsed row: " + Arrays.toString(data));

                if (data.length < 5) {
                    System.err.println("Invalid row: " + line);
                    continue;
                }

                String customerName = data[0].trim();
                String contactNumber = data[1].trim();
                String oem = data[2].trim();
                String vin = data[3].trim();
                String[] serviceNames = data[4].trim().split("\\|");

                if (!customerName.equals(currentCustomerName)) {
                    customer = new Customer(customerName, contactNumber);
                    currentCustomerName = customerName;
                    currentContactNumber = contactNumber;
                }

                Vehicle vehicle = new Vehicle(oem, vin);
                customer.addVehicle(vehicle);

                for (String serviceName : serviceNames) {
                    try {
                        Service service = ServiceFactory.getServiceByName(serviceName.trim());
                        vehicle.addService(service);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customer;
    }


}
