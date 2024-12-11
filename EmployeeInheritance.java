// Base Employee class
class Employee {
    String empName;
    String empId;
    String address;
    String mailId;
    String mobileNo;

    public Employee(String empName, String empId, String address, String mailId, String mobileNo) {
        this.empName = empName;
        this.empId = empId;
        this.address = address;
        this.mailId = mailId;
        this.mobileNo = mobileNo;
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee Name: " + empName);
        System.out.println("Employee ID: " + empId);
        System.out.println("Address: " + address);
        System.out.println("Mail ID: " + mailId);
        System.out.println("Mobile No: " + mobileNo);
    }
}

// Derived classes
class Programmer extends Employee {
    double basicPay;

    public Programmer(String empName, String empId, String address, String mailId, String mobileNo, double basicPay) {
        super(empName, empId, address, mailId, mobileNo);
        this.basicPay = basicPay;
    }

    public void generatePaySlip() {
        double da = 0.97 * basicPay;
        double hra = 0.10 * basicPay;
        double pf = 0.12 * basicPay;
        double staffClubFund = 0.001 * basicPay;
        double grossSalary = basicPay + da + hra;
        double netSalary = grossSalary - (pf + staffClubFund);

        displayEmployeeDetails();
        System.out.println("Basic Pay: " + basicPay);
        System.out.println("Gross Salary: " + grossSalary);
        System.out.println("Net Salary: " + netSalary);
    }
}

class TeamLead extends Programmer {
    public TeamLead(String empName, String empId, String address, String mailId, String mobileNo, double basicPay) {
        super(empName, empId, address, mailId, mobileNo, basicPay);
    }
}

class AssistantProjectManager extends Programmer {
    public AssistantProjectManager(String empName, String empId, String address, String mailId, String mobileNo, double basicPay) {
        super(empName, empId, address, mailId, mobileNo, basicPay);
    }
}

class ProjectManager extends Programmer {
    public ProjectManager(String empName, String empId, String address, String mailId, String mobileNo, double basicPay) {
        super(empName, empId, address, mailId, mobileNo, basicPay);
    }
}

// Main class to test the inheritance
public class EmployeeInheritance {
    public static void main(String[] args) {
        // Create instances of different employee types
        Programmer programmer = new Programmer("John Doe", "P101", "123 Street", "john.doe@example.com", "9876543210", 50000);
        TeamLead teamLead = new TeamLead("Jane Smith", "TL201", "456 Avenue", "jane.smith@example.com", "8765432109", 70000);
        AssistantProjectManager apm = new AssistantProjectManager("Mark Taylor", "APM301", "789 Boulevard", "mark.taylor@example.com", "7654321098", 80000);
        ProjectManager projectManager = new ProjectManager("Alice Brown", "PM401", "101 Road", "alice.brown@example.com", "6543210987", 100000);

        // Generate pay slips for each employee
        System.out.println("\nPay Slip for Programmer:");
        programmer.generatePaySlip();

        System.out.println("\nPay Slip for Team Lead:");
        teamLead.generatePaySlip();

        System.out.println("\nPay Slip for Assistant Project Manager:");
        apm.generatePaySlip();

        System.out.println("\nPay Slip for Project Manager:");
        projectManager.generatePaySlip();
    }
}

