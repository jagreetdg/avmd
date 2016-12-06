import java.util.*;
import java.io.*;
public class ID
{   public static ArrayList<ID> arr = new ArrayList<ID>();
    public static int sl=1;
    public boolean status = false;
    private Utilities.DataTypes.LimitedString
    m = new Utilities.DataTypes.LimitedString(6),
    pre = new Utilities.DataTypes.LimitedString(2),
    suff = new Utilities.DataTypes.LimitedString(4);
    public ID(){}
    public ID(String id)
    {   id = id.substring(0,6).toUpperCase();
        try{
        this.m.addTo(id);
        this.pre.addTo(id.substring(0,2));
        this.suff.addTo(id.substring(2));
        arr.add(this);
        this.status = true;
    }
    catch(Exception e)
    {
        System.err.println(e);
        System.err.println(new UnexpectedAbortionException());
        System.exit(1);
    }
    }
    public static Airlines checkAir(String air)
    {
        air=air.substring(0,2);
        for(Airlines ar : Airlines.values())
        if(ar.toString().substring(0,2).toUpperCase().equals(air))
        return ar;
        return null;
    }
    public static Troops checkTrp(String trp)
    {
        trp=trp.substring(0,2);
        for(Troops tr : Troops.values())
        if(tr.toString().substring(0,2).toUpperCase().equals(trp))
        return tr;
        return null;
    }
    public boolean setAll (Enum en,int l)
    {  try{
        this.setPre(en);
        this.setSuff(l);
        this.calc();
        this.status = true;
        arr.add(this);
        return true;
          }
          catch(Exception e)
          {
              System.err.println(e);
              return false;
          }
    }
    public boolean setAll (Enum en)
    {  try{
        this.setPre(en);
        this.setSuff();
        this.calc();
        this.status = true;
        arr.add(this);
        return true;
          }
          catch(Exception e)
          {
              System.err.println(e);
              return false;
          }
    }
    public boolean setAll (String st,int l)
    {  try{
        this.setPre(st);
        this.setSuff(l);
        this.calc();
        this.status = true;
        arr.add(this);
        return true;
          }
          catch(Exception e)
          {
              System.err.println(e);
              return false;
          }
    }
    public boolean setAll (String st)
    {  try{
        this.setPre(st);
        this.setSuff();
        this.calc();
        this.status = true;
        arr.add(this);
        return true;
          }
          catch(Exception e)
          {
              System.err.println(e);
              return false;
          }
    }
    private static boolean check()
    {return (sl<=9999);}
    private static boolean check(int l)
    {return (l<=9999);}
    private boolean checkID(Utilities.DataTypes.LimitedString sb)
    { for(ID id : arr)
        if (id.suff.equals(sb))
        return true;
        return false;
        
    }
    private boolean checkID(String sbe)
    {   Utilities.DataTypes.LimitedString sb = new Utilities.DataTypes.LimitedString(sbe);
        for(ID id : arr)
        if (id.suff.equals(sb))
        return true;
        return false;
        
    }
    private boolean checkID(ID ref1)
    { for(ID id : arr)
        if (id.suff.equals(ref1.suff))
        return true;
        return false;
        
    }
    private void setPre(Enum w)
    {   String s = w.toString().toUpperCase().substring(0,2);
        this.pre.addTo(s);
    }
    private void setPre(String s)
    {   if(s.length()==0)
        s = "XX";
        if(s.length()==1)
        s = "X".concat(s);
        this.pre.addTo(new Utilities.DataTypes.LimitedString (s.substring(0,2).toUpperCase()));
    }
    private void setSuff(int l)throws IDDuplicateException,MaxLimitReachedException,AlreadyInitiallizedException
    {
        if(checkID(Integer.toString(l)))
        throw new IDDuplicateException();
        String ls = Integer.toString(l);
        String r="";
        if(!check(l))
        throw new MaxLimitReachedException();
        for(int i = 1;i<=(4-Utilities.NOCalc.getNDigits(l));i++)
        r = r.concat("0");
        if(r!=null)
        ls = r.concat(ls);
        this.suff.addTo(ls);
        return;
    }
    private void setSuff()throws IDDuplicateException,MaxLimitReachedException,AlreadyInitiallizedException
    {
       String ls = Integer.toString(sl);
        String r="";
        if(!check(sl))
        throw new MaxLimitReachedException();
        for(int i = 1;i<=(4-Utilities.NOCalc.getNDigits(sl));i++)
        r = r.concat("0");
        if(r!=null)
        ls = r.concat(ls);
        this.suff.addTo(ls);
        sl++;
        return;
    }
    private boolean calc()
    {
        try{
            this.m.addTo(pre);
            this.m.addTo(suff);
            return true;
        }
        catch(Exception e)
        {System.err.println(e);
        return false;}
        
    }
    public int getSerialNo()
    {
        if(!status)
        {
            System.err.println("ID not Initiallized");
            return 0;
        }
        return Integer.valueOf(suff.toString());
    }
    public Airlines getAirlines()
    {
        if(!status)
        {
            System.err.println("ID not Initiallized");
            return null;
        }
        for(Airlines a:Airlines.values())
        if(this.pre.equals(a.toString().substring(0,2).toUpperCase()))
        return a;
        System.err.println("Not a Commercial Plane");
        return null;
    }
    public Troops getTroops()
    {
        if(!status)
        {
            System.err.println("ID not Initiallized");
            return null;
        }
        for(Troops a:Troops.values())
        if(this.pre.equals(a.toString().substring(0,2).toUpperCase()))
        return a;
        System.err.println("Not a Heli Carrier");
        return null;
    }
    public String getPrefix()
    {    if(!status)
        {
            System.err.println("ID not Initiallized");
            return null;
        }
        return this.pre.toString();
    }
    public String getSufffix()
    {    if(!status)
        {
            System.err.println("ID not Initiallized");
            return null;
        }
        return this.suff.toString();
    }
    public String getIDMain()
    {
        if(!status)
        {
            System.err.println("ID not Initiallized");
            return null;
        }
        return this.m.toString();
    }
    public String toString()
    {    if(!status)
        {
            System.err.println("ID not Initiallized");
            return null;
        }
        return this.m.toString();
    }
    public void display()
    {
        if(!status)
        {
            System.err.println("ID not Initiallized");
            return;
        }
        System.out.println(this);
    }
}
    