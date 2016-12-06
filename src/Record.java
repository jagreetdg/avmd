import java.util.*;

public class Record
{   public String dt;
    public int sl;
    private static int c = 0;
    public ArrayList <Plane> x = new ArrayList<Plane>();
    public ArrayList <Port> y = new ArrayList<Port>();
    public ArrayList <Heli> x2 = new ArrayList<Heli>();
    public ArrayList <HeliPad> y2 = new ArrayList<HeliPad>();
    public ArrayList <User> u = new ArrayList<User>();
    public Record (String d)
    {this.dt = d;
     this.sl = ++c;}
    public int getSl()
    {return this.sl;}
    public int getC()
    {return this.c;}
    public void addRecPlane(ArrayList <Plane> x1)
    {this.x=x1;}
    public void addRecPort(ArrayList <Port> y1)
    {this.y=y1;}
    public void addRecHeli(ArrayList <Heli> x11)
    {this.x2=x11;}
    public void addRecHeliPad(ArrayList <HeliPad> y11)
    {this.y2=y11;}
    public void addRecUser(ArrayList <User> u12)
    {this.u=u12;}
    public String getDate()
    {return this.dt;}
    public ArrayList <Plane> PlaneWise()
    {return this.x;}
    public ArrayList <Port> PortWise()
    {return this.y;}
    public ArrayList <Heli> HeliWise()
    {return x2;}
    public ArrayList <HeliPad> HeliPadWise()
    {return y2;}
    public ArrayList <User> UserWise()
    {return u;}
    public String toString()
    {String ss7="";
        try{
        if( x.size()==0|| y.size()==0|| x2.size()==0|| y2.size()==0)
        throw new NullPointerException();
        String s33= ("Record No. = "+this.sl+"\n"+"Date = "+this.dt+"\n"+"No. Of Planes = "+this.x.size()+"\n"+"No. Of Ports = "+this.y.size()
        +"\n"+"No. Of Helicopters = "+this.x2.size()+"\n"+"No. Of HeliPads = "+this.y2.size()+"\n"+"No. Of Users = "+this.u.size());
        ss7=s33;}
        catch (NullPointerException e){ss7="Record Not Yet Initiallized";}
        finally{
        return ss7;
        }
    }
    public void display()
    {  if (this.toString().equals("Record Not Yet Initiallized"))
        {System.err.println(this);
            return;}
        System.out.println(this);}
}