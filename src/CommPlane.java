import java.util.*;
public class CommPlane extends Plane implements Airways
{ 
  private String info="Commercial Plane";
  private Airlines name;
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
  public Airlines getAirlines(){return this.name;}
  public CommPlane(char ar,int l)
  {  int ch1;
      DateInfo d = new DateInfo();
      Scanner in = new Scanner (System.in);
      System.out.println("Choose Airlines -");
      int ord = 0;
      for(Airlines air : Airlines.values())
      {
          ord = air.ordinal()+1;
          System.out.println(ord+") "+air);
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
        for (Airlines air : Airlines.values())
        if(air.ordinal()+1==ch1)
        {this.name = air;
            testres = true;}
            if(!testres)
            throw new UnexpectedAbortionException();
      this.id = new ID();
      this.id.setAll(name,l);
      this.p = ar;
      this.at = d.getTime();
      this.day = d.getDay();
      this.date = d.getDate();
}
public CommPlane(char ar)
  {  int ch1;
      DateInfo d = new DateInfo();
      Scanner in = new Scanner (System.in);
      System.out.println("Choose Airlines -");
      int ord = 0;
      for(Airlines air : Airlines.values())
      {
          ord = air.ordinal()+1;
          System.out.println(ord+") "+air);
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
        for (Airlines air : Airlines.values())
        if(air.ordinal()+1==ch1)
        {this.name = air;
            testres = true;}
            if(!testres)
            throw new UnexpectedAbortionException();
      this.id = new ID();
      this.id.setAll(name);
      this.p = ar;
      this.at = d.getTime();
      this.day = d.getDay();
      this.date = d.getDate();
}
public CommPlane(char ar,String st1,int l)
  {  int ch1;
      DateInfo d = new DateInfo();
      System.out.println("Choose Airlines -");
      int ord = 0;
      for(Airlines air : Airlines.values())
      {
          ord = air.ordinal()+1;
          System.out.println(ord+") "+air);
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
        for (Airlines air : Airlines.values())
        if(air.ordinal()+1==ch1)
        {this.name = air;
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
public CommPlane(char ar,String st1)
  {  int ch1;
      DateInfo d = new DateInfo();
      System.out.println("Choose Airlines -");
      int ord = 0;
      for(Airlines air : Airlines.values())
      {
          ord = air.ordinal()+1;
          System.out.println(ord+") "+air);
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
        for (Airlines air : Airlines.values())
        if(air.ordinal()+1==ch1)
        {this.name = air;
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
    s1="CommPlane I.D. = "+this.id;
    s2="Airlines = "+this.name;
    s3="CommPlane Port No. = "+this.p;
    s4="CommPlane Arrival Time = "+this.at;
    s5="CommPlane Departure Time = ";
    if (this.dt==null)
    s6="Not Departed";
    else
    s6 =this.dt;
    return (s+"\n"+s0+"\n"+s1+"\n"+s2+"\n"+s3+"\n"+s4+"\n"+s5+s6);
}
public void depart()
{
    this.dt=depart(this.dt);
   
}
}