import java.util.*;
public class HeliPad implements PlaceHolder
{
    private Heli[] pl;
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
public HeliPad (char s)
{  do{
    try{
    this.sl=s;
    System.out.println("Enter Capacity");
    Scanner in = new Scanner (System.in);
    this.c = in.nextInt();
    pl = new Heli [this.c];
    break;
}
catch(InputMismatchException e)
{
    System.err.println("Wrong Data Type Inputed ; Enter an Integer");
}
}while(true);
}
public Heli add(int l)
{Heli p00=null;
 int res = index(pl);
    try
    {
        if (res ==-1)
    throw new MaxLimitReachedException();
    int i = res;
       p00=pl[i]= Heli.addNew (l,sl);
    }
    catch(MaxLimitReachedException e)
    {System.out.println(e);p00=null;}
return p00;
}
public Heli add(String s,int l)
{Heli p00=null;
 int res = index(pl);
    try
    {
        if (res ==-1)
    throw new MaxLimitReachedException();
    int i = res;
       p00=pl[i]= Heli.addNew (s,l,sl);
    }
    catch(MaxLimitReachedException e)
    {System.out.println(e);p00=null;}
return p00;
}
public Heli add()
{Heli p00=null;
 int res = index(pl);
    try
    {
        if (res ==-1)
    throw new MaxLimitReachedException();
    int i = res;
       p00=pl[i]= Heli.addNew (sl);
    }
    catch(MaxLimitReachedException e)
    {System.out.println(e);p00=null;}
return p00;
}
public Heli add(String s)
{Heli p00=null;
 int res = index(pl);
    try
    {
        if (res ==-1)
    throw new MaxLimitReachedException();
    int i = res;
       p00=pl[i]= Heli.addNew (s,sl);
    }
    catch(MaxLimitReachedException e)
    {System.out.println(e);p00=null;}
return p00;
}
public void empty(String xid)
{  Heli ref=null;
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
    System.out.println("Helicopter "+ref.getID()+" Departed");
}
public boolean check(Heli z)
{
    for( Heli x : pl)
    {
        if (x==z)
        return true;
    }
    return false;
}
private int index(Heli[] x)
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
{ String s = "HeliPad No. = "+this.sl+"\n"+"HeliPad Capacity = "+this.c+"\n"+"Current HeliPad Status -"+"\n";
    int ln = pl.length;
    for (int in =0;in<ln;in++)
   {   
       
       if (pl[in]!=null)
    s +="Section "+(in+1)+" = Heli "+pl[in].getID()+" ["+pl[in].getinfo()+"]"+"\n";
    else
    s +="Section "+(in+1)+" = <Empty>"+"\n";}
    return s;
}
public void display()
{ System.out.println(this);}
}