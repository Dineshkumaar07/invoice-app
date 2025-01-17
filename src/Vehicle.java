import java.util.ArrayList;
import java.util.List;

class Vehicle {
    private String oem;
    private String vin;
    private List<Service> services;

    Vehicle(String oem, String vin) {
        this.oem = oem;
        this.vin = vin;
        this.services = new ArrayList<>();
    }

    public String getOem() {
        return oem;
    }

    public String getVin() {
        return vin;
    }

    public void addService(Service service) {
        if (hasService(service)) {
            System.out.println("Service '" + service.getServiceName() + "' is already added to this vehicle.");
        } else {
            this.services.add(service);
            System.out.println("Service '" + service.getServiceName() + "' added successfully.");
        }
    }

    public boolean hasService(Service service) {
        for (Service s : services) {
            if (s.getServiceName().equalsIgnoreCase(service.getServiceName())) {
                return true;
            }
        }
        return false;
    }

    public List<Service> getServices() {
        return services;
    }
}
