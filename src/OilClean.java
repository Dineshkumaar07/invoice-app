
public class OilClean implements Service {
    @Override
    public String getServiceName() {
        return "Oil Clean";
    }

    @Override
    public double getCost() {
        return 2749;
    }

    @Override
    public double getDiscountPercentage() {
        return 1;
    }
}