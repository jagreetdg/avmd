import java.util.*;
public abstract class Heli implements Airways
{  
abstract  public String getinfo();
abstract  public String getID();
abstract  public char getp();
abstract  public String getat();
abstract  public String getdt();
abstract  public String getday();
abstract  public String getdate();
public void display()
{
System.out.println(this);
}

public static Heli addNew(int l,char b)
{ System.out.println("Enter for arrival - \n1)Heli Carrier\n2)Commercial Helicopter\nEnter 1 or 2 ?");
    do{try{
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    if(!(n==1||n==2))
    throw new RangeMismatchException();
    switch (n)
    { case 1 : return new HeliCarrier(l,b);
      case 2 : return new CommHeli(l,b);
      default : System.out.println("Error");
    }
}
catch(InputMismatchException e)
{System.err.println("Wrong Type Entered;Enter a Digit");}
catch(RangeMismatchException e1)
{System.err.println("Wrong Value Entered;Enter a value between 1 & 2");}
}while(true);
}
public static Heli addNew(char b)
{ System.out.println("Enter for arrival - \n1)Heli Carrier\n2)Commercial Helicopter\nEnter 1 or 2 ?");
    do{try{
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    if(!(n==1||n==2))
    throw new RangeMismatchException();
    switch (n)
    { case 1 : return new HeliCarrier(b);
      case 2 : return new CommHeli(b);
      default : System.out.println("Error");
    }
}
catch(InputMismatchException e)
{System.err.println("Wrong Type Entered;Enter a Digit");}
catch(RangeMismatchException e1)
{System.err.println("Wrong Value Entered;Enter a value between 1 & 2");}
}while(true);
}
public static Heli addNew(String str,int l,char b)
{ System.out.println("Enter for arrival - \n1)Heli Carrier\n2)Commercial Helicopter\nEnter 1 or 2 ?");
    do{try{
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    if(!(n==1||n==2))
    throw new RangeMismatchException();
    switch (n)
    { case 1 : return new HeliCarrier(str,l,b);
      case 2 : return new CommHeli(str,l,b);
      default : System.out.println("Error");
    }
}
catch(InputMismatchException e)
{System.err.println("Wrong Type Entered;Enter a Digit");}
catch(RangeMismatchException e1)
{System.err.println("Wrong Value Entered;Enter a value between 1 & 2");}
}while(true);
}
public static Heli addNew(String str,char b)
{ System.out.println("Enter for arrival - \n1)Heli Carrier\n2)Commercial Helicopter\nEnter 1 or 2 ?");
    do{try{
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    if(!(n==1||n==2))
    throw new RangeMismatchException();
    switch (n)
    { case 1 : return new HeliCarrier(str,b);
      case 2 : return new CommHeli(str,b);
      default : System.out.println("Error");
    }
}
catch(InputMismatchException e)
{System.err.println("Wrong Type Entered;Enter a Digit");}
catch(RangeMismatchException e1)
{System.err.println("Wrong Value Entered;Enter a value between 1 & 2");}
}while(true);
}
public String depart(String s)
{
DateInfo d2 = new DateInfo();
s = d2.getTime();
return s;
}


}
