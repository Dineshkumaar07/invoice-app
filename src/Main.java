
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();

        System.out.print("Do you want to input data manually or use a CSV file? (1 for manual, 2 for CSV): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("How many customers do you want to input? ");
            int customerCount = scanner.nextInt();
            InputHandler inputHandler = new InputHandler(scanner);

            for (int i = 0; i < customerCount; i++) {
                System.out.println("Enter details for Customer " + (i + 1) + ":");
                customers.add(inputHandler.createCustomer());
            }
        } else if (choice == 2) {
            System.out.print("Enter the path to the CSV file: ");
            String filePath = scanner.next();
            DataInput adapter = new CSVInputAdapter(filePath);

            customers = adapter.getCustomersFromData();
        } else {
            System.out.println("Invalid choice. Exiting.");
            return;
        }

        for (Customer customer : customers) {
            customer.generateInvoices();
        }
    }
}
