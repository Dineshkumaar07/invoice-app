public class PartsChange implements Service {
    @Override
    public String getServiceName() {
        return "Parts Charge";
    }

    @Override
    public double getCost() {
        return 32499;
    }

    @Override
    public double getDiscountPercentage() {
        return 5;
    }
}