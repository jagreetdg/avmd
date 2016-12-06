import java.io.*;
import java.util.*;
public abstract class Reservation
{
    private static PrintWriter outStrm = new PrintWriter(System.out,true);
    private static PrintWriter errStrm = new PrintWriter(System.err,true);
    public static Ticket PlaneTicket()throws NotInitiallizedException
    {
        outStrm.println("Enter Your Choice");
        outStrm.println("1) Commercial Plane");
        outStrm.println("2) Jet Plane");
        int ch;
        do{try{
            Scanner in = new Scanner(System.in);
            ch=in.nextInt();
            if(ch==1||ch==2)
            break;
            else
            throw new RangeMismatchException();
        }
        catch(InputMismatchException e1)
        {errStrm.println("Wrong Type Inputted ; Input A Digit");}
        catch(RangeMismatchException e2)
        {errStrm.println(e2+"\nEnter either 1 & 2");}
        }while(true);
        try{
        try{
        switch(ch)
        {
            case 1  : Ticket ct = new CPTicket();
                      return ct;
            case 2  : Ticket ct2 = new JPTicket();
                      return ct2;
            default : throw new UnexpectedAbortionException();
        }
        }
        catch (NotInitiallizedException e3)
        {   if(ch==1)
            errStrm.println("Rate Of Ticket Or Capacity Of Plane Not Initiallized By The Controller");
            else if(ch==2)
            errStrm.println("Rate Of Ticket Not Initiallized By The Controller");
            else
            throw new UnexpectedAbortionException();
            errStrm.println("Please Try Again Later");
            throw e3;
        }
        }
        catch(UnexpectedAbortionException e4)
        {errStrm.println(e4);}
        return null;
        }
        public static Ticket HeliTicket() throws NotInitiallizedException
    {
        outStrm.println("Enter Your Choice");
        outStrm.println("1) Commercial Helicopter");
        outStrm.println("2) Heli Carrier");
        int ch;
        do{try{
            Scanner in = new Scanner(System.in);
            ch=in.nextInt();
            if(ch==1||ch==2)
            break;
            else
            throw new RangeMismatchException();
        }
        catch(InputMismatchException e1)
        {errStrm.println("Wrong Type Inputted ; Input A Digit");}
        catch(RangeMismatchException e2)
        {errStrm.println(e2+"\nEnter either 1 & 2");}
        }while(true);
        try{
        try{
        switch(ch)
        {
            case 1  : Ticket ct = new CHTicket();
                      return ct;
            case 2  : Ticket ct2 = new HCTicket();
                      return ct2;
            default : throw new UnexpectedAbortionException();
        }
        }
        catch (NotInitiallizedException e3)
        {   
            errStrm.println("Rate Of Ticket Not Initiallized By The Controller");
            errStrm.println("Please Try Again Later");
            throw e3;
        }
        }
        catch(UnexpectedAbortionException e4)
        {errStrm.println(e4);}
        return null;
        }
        
    }