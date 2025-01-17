import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {
    private static final Map<Integer, Service> serviceMap = new HashMap<>();

    static {
        serviceMap.put(1, new BasicService());
        serviceMap.put(2, new OilClean());
        serviceMap.put(3, new PartsChange());
    }

    public static Service getService(int serviceId) {
        if (serviceMap.containsKey(serviceId)) {
            return serviceMap.get(serviceId);
        } else {
            throw new IllegalArgumentException("Invalid service ID. Please select a valid service.");
        }
    }

    public static void displayServiceMenu() {
        System.out.println("Available Services:");
        System.out.println("1. Basic Service - 3599 INR - 3% Discount");
        System.out.println("2. Oil Clean - 2749 INR - 1% Discount");
        System.out.println("3. Parts Charge - 32499 INR - 5% Discount");
    }
}
