
import java.util.*;
public class Email {

    public static void main(String[] args) {
        Email email1 =new Email("Logesh", "SR");
        System.out.println(email1.showInfo());
    }





    private String firstname;
    private String lastname;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity=500;
    private int defaultPasswordLength=10;
    private String alternateEmail;
    private String companySuffix="xyz.com";


    //constructor to receive firstname, lastname
    public Email(String firstname, String lastname) {
        this.firstname=firstname;
        this.lastname=lastname;
        //System.out.println("EMAIL CREATED : "+this.firstname+this.lastname);

        //Asking for Department
        this.department=setDepartment();
        //System.out.println("DEPARTMENT : "+this.department);

        //Asking for Password
        this.password=randomPassword(defaultPasswordLength);
        //System.out.println("Your PAssword :"+this.password);

        //Generate email
        email=firstname.toLowerCase()+"."+lastname.toLowerCase()+"@"+department+"."+companySuffix;
        //System.out.println("Your EMail Id is: "+email);
    }

    //ask for the department

    private String setDepartment() {
        System.out.print("DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter department codes : ");
        try (Scanner sc = new Scanner(System.in)) {
            int depChoice=sc.nextInt();
            if(depChoice==1) {
                return "sales";
            }
            else if(depChoice==2) {
                return "Dev";
            }
            else if(depChoice==3) {
                return "Acct";
            }
            else {
                return "";
            }
        }

    }

    //Generate random password

    private String randomPassword(int length) {
        String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[]password=new char[length];
        for(int i=0;i<length;i++) {
            int rand=(int)(Math.random()*passwordSet.length());
            password[i]=passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Set Mailbox Capacity

    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity=capacity;
    }

    //Set ALternate Email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail=altEmail;
    }

    //Change Password
    public void changePassword(String password) {
        this.password=password;
    }

    //Get Methods
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }
    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "EMPLOYEE NAME : "+firstname+" "+lastname +" "+
                "\nEMPLOYEE EMAIL ID: "+email+" "+
                "\nMAILBOX CAPACITY: "+mailboxCapacity;
    }

}

