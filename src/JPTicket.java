import java.util.*;
public class JPTicket extends Ticket
{
    public static String currency = "$";// Currency
    private String no;// Ticket No.
    private String passName; // Names Of Passengers
    private double price;// Price Of Ticket
    private String dis; // Distance
    private ID jetID ; // Jet ID
    private int passNo = 1 ; // NO. of Passengers
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
   public String getDistance()
   {return this.dis;}
   public String getID()
   {return this.jetID.toString();}
   public static void setRate()
    { 
        float t;
        do{try{
            System.out.println("Enter Ticket Rate For Jet Planes");
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
    public JPTicket()throws NotInitiallizedException
    {
       if(rate==0.0)
       throw new NotInitiallizedException();
        String s;
       do{
       System.out.println("Enter Jet ID");
       Scanner in = new Scanner (System.in);
       s = in.nextLine();
       if(s.length()<6)
       {
           System.err.println("Enter ID Of atleast 6 Characters");
           continue;
        }
        break;
       }while(true);
       s = s.substring(0,6).toUpperCase();
       this.jetID = new ID(s);
       Scanner in = new Scanner (System.in);
       do{try{
       Scanner inp = new Scanner (System.in);
       System.out.println("Enter Distance in kms");
       this.dis = Double.toString(inp.nextDouble());
       break;
       }
       catch(InputMismatchException ie)
       {System.err.println("Wrong Input ; Enter a Decimal Number");}
        }while(true);
       this.price = rate;
       System.out.println("Enter Passenger Name");
       Scanner inp = new Scanner(System.in);
       this.passName = inp.nextLine();
       this.no = Integer.toString(c++);
   }
   public String toString()
   {
       String s = "Ticket Type = Jet Ticket\n";
       s += "Ticket No. = "+this.no+"\n";
       s+= "Passenger Name = "+passName+"\n";
       s+="Rate Per Passenger = "+currency+rate+"\n";
       String pass = "Passenger = ";
       s+="Total Price for "+pass+currency+this.price+"\n";
       s+="Distance = "+this.dis+" km\n";
       s+="Jet ID = "+this.jetID.toString()+"\n";
       return s;
    }
     
}