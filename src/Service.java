public interface Service {
    String getServiceName();
    double getCost();
    double getDiscountPercentage();

    default double getDiscountedCost() {
        return getCost() - (getCost() * getDiscountPercentage() / 100);
    }
}
