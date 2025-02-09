import java.util.*;

class Admin {

    static int globalUnderwriterId = 0;
    static ArrayList<UnderWriter> underWriterArray = new ArrayList<>();

    public static int generateUniqueID() {
        globalUnderwriterId++;
        return globalUnderwriterId;
    }

    public static String defaultPasswordGenerate(String name, String dob) {
        return (name + "@" + dob);
    }

    public static void deleteUnderwriter(int id) {

        Scanner in = new Scanner(System.in);
        
        while(true)
        {
            System.out.println("1. Sure wated to Delete? Yes?");
            System.out.println("2. No? Go Back");
            System.out.print("Enter Your Choice: ");
            
            int ch = in.nextInt();in.nextLine();
            if(ch==1)
            {
    
                boolean removed = underWriterArray.removeIf(user -> user.id == id);
        
                if (removed) {
                    System.out.println("\nUser Deleted Successfully");
                    return;
                } else {
                    System.out.println("\nInvalid ID Entered");
                    return;
                }
            }
            else{
                return;
            }
        }


    }

    public static void updateUnderwriterPassword(int id, String newPass) {
        boolean flag = false;
        for (UnderWriter user : underWriterArray) {
            if (user.id == id) {
                user.defaultPassword = newPass;
                System.out.println("\nPassword Updated");
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("\nInvalid ID Entered");
        }
    }

    public static void searchUnderwriter() {


        Scanner in = new Scanner(System.in);
        int choice ;
        
        while(true)
        {
            
            System.out.println("\n====================================================================");
            System.out.println("1. Enter to View All");
            System.out.println("2. Search By ID ");
            System.out.println("3. Go Back");
            System.out.print("Enter your Choice:  ");
            choice = in.nextInt();in.nextLine();

            switch(choice)
            {
                case 1:
                    justView();
                    break;
                case 2:
                    System.out.print("Enter ID to Search: ");
                    int idTOSearch = in.nextInt();
                    in.nextLine();

                    
                    boolean flag = false;
                    System.out.println("\nID || NAME || Date-of-Birth || Date-of-Joining || Default-Password");
                    System.out.println("====================================================================");

                    for (UnderWriter underwriter : underWriterArray) {
                        if (underwriter.id == idTOSearch) {
                            System.out.println("===== Found ====");
                            flag = true;
                            System.out.println(underwriter.id + " || " + underwriter.name + " || " +
                                    underwriter.dob + " || " + underwriter.joiningDate + " || " + underwriter.defaultPassword);
                            break;
                        }
                    }

                    if (!flag) {
                        System.out.println("No Underwriter User Found with the ID\n");
                    }

                    break;
                case 3:
                    System.out.print("\nGoing back...");
                    return;

                default:
                    System.out.println("\nChoose from the above options only");
                    

            }
        }

    }

    public static void registerUnderwriter() {
        Scanner in = new Scanner(System.in);

        System.out.println("\n===== Register/Create Underwriter ====");
        System.out.print("Enter Name of UnderWriter: ");
        String name = in.nextLine();

        System.out.print("Enter Date of Birth: ");
        String dob = in.nextLine();

        System.out.print("Enter Date of Joining: ");
        String joiningDate = in.nextLine();

        String defaultPassword = defaultPasswordGenerate(name, dob);
        int id = generateUniqueID();

        underWriterArray.add(new UnderWriter(id, name, dob, joiningDate, defaultPassword));
        System.out.println("\nUnderWriter Successfully Registered");
    }

    public static void viewAllUnderwriters() {

        justView();

    }

    public static void vehicleOptions()
    {
        System.out.print("All Vehicles");
    }

    public static void justView()
    {
        
        System.out.println("\nID || NAME || Date-of-Birth || Date-of-Joining || Default-Password");
        System.out.println("====================================================================");
        for (UnderWriter underwriter : underWriterArray) {
            System.out.println(underwriter.id + " || " + underwriter.name + " || " +
                    underwriter.dob + " || " + underwriter.joiningDate + " || " + underwriter.defaultPassword);
        }
        System.out.println();
    }

    public static void adminControls() {
        Scanner in = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n==== Welcome to Admin Home Page ====");
            System.out.println("1. Register/Create Underwriter");
            System.out.println("2. Search Underwriter by ID");
            System.out.println("3. Update Underwriter Password");
            System.out.println("4. Delete Underwriter by ID");
            System.out.println("5. View All Underwriters");
            System.out.println("6. Vehicle Options");
            System.out.println("7. Logout");
            System.out.print("Enter your choice: ");

            choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    registerUnderwriter();
                    break;
                case 2:
                    searchUnderwriter();
                    break;
                case 3:
                    System.out.println("Enter the id Whose Passwrod needs to change: ");
                    int idToSch = in.nextInt();in.nextLine();

                    System.out.println("Enter the new Password");
                    String newPass = in.nextLine();
                    updateUnderwriterPassword(idToSch,newPass);
                    break;
                case 4:
                System.out.print("Enter the id to Delete: ");
                int idToDel = in.nextInt();in.nextLine();
                    deleteUnderwriter(idToDel);
                    break;
                case 5:
                    viewAllUnderwriters();
                    break;
                case 6:
                    vehicleOptions();
                    break;
                case 7:
                    System.out.println("\nLogging out... Returning to Main Menu.");
                    return; 
                default:
                    System.out.println("\nChoose from the above options only");
            }
        }
    }

    public static void enterCredentials() {
        Scanner in = new Scanner(System.in);
        String id, pass;

        while (true) {
            System.out.print("\nEnter Admin UserID: ");
            id = in.nextLine();
            System.out.print("Enter Admin Password: ");
            pass = in.nextLine();

            if (id.equals("prank") && pass.equals("Super")) {
                System.out.println("Login Successful");
                adminControls();
                return;
            } else {
                System.out.println("Invalid Credentials");
            }
        }
    }
}
