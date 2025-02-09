class Vehicle 
{
    int policyNo;
    int vehicleNo;
    String vehicleType;
    String customerName;
    int engineNo;
    int chasisNo;
    int phoneNo;
    int premiumAmnt;
    String type; 
    String fromDate;
    String toDate;

    // Constructor
    public Vehicle(int policyNo, int vehicleNo, String vehicleType, String customerName, int engineNo, int chasisNo, 
                   int phoneNo, int premiumAmnt, String type, String fromDate, String toDate) {
        this.policyNo = policyNo;
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.customerName = customerName;
        this.engineNo = engineNo;
        this.chasisNo = chasisNo;
        this.phoneNo = phoneNo;
        this.premiumAmnt = premiumAmnt;
        this.type = type;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }
}
