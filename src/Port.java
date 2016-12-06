
import java.util.*;

public class Port implements PlaceHolder
{
    private Plane[] pl;
    private char sl;
    private int c;
    public char getSl(){return sl;}
    public int getC() {return c;}
    public boolean isNext()
{ int i = 0;
    for (;i<=pl.length;i++)
     if (pl[i] == null)
        return true;
    return false;
    
}
public Port (char s)
{  do{
    try{
    this.sl=s;
    System.out.println("Enter Capacity");
    Scanner in = new Scanner (System.in);
    this.c = in.nextInt();
    pl = new Plane [this.c];
    break;
}
catch(InputMismatchException e)
{
    System.err.println("Wrong Data Type Inputed ; Enter an Integer");
}
}while(true);
}
public Plane add(int l)
{
    Plane p00;
 int res = index(pl);
  try
    {
        if (res ==-1)
    throw new MaxLimitReachedException();
    int i = res;
       p00=pl[i]= Plane.addNew (l,sl);
    }
    catch(MaxLimitReachedException e)
    {System.out.println(e);p00=null;}
return p00;
}
public Plane add(String s,int l)
{
    Plane p00;
 int res = index(pl);
  try
    {
        if (res ==-1)
    throw new MaxLimitReachedException();
    int i = res;
       p00=pl[i]= Plane.addNew (s,l,sl);
    }
    catch(MaxLimitReachedException e)
    {System.out.println(e);p00=null;}
return p00;
}
public Plane add()
{
    Plane p00;
 int res = index(pl);
  try
    {
        if (res ==-1)
    throw new MaxLimitReachedException();
    int i = res;
       p00=pl[i]= Plane.addNew (sl);
    }
    catch(MaxLimitReachedException e)
    {System.out.println(e);p00=null;}
return p00;
}
public Plane add(String s)
{
    Plane p00;
 int res = index(pl);
  try
    {
        if (res ==-1)
    throw new MaxLimitReachedException();
    int i = res;
       p00=pl[i]= Plane.addNew (s,sl);
    }
    catch(MaxLimitReachedException e)
    {System.out.println(e);p00=null;}
return p00;
}
public void empty(String xid)
{  Plane ref=null;
    boolean flag = false;
    for (int j = 0;j<c;j++)
    {  try{
        if (pl[j].getID().equals(xid))
        {   ref = pl[j];
            pl[j].depart(pl[j].getdt());
            flag = true;
            pl[j] = null;
        }
    }
        catch(Exception e)
        {System.err.println("Error");
        e.printStackTrace();}
    }
    if (!flag)
    System.out.println("I.D. not found");
    else
    System.out.println("Plane "+ref.getID()+" Departed");
}
public boolean check(Plane z)
{
    for( Plane x : pl)
    {
        if (x==z)
        return true;
    }
    return false;
}
private int index(Plane[] x)
{
    int len = x.length;
    for (int i=0;i<len;i++)
    {
        if (x[i] == null)
        return i;
    }
    return -1;
}
public String toString ()
{ String s = "Port No. = "+this.sl+"\n"+"Port Capacity = "+this.c+"\n"+"Current Port Status -"+"\n";
    int ln = pl.length;
    for (int in =0;in<ln;in++)
   { if (pl[in]!=null)
    s +="Terminal "+(in+1)+" = Plane "+pl[in].getID()+" ["+pl[in].getinfo()+"]"+"\n";
    else
    s +="Terminal "+(in+1)+" = <Empty>"+"\n";}
    return s;
}
public void display()
{ System.out.println(this);}
}