public class BasicService implements Service{
    int INR;
    float discount;
    BasicService(int INR, float discount){
        this.INR = INR;
        this.discount = discount;
    }
    @Override
    public void doService(Vehicle v) {
        System.out.println("Basic Service Done");
    }
}
