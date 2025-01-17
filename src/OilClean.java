public class OilClean implements Service{
    int INR;
    float discount;
    OilClean(int INR, float discount){
        this.INR = INR;
        this.discount = discount;
    }
    @Override
    public void doService(Vehicle v) {
        System.out.println("Oil Clean Done");

    }
}
