import java.util.*;

//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        InputHandler inputHandler = new InputHandler(scanner);
//        Customer customer = inputHandler.createCustomer();
//        customer.generateInvoices();
//    }
//}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to input data manually or use a CSV file? (1 for manual, 2 for CSV): ");
        int choice = scanner.nextInt();

        Customer customer;
        if (choice == 1) {
            InputHandler inputHandler = new InputHandler(scanner);
            customer = inputHandler.createCustomer();
        } else if (choice == 2) {
            System.out.print("Enter the path to the CSV file: ");
            String filePath = scanner.next();
            DataInput adapter = new CSVInputAdapter(filePath);
            customer = adapter.getCustomerFromData();
        } else {
            System.out.println("Invalid choice. Exiting.");
            return;
        }

        customer.generateInvoices();
    }
}
