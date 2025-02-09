import java.util.Scanner;

class StarProductVehicle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n==== Star Protect Vehicle ====");
            System.out.println("1. Admin Login");
            System.out.println("3. UnderWriter Login");
            System.out.println("2. Exit Star Protect Vehicle");
            System.out.print("Enter your choice: ");

            choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    Admin.enterCredentials();
                    break;
                case 2:
                    System.out.println("UnderWriter Login");
                    enterUnderWriterCredentials();
                    return;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Choose from the above options only");
            }
        }
    }
}
