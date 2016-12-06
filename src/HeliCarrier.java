import java.util.*;
public class HeliCarrier extends Heli implements Airways
{ private String info = "Heli Carrier";
  private Troops trp;
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
  public Troops getTroop(){return this.trp;}
  public HeliCarrier(int l,char ar)
  {  int ch1;
      DateInfo d = new DateInfo();
      System.out.println("Enter Troop");
      int ord = 0;
      for (Troops t : Troops.values())
      { 
          ord = t.ordinal()+1;
          System.out.println(ord+") "+t);
        }
      do{try{
          Scanner in2 = new Scanner (System.in);
          ch1 = in2.nextInt();
          if(!(ch1>=1&&ch1<=ord))
          throw new RangeMismatchException();
          break;}
      catch(InputMismatchException e)
      {System.err.println("Wrong Input ; Enter Integer");}
      catch(RangeMismatchException e1)
      {System.err.println("Choice Out Of Range ; Enter a Value between 1 & "+ord);}
    }while(true);
      boolean testres = false;
    for (Troops air : Troops.values())
        if(air.ordinal()+1==ch1)
        {this.trp = air;
            testres = true;}
            if(!testres)
            throw new UnexpectedAbortionException();
      this.id = new ID();
      this.id.setAll(trp,l);
      this.p = ar;
      this.at = d.getTime();
      this.day = d.getDay();
      this.date = d.getDate();
}
public HeliCarrier(char ar)
  {  int ch1;
      DateInfo d = new DateInfo();
      System.out.println("Enter Troop");
      int ord = 0;
      for (Troops t : Troops.values())
      { 
          ord = t.ordinal()+1;
          System.out.println(ord+") "+t);
        }
      do{try{
          Scanner in2 = new Scanner (System.in);
          ch1 = in2.nextInt();
          if(!(ch1>=1&&ch1<=ord))
          throw new RangeMismatchException();
          break;}
      catch(InputMismatchException e)
      {System.err.println("Wrong Input ; Enter Integer");}
      catch(RangeMismatchException e1)
      {System.err.println("Choice Out Of Range ; Enter a Value between 1 & "+ord);}
    }while(true);
      boolean testres = false;
    for (Troops air : Troops.values())
        if(air.ordinal()+1==ch1)
        {this.trp = air;
            testres = true;}
            if(!testres)
            throw new UnexpectedAbortionException();
      this.id = new ID();
      this.id.setAll(trp);
      this.p = ar;
      this.at = d.getTime();
      this.day = d.getDay();
      this.date = d.getDate();
}
public HeliCarrier(String st1,int l,char ar)
  {  int ch1;
      DateInfo d = new DateInfo();
      System.out.println("Enter Troop");
      int ord = 0;
      for (Troops t : Troops.values())
      { 
          ord = t.ordinal()+1;
          System.out.println(ord+") "+t);
        }
      do{try{
          Scanner in2 = new Scanner (System.in);
          ch1 = in2.nextInt();
          if(!(ch1>=1&&ch1<=ord))
          throw new RangeMismatchException();
          break;}
      catch(InputMismatchException e)
      {System.err.println("Wrong Input ; Enter Integer");}
      catch(RangeMismatchException e1)
      {System.err.println("Choice Out Of Range ; Enter a Value between 1 & "+ord);}
    }while(true);
      boolean testres = false;
    for (Troops air : Troops.values())
        if(air.ordinal()+1==ch1)
        {this.trp = air;
            testres = true;}
            if(!testres)
            throw new UnexpectedAbortionException();
      this.id = new ID();
      this.id.setAll(st1,l);
      this.p = ar;
      this.at = d.getTime();
      this.day = d.getDay();
      this.date = d.getDate();
}
public HeliCarrier(String st1,char ar)
  {  int ch1;
      DateInfo d = new DateInfo();
      System.out.println("Enter Troop");
      int ord = 0;
      for (Troops t : Troops.values())
      { 
          ord = t.ordinal()+1;
          System.out.println(ord+") "+t);
        }
      do{try{
          Scanner in2 = new Scanner (System.in);
          ch1 = in2.nextInt();
          if(!(ch1>=1&&ch1<=ord))
          throw new RangeMismatchException();
          break;}
      catch(InputMismatchException e)
      {System.err.println("Wrong Input ; Enter Integer");}
      catch(RangeMismatchException e1)
      {System.err.println("Choice Out Of Range ; Enter a Value between 1 & "+ord);}
    }while(true);
      boolean testres = false;
    for (Troops air : Troops.values())
        if(air.ordinal()+1==ch1)
        {this.trp = air;
            testres = true;}
            if(!testres)
            throw new UnexpectedAbortionException();
      this.id = new ID();
      this.id.setAll(st1);
      this.p = ar;
      this.at = d.getTime();
      this.day = d.getDay();
      this.date = d.getDate();
}
public String toString()
{ String s,s0,s1,s2,s3,s4,s5,s6;
    s= "Date = "+this.date;
    s0="Day = "+this.day;
    s1="HeliCarrier I.D. = "+this.id;
    s2="Troop Carrier = "+this.trp;
    s3="HeliPad No. = "+this.p;
    s4="HeliCarrier Arrival Time = "+this.at;
    s5="HeliCarrier Departure Time = ";
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