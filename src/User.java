import java.util.*;
import java.util.concurrent.*;
public class User implements Runnable
{
  public Ticket tic=null;
  private boolean boardingStatus = false;
  String[] name;
  public User()
  {
      System.out.println("Welcome to Aviation Management");
    }
  public boolean reserveTicket()
  {
      System.out.println("Choose Your Ticket - ");
      System.out.println("1) Plane Ticket");
      System.out.println("2) Helicopter Ticket");
      System.out.println("3) Exit");
      int ch;
      boolean flag = false;
      do{try{
          Scanner in = new Scanner(System.in);
          ch = in.nextInt();
          if(ch<1||ch>3)
          throw new RangeMismatchException();
          break;
        }
        catch(InputMismatchException e1)
        {System.err.println("Wrong Input ; Enter a Number");}
        catch(RangeMismatchException e2)
        {System.err.println(e2+"\nEnter a Number between 1 and 3");}
    }while(true);
    try{
    switch(ch)
    {
        case 1  : this.tic = Reservation.PlaneTicket();
                  flag = true;
                  break;
        case 2  : this.tic = Reservation.HeliTicket();
                  flag = true;
                  break;
        case 3  : return false;
        default : throw new UnexpectedAbortionException();
    }
    }
    catch (NotInitiallizedException e3)
        {flag = false;}
    if(flag)
    {
        boardingStatus = false;
        System.out.println("Transaction Successful");
    }
    else
    System.out.println("Transaction Failed");
    return flag;
  }
  public void board()
  {
      String clss = tic.getClass().getSimpleName();
      if(!(clss.equals("CPTicket")||clss.equals("JPTicket")||clss.equals("CHTicket")||clss.equals("HCTicket")))
      throw new UnexpectedAbortionException();
      if(clss.equals("CPTicket")||clss.equals("JPTicket"))
      for(Plane p : Airport_Manager.a)
      {if(p.getID().equals(tic.getID()))
      {
          System.err.println("Reserved Plane Has Arrived For Ticket No. "+tic.getNo());
          System.err.println("Boarding Plane");
          System.out.println("Ticket Details - ");
          System.out.println(tic);
          System.out.println("Plane Details - ");
          System.out.println(p);
          System.out.println("Happy Journey");
          String[] names = tic.getName();
          if(names.length==1)
          System.out.println("User - "+names[0]+" Has Boarded His Reserved Plane");
          else{
          int c = 1;
          System.out.println("Users - ");
          for(String n : names)
          System.out.println((c++)+") "+n);
          System.out.println("Have Boarded Their Reserved Plane");
        }
          this.boardingStatus = true;
        }}
      if(clss.equals("CHTicket")||clss.equals("HCTicket"))
      for(Heli h : Airport_Manager.a1)
      {if(h.getID().equals(tic.getID()))
      {
          System.err.println("Reserved Helicopter Has Arrived For Ticket No. "+tic.getNo());
          System.err.println("Boarding Helicopter");
          System.out.println("Ticket Details - ");
          System.out.println(tic);
          System.out.println("Helicopter Details - ");
          System.out.println(h);
          System.out.println("Happy Journey");
          String[] names = tic.getName();
          if(names.length==1)
          System.out.println("User - "+names[0]+" Has Boarded His Reserved Helicopter");
          else{
          int c = 1;
          System.out.println("Users - ");
          for(String n : names)
          System.out.println((c++)+") "+n);
          System.out.println("Have Boarded Their Reserved Helicopter");
        }
          this.boardingStatus = true;
          Airport_Manager.addUser(this);
          }}
      return;
    }
  public void run()
  {
     do
     {
      Thread.yield();
      this.board();
      }while(!boardingStatus);
    }
 public boolean main()
  {
      if(!this.reserveTicket())
      {System.err.println("Reservation Not Completed");
      return false;}
      ExecutorService exServ = Executors.newSingleThreadExecutor();
      exServ.execute(this);
      /*Thread t = new Thread(this);
      t.start();*/
      name=tic.getName();
      return true;
    }
}