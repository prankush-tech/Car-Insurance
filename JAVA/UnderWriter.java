import java.util.*;
import java.text.*;

class UnderWriter{
    
    int id;
    String name;
    String dob;
    String joiningDate;
    String defaultPassword;

    UnderWriter(int id, String name, String dob, String joiningDate,String defaultPassword)
    {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.joiningDate = joiningDate;
        this.defaultPassword = defaultPassword;
    }

    public static void enterUnderWriterCredentials()
    {
        
    }

}

// import java.util.*;
// import java.text.*;

// class UnderWriter {
//     int id;
//     String name;
//     Date dob;
//     Date joiningDate;
//     String defaultPassword;

//     public static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

//     UnderWriter(int id, String name, String dob, String joiningDate, String defaultPassword) {
//         this.id = id;
//         this.name = name;
//         try {
//             this.dob = format.parse(dob);
//             this.joiningDate = format.parse(joiningDate);
//         } catch (ParseException e) {
//             throw new RuntimeException("Invalid date format. Expected dd/MM/yyyy", e);
//         }
//         this.defaultPassword = defaultPassword;
//     }
// }
