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
                System.out.println("Parsed row: " + Arrays.toString(data)); // Debugging

                if (data.length < 5) {
                    System.err.println("Invalid row: " + line);
                    continue;
                }

                String customerName = data[0].trim();
                String contactNumber = data[1].trim();
                String oem = data[2].trim();
                String vin = data[3].trim();
                String[] serviceIds = data[4].trim().split("\\|");

                if (!customerName.equals(currentCustomerName)) {
                    customer = new Customer(customerName, contactNumber);
                    currentCustomerName = customerName;
                    currentContactNumber = contactNumber;
                }

                Vehicle vehicle = new Vehicle(oem, vin);
                customer.addVehicle(vehicle);

                for (String serviceIdStr : serviceIds) {
                    try {
                        int serviceId = Integer.parseInt(serviceIdStr.trim());
                        Service service = ServiceFactory.getService(serviceId);
                        vehicle.addService(service);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid Service ID in row: " + line);
                    } catch (IllegalArgumentException e) {
                        System.err.println("Service ID not found: " + serviceIdStr.trim());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customer;
    }


}
