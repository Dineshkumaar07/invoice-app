import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler(scanner);
        Customer customer = inputHandler.createCustomer();
        customer.displayVehicleDetails();
    }
}