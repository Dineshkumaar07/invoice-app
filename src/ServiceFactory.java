import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {
    private static final Map<Integer, Service> serviceIdMap = new HashMap<>();
    private static final Map<String, Service> serviceNameMap = new HashMap<>();

    static {
        serviceIdMap.put(1, new BasicService());
        serviceIdMap.put(2, new OilClean());
        serviceIdMap.put(3, new PartsChange());

        serviceNameMap.put("Basic", new BasicService());
        serviceNameMap.put("OilClean", new OilClean());
        serviceNameMap.put("PartsChange", new PartsChange());
    }

    public static Service getServiceById(int serviceId) {
        if (serviceIdMap.containsKey(serviceId)) {
            return serviceIdMap.get(serviceId);
        } else {
            throw new IllegalArgumentException("Invalid service ID: " + serviceId);
        }
    }

    public static Service getServiceByName(String serviceName) {
        if (serviceNameMap.containsKey(serviceName)) {
            return serviceNameMap.get(serviceName);
        } else {
            throw new IllegalArgumentException("Invalid service name: " + serviceName);
        }
    }

    public static void displayServiceMenu() {
        System.out.println("Available Services:");
        serviceIdMap.forEach((id, service) -> {
            System.out.printf("%d. %s - %.2f INR - %.0f%% Discount%n",
                    id, service.getServiceName(), service.getCost(), service.getDiscountPercentage());
        });
    }
}
