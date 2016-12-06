import java.util.*;
public class CommHeli extends Heli implements Airways
{ private String info = "Commercial Helicopter";
  private String des;
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
  public String getDes(){return this.des;}
  public CommHeli(int l,char ar)
  {  int ch1;
      DateInfo d = new DateInfo();
      System.out.println("Enter Destination");
      Scanner in = new Scanner (System.in);
      this.des = in.nextLine();
      this.id = new ID();
      this.id.setAll(this.des,l);
      this.p = ar;
      this.at = d.getTime();
      this.day = d.getDay();
      this.date = d.getDate();
  }
  public CommHeli(char ar)
  {  int ch1;
      DateInfo d = new DateInfo();
      System.out.println("Enter Destination");
      Scanner in = new Scanner (System.in);
      this.des = in.nextLine();
      this.id = new ID();
      this.id.setAll(this.des);
      this.p = ar;
      this.at = d.getTime();
      this.day = d.getDay();
      this.date = d.getDate();
  }
  public CommHeli(String str,int l,char ar)
  {  int ch1;
      DateInfo d = new DateInfo();
      System.out.println("Enter Destination");
      Scanner in = new Scanner (System.in);
      this.des = in.nextLine();
      this.id = new ID();
      this.id.setAll(str,l);
      this.p = ar;
      this.at = d.getTime();
      this.day = d.getDay();
      this.date = d.getDate();
  }
  public CommHeli(String str,char ar)
  {  int ch1;
      DateInfo d = new DateInfo();
      System.out.println("Enter Destination");
      Scanner in = new Scanner (System.in);
      this.des = in.nextLine();
      this.id = new ID();
      this.id.setAll(str);
      this.p = ar;
      this.at = d.getTime();
      this.day = d.getDay();
      this.date = d.getDate();
  }
  public String toString()
  { String s,s0,s1,s2,s3,s4,s5,s6;
    s= "Date = "+this.date;
    s0="Day = "+this.day;
    s1="CommHeli I.D. = "+this.id;
    s2="Destination = "+this.des;
    s3="HeliPad No. = "+this.p;
    s4="CommHeli Arrival Time = "+this.at;
    s5="CommHeli Departure Time = ";
    if (this.dt==null)
    s6="Not Departed";
    else
    s6 =this.dt;
    return (s+"\n"+s0+"\n"+s1+"\n"+s2+"\n"+s3+"\n"+s4+"\n"+s5+s6);
  }
}