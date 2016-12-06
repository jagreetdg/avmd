import java.util.*;
public class CPTicket extends Ticket
{
    public static int cap=0; // Plane Capacity
    public static String currency = "$";// Currency
    private String no;// Ticket No.
    private String[] passName; // Names Of Passengers
    private double price;// Price Of Ticket
    private Airlines air; // Airline
    private ID planeID ; // Plane ID
    private int passNo ; // NO. of Passengers
    private static float rate = 0.0f; // Rate Of Ticket per Passenger
    public static void setCap()
    {
        int t;
        do{try{
            System.out.println("Enter Capacity For Commercial Planes");
            Scanner sc= new Scanner(System.in);
            t = sc.nextInt();
        if(t<=0)
        {
            System.err.println("Capacity Must Be a Non-Zero Positive Number");
            continue;
        }
        break;
        }
        catch(InputMismatchException ex)
        {System.err.println("Wrong Input ; Enter a Number");}
    }while(true);
         cap = t;
    }
    public static void setRate()
    { 
        float t;
        do{try{
            System.out.println("Enter Ticket Rate For Commercial Planes");
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
    public CPTicket()throws NotInitiallizedException
    {
       if(cap==0||rate==0.0)
       throw new NotInitiallizedException();
       String s;
       do{
       System.out.println("Enter Plane ID");
       Scanner in = new Scanner (System.in);
       s = in.nextLine().toUpperCase();
       if(s.length()<6)
       {
           System.err.println("Enter ID Of atleast 6 Characters");
           continue;
        }
        break;
       }while(true);
       s = s.substring(0,6);
       this.planeID = new ID(s);
       this.air = ID.checkAir(s);
       Scanner in = new Scanner (System.in);
       do{try{
       System.out.println("Enter No. Of Passengers");
       Scanner in1 = new Scanner (System.in);
       this.passNo = in1.nextInt();
       if(this.passNo>cap||this.passNo<1)
       throw new RangeMismatchException();
       break;
       }
       catch(InputMismatchException e)
       {System.err.println("Wrong Input ; Enter an Integer");}
       catch(RangeMismatchException e2)
       {System.err.println(e2+"\nEnter a no. between 1 and "+cap);}
    }while(true);
    passName = new String[this.passNo];
    this.price = rate*this.passNo;
    if(this.passNo==1)
    {System.out.println("Enter Name Of Passenger - ");
     this.passName[0] = in.nextLine();}
    else{
    for(int i = 0;i<this.passNo;i++)
    {   System.out.println("Enter Name Of Passenger No. - "+(i+1));
        this.passName[i] = in.nextLine();
    }}
    this.no = Integer.toString(c++);
   }
   public String[] getName()
   { return this.passName;}
   public double getPrice()
   { return this.price; }
   public double getRate()
   { return rate;}
   public int getPassNo()
   { return this.passNo; }
   public String getNo()
   { return this.no; }
   public Airlines getAirline()
   {return this.air;}
   public String getID()
   {ID id = this.planeID;
    String s = this.planeID.toString();
    return s;}
   public String toString()
   {
       String s = "Ticket Type = Commercial Plane Ticket\n";
       s += "Ticket No. = "+this.no+"\nNo. Of Passengers = "+this.passNo+"\n";
       int c = 1;
       if(passName.length == 1)
       s+="Passenger = "+passName[0]+"\n";
       else
       {
       s+="List Of Passengers - \n";
       for (String z : passName)
       {s+="Name Of Passenger "+c+" = "+z+"\n";c++;}
       }
       s+="Rate Per Passenger = "+currency+rate+"\n";
       String pass = (this.passNo>1)? (this.passNo+" Passengers = ") : ("Passenger = ");
       s+="Total Price for "+pass+currency+this.price+"\n";
       if(this.air!=null)
       s+="Airline = "+this.air+"\n";
       else
       s+="Airline = Not Yet Defined\n";
       s+="Plane ID = "+this.planeID.toString()+"\n";
       return s;
    }
} 