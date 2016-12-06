import java.util.*;
public class Utilities
{  
    public static class DataTypes
    {
    public static class LimitedString
    {   String str="";
        int limit;
        public LimitedString(String s)
        {this.str = s;
         this.limit = s.length();}
        public LimitedString(int n)
        {this.limit=n;}
        private boolean checkLimit(String s)
        { String ref = this.str+s;
          return(ref.length()<=limit);
        }
        public boolean addTo(String ref)
        {if(checkLimit(ref))
            {
                this.str+=ref;
                return true;
            }
         else
         {
             this.str="";
             addTo(ref.substring(0,6));
             return false;
            }
        }
        public boolean addTo(LimitedString ref)
        {
            return addTo(ref.toString());
        }
        public String toString()
        { return str;}
    }
    }  
    public static class Duplicate
    {
    public static boolean checkid (String nid,ArrayList<? extends Airways> x)
    {
        for (Airways ab:x)
        {   String s = ab.getID();
            String t = nid;
            int i = ab.getID().hashCode();
            int j = nid.hashCode();
            if (i==j) return true;
        }
        return false;
    }
    public static boolean checkp (char nid,ArrayList<? extends PlaceHolder> x)
    {
        for (PlaceHolder ab:x)
        {   
            char s = ab.getSl();
            char t = nid;
            int i = (int)ab.getSl();
            int j = (int)nid;
            return (i==j);
        }
        return false;
    }
    public static boolean checkRec (Record r,ArrayList<Record> x)
    {
        for (Record ab:x)
        {if (ab.dt.equals(r.dt)) return true;
        }
        return false;
    }
    }
    public static class NOCalc
    {
        public static int getNDigits(int n)
        {
            int c=0;
            if(n==0) return 1;
            while(n>0)
            {   c++;
                n/=10;
            }
            return c;
        }
        public static int getNDigits(long n)
        {
            int c=0;
            if(n==0) return 1;
            while(n>0)
            {   c++;
                n/=10;
            }
            return c;
        }
        public static int getNDigits(short n)
        {
            int c=0;
            if(n==0) return 1;
            while(n>0)
            {   c++;
                n/=10;
            }
            return c;
        }
        public static int getNDigits(byte n)
        {
            int c=0;
            if(n==0) return 1;
            while(n>0)
            {   c++;
                n/=10;
            }
            return c;
        }
        public static int getNDigits(float no)
        {   long n = (long)no;
            int c=0;
            if(n==0) return 1;
            while(n>0)
            {   c++;
                n/=10;
            }
            return c;
        }
        public static int getNDigits(double no)
        {   long n = (long)no;
            int c=0;
            if(n==0) return 1;
            while(n>0)
            {   c++;
                n/=10;
            }
            return c;
        }
        
    }
}
