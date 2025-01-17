public class PartsChange implements Service {
    int INR;
    float discount;
    PartsChange(int INR, float discount){
        this.INR = INR;
        this.discount = discount;
    }
    @Override
    public void doService(Vehicle v) {
        System.out.println("Parts Changed");
    }
}
