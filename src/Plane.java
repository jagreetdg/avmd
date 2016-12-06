import java.util.*;
public abstract class Plane implements Airways
{
abstract public String getinfo();
abstract public String getID();
abstract public char getp();
abstract public String getat();
abstract public String getdt();
abstract public String getday();
abstract public String getdate();
public static Plane addNew( int l,char b)
{ System.out.println("Enter for arrival - \n1)Commercial Plane\n2)Jet\nEnter 1 or 2 ?");
    do{try{
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    if(!(n==1||n==2))
    throw new RangeMismatchException();
    switch (n)
    { case 1 : return new CommPlane(b,l);
      case 2 : return new Jet(b,"JT");
      default : System.out.println("Error");
    }
}
catch(InputMismatchException e)
{System.err.println("Wrong Type Entered;Enter a Digit");}
catch(RangeMismatchException e1)
{System.err.println("Wrong Value Entered;Enter a value between 1 & 2");}
}while(true);
}
public static Plane addNew( char b)
{ System.out.println("Enter for arrival - \n1)Commercial Plane\n2)Jet\nEnter 1 or 2 ?");
    do{try{
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    if(!(n==1||n==2))
    throw new RangeMismatchException();
    switch (n)
    { case 1 : return new CommPlane(b);
      case 2 : return new Jet(b,"JT");
      default : System.out.println("Error");
    }
}
catch(InputMismatchException e)
{System.err.println("Wrong Type Entered;Enter a Digit");}
catch(RangeMismatchException e1)
{System.err.println("Wrong Value Entered;Enter a value between 1 & 2");}
}while(true);
}
public static Plane addNew(String str,int l,char b)
{ System.out.println("Enter for arrival - \n1)Commercial Plane\n2)Jet\nEnter 1 or 2 ?");
    do{try{
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    if(!(n==1||n==2))
    throw new RangeMismatchException();
    switch (n)
    { case 1 : return new CommPlane(b,str,l);
      case 2 : return new Jet(b,str,l);
      default : System.out.println("Error");
    }
}
catch(InputMismatchException e)
{System.err.println("Wrong Type Entered;Enter a Digit");}
catch(RangeMismatchException e1)
{System.err.println("Wrong Value Entered;Enter a value between 1 & 2");}
}while(true);
}
public static Plane addNew(String str,char b)
{ System.out.println("Enter for arrival - \n1)Commercial Plane\n2)Jet\nEnter 1 or 2 ?");
    do{try{
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    if(!(n==1||n==2))
    throw new RangeMismatchException();
    switch (n)
    { case 1 : return new CommPlane(b,str);
      case 2 : return new Jet(b,str);
      default : System.out.println("Error");
    }
}
catch(InputMismatchException e)
{System.err.println("Wrong Type Entered;Enter a Digit");}
catch(RangeMismatchException e1)
{System.err.println("Wrong Value Entered;Enter a value between 1 & 2");}
}while(true);
}
public void display()
{
System.out.println(this);
}
public String depart(String s)
{
DateInfo d2 = new DateInfo();
s = d2.getTime();
return s;
}


}