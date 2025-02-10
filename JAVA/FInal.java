import java.util.*;
import java.text.SimpleDateFormat;

class VehicleInsurance {
    private static int policyCounter = 1000; // Auto-incremented Policy Number
    private int policyNo;
    private String vehicleNo;
    private String vehicleType;
    private String customerName;
    private int engineNo;
    private int chasisNo;
    private long phoneNo;
    private String insuranceType;
    private double premiumAmt;
    private Date fromDate;
    private Date toDate;
    private int underWriterId;

    // Constructor
    public VehicleInsurance(String vehicleNo, String vehicleType, String customerName, int engineNo,
        int chasisNo, long phoneNo, String insuranceType, Date fromDate, int underWriterId) {
        this.policyNo = policyCounter++;
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.customerName = customerName;
        this.engineNo = engineNo;
        this.chasisNo = chasisNo;
        this.phoneNo = phoneNo;
        this.insuranceType = insuranceType;
        this.premiumAmt = calculatePremium(vehicleType, insuranceType);
        this.fromDate = fromDate;
        Calendar cal = Calendar.getInstance();
        cal.setTime(fromDate);
        cal.add(Calendar.DAY_OF_YEAR, 365);
        this.toDate = cal.getTime();
        this.underWriterId = underWriterId;
    }

    private double calculatePremium(String vehicleType, String insuranceType) {
        if (insuranceType.equalsIgnoreCase("Full Insurance")) {
            return vehicleType.equalsIgnoreCase("2-wheeler") ? 5000 : 10000;
        } else {
            return vehicleType.equalsIgnoreCase("2-wheeler") ? 2000 : 5000;
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return "PolicyNo: " + policyNo + ", VehicleNo: " + vehicleNo + ", VehicleType: " + vehicleType +
            ", CustomerName: " + customerName + ", EngineNo: " + engineNo + ", ChasisNo: " + chasisNo +
            ", PhoneNo: " + phoneNo + ", InsuranceType: " + insuranceType + ", PremiumAmt: " + premiumAmt +
            ", FromDate: " + sdf.format(fromDate) + ", ToDate: " + sdf.format(toDate) + ", UnderwriterId: " + underWriterId;
    }
}

public class InsuranceSystem {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List < VehicleInsurance > policies = new ArrayList < > ();

        System.out.print("Enter Underwriter ID: ");
        int underWriterId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < 2; i++) {
            System.out.println("\nEnter details for Vehicle Insurance " + (i + 1) + ":");
            System.out.print("Vehicle Number: ");
            String vehicleNo = scanner.nextLine();
            System.out.print("Vehicle Type (2-wheeler/4-wheeler): ");
            String vehicleType = scanner.nextLine();
            System.out.print("Customer Name: ");
            String customerName = scanner.nextLine();
            System.out.print("Engine Number: ");
            int engineNo = scanner.nextInt();
            System.out.print("Chassis Number: ");
            int chasisNo = scanner.nextInt();
            System.out.print("Phone Number (10 digits): ");
            long phoneNo = scanner.nextLong();
            scanner.nextLine(); // Consume newline
            System.out.print("Insurance Type (Full Insurance/ThirdParty): ");
            String insuranceType = scanner.nextLine();
            System.out.print("Enter Policy Start Date (dd-MM-yyyy): ");
            String dateInput = scanner.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date fromDate = sdf.parse(dateInput);

            VehicleInsurance policy = new VehicleInsurance(vehicleNo, vehicleType, customerName, engineNo, chasisNo, phoneNo, insuranceType, fromDate, underWriterId);
            policies.add(policy);
        }

        System.out.println("\nGenerated Vehicle Insurance Policies:");
        for (VehicleInsurance policy: policies) {
            System.out.println(policy);
        }
    }
}









System.out.print("\nEnter Policy Number to Renew: ");
int renewId = scanner.nextInt();
boolean found = false;
for (VehicleInsurance policy: policies) {
    if (policy.getPolicyNo() == renewId) {
        policy.renewPolicy();
        System.out.println("Policy Renewed Successfully!");
        System.out.println(policy);
        found = true;
        break;
    }
}
if (!found) {
    System.out.println("Policy not found!");
}

public void renewPolicy() {
    this.fromDate = new Date(); // Set to current date
    Calendar cal = Calendar.getInstance();
    cal.setTime(this.fromDate);
    cal.add(Calendar.DAY_OF_YEAR, 365);
    this.toDate = cal.getTime();
}









public void updatePolicyType(int policyNumber, String newType, Policy[] policies) {
    for (Policy policy: policies) {
        if (policy.getPolicyNo() == policyNumber) {
            if (newType.equalsIgnoreCase("Full Insurance") || newType.equalsIgnoreCase("Third Party")) {
                policy.setInsuranceType(newType);
                System.out.println("Policy updated successfully!");
            } else {
                System.out.println("Invalid insurance type! Choose 'Third Party' or 'Full Insurance'.");
            }
            return;
        }
    }
    System.out.println("Policy not found!");
}









while (true) {
    System.out.println("\n===== Insurance Policy System =====");
    System.out.println("1. View Policy by Vehicle ID");
    System.out.println("2. View Policy by Policy ID");
    System.out.println("3. Exit");
    System.out.print("Enter your choice: ");
    int choice = scanner.nextInt();

    switch (choice) {
        case 1:
            System.out.print("Enter Vehicle ID: ");
            String vehicleId = scanner.next();
            viewPolicyByVehicleId(vehicleId);
            break;
        case 2:
            System.out.print("Enter Policy ID: ");
            int policyId = scanner.nextInt();
            viewPolicyByPolicyId(policyId);
            break;
        case 3:
            System.out.println("Exiting... Thank you!");
            scanner.close();
            System.exit(0);
        default:
            System.out.println("Invalid choice! Please try again.");
    }
}
}

public static void viewPolicyByVehicleId(String vehicleId) {
    for (Policy policy: policies) {
        if (policy.getVehicleNo().equalsIgnoreCase(vehicleId)) {
            policy.displayPolicyDetails();
            return;
        }
    }
    System.out.println("Policy not found for Vehicle ID: " + vehicleId);
}

public static void viewPolicyByPolicyId(int policyId) {
    for (Policy policy: policies) {
        if (policy.getPolicyNo() == policyId) {
            policy.displayPolicyDetails();
            return;
        }
    }
    System.out.println("Policy not found for Policy ID: " + policyId);
}