import java.util.*;
public class HCTicket extends Ticket
{
    public static String currency = "$";// Currency
    private String no;// Ticket No.
    private String passName; // Names Of Passengers
    private double price;// Price Of Ticket
    private Troops trp; // Troop
    private ID hCarrierID ; // HeliCarrier ID
    private int passNo = 1; // NO. of Passengers
    private static float rate; // Rate Of Ticket per Passenger
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
   public Troops getTroop()
   {return this.trp;}
   public String getID()
   {return this.hCarrierID.toString();}
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
    public HCTicket()throws NotInitiallizedException
    {
       if(rate==0.0)
       throw new NotInitiallizedException();
       String s;
       do{
       System.out.println("Enter Heli Carrier ID");
       Scanner in = new Scanner (System.in);
       s = in.nextLine().toUpperCase();
       if(s.length()<6)
       {
           System.err.println("Enter ID Of atleast 6 Characters");
           continue;
        }
        break;
       }while(true);
       Scanner in = new Scanner (System.in);
       s = s.substring(0,6);
       this.hCarrierID = new ID(s);
       this.trp = ID.checkTrp(s);
       this.price = rate*this.passNo;
       System.out.println("Enter Name Of Passenger");
       this.passName = in.nextLine();
       this.no=Integer.toString(c);
   }
   public static void setCurrency(String curr)
    {
        currency = curr;
    }
   public String toString()
   {
       String s = "Ticket Type = Heli Carrier Ticket\n";
       s += "Ticket No. = "+this.no+"\n";
       s+="Passenger Name = "+passName+"\n";
       s+="Rate Per Passenger = "+currency+rate+"\n";
       String pass="Passenger = ";
       s+="Total Price for "+pass+currency+this.price+"\n";
       if (this.trp != null)
       s+="Troop = "+this.trp+"\n";
       else
       s+="Troop = Not Yet Defined\n";
       s+="Heli Carrier ID = "+this.hCarrierID.toString()+"\n";
       return s;
    }
 } 