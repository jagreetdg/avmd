import java.util.*;
public class CHTicket extends Ticket
{
    public static String currency = "$";// Currency
    private String no;// Ticket No.
    private String passName; // Names Of Passengers
    private double price;// Price Of Ticket
    private String des; // Destination
    private ID cHeliID ; // Commercial Heli ID
    private int passNo = 1 ; // NO. of Passengers
    private static float rate ; // Rate Of Ticket per Passenger
    public String[] getName()
     {   String[] sArgs = {this.passName};
       return sArgs;}
    public double getPrice()
    { return this.price; }
    public double getRate()
    { return rate;}
    public int getPassNo()
    { return this.passNo; }
    public String getNo()
    { return this.no; }
    public String getDestination()
    {return this.des;}
    public String getID()
    {return this.cHeliID.toString();}
    public static void setRate()
    { 
        float t;
        do{try{
            System.out.println("Enter Ticket Rate For Heli Carriers");
            Scanner sc= new Scanner(System.in);
            t = sc.nextFloat();
        if(t<=0.0)
        {
            System.err.println("Rate Must Be a Non-Zero Positive Number");
            continue;
        }
        break;
        }
        catch(InputMismatchException ex)
        {System.err.println("Wrong Input ; Enter a Number");}
    }while(true);
         rate = t;
    }
    public static void setCurrency(String curr)
    {
        currency = curr;
    }
    public CHTicket()throws NotInitiallizedException
    {
       if(rate==0.0)
       throw new NotInitiallizedException();
       String s;
       do{
       System.out.println("Enter Commercial Helicopter ID");
       Scanner in = new Scanner (System.in);
       s = in.nextLine().toUpperCase();
       if(s.length()<6)
       {
           System.err.println("Enter ID Of atleast 6 Characters");
           continue;
        }
        break;
       }while(true);
       this.cHeliID = new ID(s);
       System.out.println("Enter Destination");
       Scanner in = new Scanner (System.in);
       this.des = in.nextLine();
       this.price = rate*this.passNo;
       System.out.println("Enter Name Of Passenger");
       Scanner sc = new Scanner (System.in);
       this.passName = sc.nextLine();
       this.no = Integer.toString(c);
   }
    public String toString()
    {
       String s = "Ticket Type = Commercial Helicopter Ticket\n";
       s += "Ticket No. = "+this.no+"\n";
       s+="Passenger Name = "+passName+"\n";
       s+="Rate Per Passenger = "+currency+rate+"\n";
       String pass = "Passenger = ";
       s+="Total Price for "+pass+currency+this.price+"\n";
       s+="Destination = "+this.des+"\n";
       s+="Commercial Heli ID = "+this.cHeliID.toString()+"\n";
       return s;
    }
}