import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVInputAdapter implements DataInput {
    private String filePath;

    public CSVInputAdapter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Customer> getCustomersFromData() {
        Map<String, Customer> customerMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String customerName = parts[0].trim();
                String contactNumber = parts[1].trim();
                String oem = parts[2].trim();
                String vin = parts[3].trim();
                String[] services = parts[4].split(";");

                Vehicle vehicle = new Vehicle(oem, vin);
                for (String serviceName : services) {
                    vehicle.addService(ServiceFactory.getServiceByName(serviceName.trim()));
                }

                String customerKey = customerName + "|" + contactNumber;
                if (!customerMap.containsKey(customerKey)) {
                    Customer customer = new Customer(customerName, contactNumber);
                    customerMap.put(customerKey, customer);
                }

                customerMap.get(customerKey).addVehicle(vehicle);
            }

        } catch (IOException e) {
            throw new RuntimeException("Error reading CSV file", e);
        }

        return new ArrayList<>(customerMap.values());
    }
}
