import java.util.*;
public class Jet extends Plane implements Airways
{
  private String info="Jet Plane";
  private double spd;
  private ID id;
  private String at,dt,day,date;
  private char p;
  public String getinfo(){return this.info;}
  public String getID(){return this.id.toString();}
  public char getp(){return this.p;}
  public String getat(){return this.at;}
  public String getdt(){return this.dt;}
  public String getday(){return this.day;}
  public String getdate(){return this.date;}
  public double getSpeed(){return this.spd;}
  public Jet(char ar,String st1,int l)
  {
      int ch1;
      DateInfo d = new DateInfo();
      this.p = ar;
      Scanner in = new Scanner (System.in);
      do{try{
          System.out.println("Enter Jet Speed in km/h");
          double lo = in.nextDouble();
          this.spd = lo;
          break;
        }catch(InputMismatchException e)
        {System.err.println("Wrong Type Entered;Enter a no.");}
         catch(Exception e)
         {   e.printStackTrace();
             System.err.println("Try Again");}
    }while(true);
      this.id = new ID();
      this.id.setAll(st1,l);
      this.at = d.getTime();
      this.day = d.getDay();
      this.date = d.getDate();
    }
  public Jet(char ar,String st1)
  {
      int ch1;
      DateInfo d = new DateInfo();
      this.p = ar;
      Scanner in = new Scanner (System.in);
      do{try{
          System.out.println("Enter Jet Speed in km/h");
          double lo = in.nextDouble();
          this.spd = lo;
          break;
        }catch(InputMismatchException e)
        {System.err.println("Wrong Type Entered;Enter a no.");}
         catch(Exception e)
         {   e.printStackTrace();
             System.err.println("Try Again");}
    }while(true);
      this.id = new ID();
      this.id.setAll(st1);
      this.at = d.getTime();
      this.day = d.getDay();
      this.date = d.getDate();
    }
public String toString()
{ String s,s0,s1,s2,s3,s4,s5,s6;
    s= "Date = "+this.date;
    s0="Day = "+this.day;
    s1="Jet I.D. = "+this.id;
    s2="Jet Speed = "+this.spd+" km/h";
    s3="Jet Port No. = "+this.p;
    s4="Jet Arrival Time = "+this.at;
    s5="Jet Departure Time = ";
    if (this.dt==null)
    s6="Not Departed";
    else
    s6 =this.dt;
    return (s+"\n"+s0+"\n"+s1+"\n"+s2+"\n"+s3+"\n"+s4+"\n"+s5+s6);
}
public void depart ()
{
    this.dt=depart(this.dt);
}
}