public class BasicService implements Service {
    @Override
    public String getServiceName() {
        return "Basic Service";
    }

    @Override
    public double getCost() {
        return 3599;
    }

    @Override
    public double getDiscountPercentage() {
        return 3;
    }
}