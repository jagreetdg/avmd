import java.util.*;
import java.io.*;
public abstract class Airport_Manager
{
    private static PrintWriter outStrm = new PrintWriter(System.out,true);
    private static PrintWriter errStrm = new PrintWriter(System.err,true);
    public  static ArrayList<Plane> a;
    public  static ArrayList<Port> b;
    public  static ArrayList <Heli> a1;
    public  static ArrayList <HeliPad> b1;
    public  static ArrayList <User> u;
    public  static ArrayList<Record> rec = new ArrayList<Record>();
    public  static Record currRec;
    DateInfo dt = new DateInfo();
    public long c;
    public String dateS = dt.getDate();
    public static void refresh()
    {
        if(currRec!=null)
        {
            updateAll();
            rec.add(currRec);
            }
       currRec = new Record(new DateInfo().getDate());
        a = new ArrayList<Plane>();
        b = new ArrayList<Port>();
        a1 = new ArrayList<Heli>();
        b1 = new ArrayList<HeliPad>();
        u = new ArrayList<User>();
    }
    public static void updateAll(){
    updatePlane();
    updateHeli();
    updateUser();
    }
    public static boolean PlaneArrival ()
    {  Scanner in = new Scanner (System.in);
        outStrm.println("Enter Port No.");
        char z = in.nextLine().charAt(0);
        boolean flag0 = false;
        if(!Utilities.Duplicate.checkp(z,b))
        {errStrm.println("Port Not Yet Initiallized ; Initiallize Port First");
         return false;}
        else
        {
        do{try{
            boolean fl2 = false;
            for (Port x:b)
            {  
                if (x.getSl()==z)
                { String s88="";
                    do {try{
                        if (!x.isNext())
                        fl2=true;
                        break;}
                        catch (ArrayIndexOutOfBoundsException e2)
                        {   errStrm.println ("Maximum Capacity To Hold Planes Exceeded");
                            errStrm.println ("Cannot Arrive On Current Port");
                      do{
                          outStrm.println("TRY AGAIN ? (Y/N)");
                          Scanner sc1 = new Scanner (System.in);
                          char cr = sc1.nextLine().charAt(0);
                          switch(cr){
                              case 'N' :
                              case 'n' : return false;
                              case 'Y' :
                              case 'y' : return PlaneArrival();
                              default : outStrm.println ("Wrong Input ; Press Y or N");
                            }
                        }while(true);}
                   
                }while (true);
                     Plane m;
                     if (fl2)
                     m = null;
                     else
                     do{
                     try{
                     m = planeOpt(x);
                     break;
                    }
                    catch(IDDuplicateException e2)
                    {
                        errStrm.println(e2);
                        errStrm.println("Try Again");
                    }
                }while(true);
                        
                    if (m!=null)
                    {flag0=true;
                     outStrm.println("Plane arrived");
                     a.addAll(Arrays.asList(m));
                     break;
                    }
                    else
                    { outStrm.println ("Cannot Arrive On Current Port");
                      do{
                          outStrm.println("TRY AGAIN ? (Y/N)");
                          Scanner sc1 = new Scanner (System.in);
                          char cr = sc1.nextLine().charAt(0);
                          switch(cr){
                              case 'N' :
                              case 'n' : return false;
                              case 'Y' :
                              case 'y' : return PlaneArrival();
                              default : outStrm.println ("Wrong Input ; Press Y or N");
                            }
                        }while(true);
                    }
                }
                }
                return flag0;
                 }
                catch (InputMismatchException e)
                { errStrm.println("Wrong Data Type Inputted");}
                catch (ArrayIndexOutOfBoundsException e1)
                { errStrm.println("Array Limit Reached");}
            }while(true);
        }
    }
    
 public static void departP (char j)
 { boolean flag1 = false;
     for (Port l : b)
     {
         if (l.getSl() == j)
         {
             outStrm.println ("Enter Plane ID");
             Scanner sc = new Scanner (System.in);
             String pid = sc.nextLine();
             l.empty (pid);
             flag1 = true;
            }
        }
        if (!flag1)
        outStrm.println ("Port Not Found");
        else
        outStrm.println ("Search For Port Succesful");
    }
   public static void findP (String eid)
    { 
        for (Plane p7:a)
        {
            if (p7.getID().equals(eid))
            {
                outStrm.println(p7);
                return;
            }
        }
        
    }
   public static void pStatus(Port px)
   {outStrm.println(px);}
   public static void displayPlane(ArrayList<Plane> pa)
   {int i =0;
       for (Plane dp : pa)
       { i++;
           outStrm.println("Plane No. = "+i);
           outStrm.println(dp);
        }
    }
   public static void updatePlane ()
    {
        currRec.addRecPlane (a);
        currRec.addRecPort (b);
    }
   public static void replaceP(String aid)
   {
       boolean flag3=false;
       for (Plane p8:a)
       {  
           if (p8.getID().equals(aid))
            { outStrm.println("Plane Found");
              outStrm.println("Enter new Plane ID");
              Scanner sc3 = new Scanner (System.in);
              String s1 = sc3.nextLine();
              char s2 = p8.getp();
              p8 = Plane.addNew (s1,s2);
              flag3=true;
            }
        }
            if (flag3)
            outStrm.println ("Existing Plane Details Edited");
            else
            outStrm.println ("Plane Not Found");
        }
    public static void createPort(char ref1)
    {            
                 outStrm.println("Creating New Port");
                 Port n = new Port (ref1);
                 b.addAll(Arrays.asList(n));
                 outStrm.println("Port Created");
     }
    
    public static boolean HeliArrival ()
    {  Scanner in = new Scanner (System.in);
        outStrm.println("Enter HeliPad No.");
        char z = in.nextLine().charAt(0);
        boolean mflag = false;
        boolean flag0 = false;
        if(!Utilities.Duplicate.checkp(z,b1))
        {errStrm.println("HeliPad Not Yet Initiallized ; Initiallize HeliPad First");
         return false;}
        else
        {
        do{try{
            boolean fl2 = false;
            for (HeliPad x:b1)
            {  
                if (x.getSl()==z)
                { String s88="";
                    do {try{
                        if (!x.isNext())
                        fl2=true;
                        break;}
                        catch (ArrayIndexOutOfBoundsException e2)
                        {   errStrm.println ("Maximum Capacity To Hold Helicopters Exceeded");
                            errStrm.println ("Cannot Arrive On Current HeliPad");
                      do{
                          outStrm.println("TRY AGAIN ? (Y/N)");
                          Scanner sc1 = new Scanner (System.in);
                          char cr = sc1.nextLine().charAt(0);
                          switch(cr){
                              case 'N' :
                              case 'n' : return false;
                              case 'Y' :
                              case 'y' : return HeliArrival();
                              default : outStrm.println ("Wrong Input ; Press Y or N");
                            }
                        }while(true);}
                   
                }while (true);
                     Heli m;
                     if (fl2)
                     m = null;
                     else
                     do{
                     try{
                     m = heliOpt(x);
                     break;
                    }
                    catch(IDDuplicateException e2)
                    {
                        errStrm.println(e2);
                        errStrm.println("Try Again");
                    }
                }while(true);
                        
                    if (m!=null)
                    {flag0=true;
                     outStrm.println("Heli arrived");
                     a1.addAll(Arrays.asList(m));
                     break;
                    }
                    else
                    { outStrm.println ("Cannot Arrive On Current HeliPad");
                      do{
                          outStrm.println("TRY AGAIN ? (Y/N)");
                          Scanner sc1 = new Scanner (System.in);
                          char cr = sc1.nextLine().charAt(0);
                          switch(cr){
                              case 'N' :
                              case 'n' : return false;
                              case 'Y' :
                              case 'y' : return HeliArrival();
                              default : outStrm.println ("Wrong Input ; Press Y or N");
                            }
                        }while(true);
                    }
                }
                }
               return flag0;
                 }
                catch (InputMismatchException e)
                { errStrm.println("Wrong Data Type Inputted");}
                catch (ArrayIndexOutOfBoundsException e1)
                { errStrm.println("Array Limit Reached");}
            }while(true);
        }
    }
  public static void departH (char j)
 { boolean flag1 = false;
     for (HeliPad l : b1)
     {
         if (l.getSl() == j)
         {
             outStrm.println ("Enter Heli ID");
             Scanner sc = new Scanner (System.in);
             String pid = sc.nextLine();
             l.empty (pid);
             flag1 = true;
            }
        }
        if (!flag1)
        outStrm.println ("HeliPad Not Found");
        else
        outStrm.println ("Search For HeliPad Succesful");
    }
   public static void findH (String eid)
    { 
        for (Heli p7:a1)
        {
            if (p7.getID().equals(eid))
            {
                outStrm.println(p7);
                return;
            }
        }
        
    }
   public static void hStatus(HeliPad px)
   {outStrm.println(px);}
   public static void displayHeli(ArrayList<Heli> pa)
   {int i =0;
       for (Heli dp : pa)
       { i++;
           outStrm.println("Heli No. = "+i);
           outStrm.println(dp);
        }
    }
   public static void updateHeli ()
    {
        currRec.addRecHeli (a1);
        currRec.addRecHeliPad (b1);
    }
   public static void replaceH(String aid)
   {
       boolean flag3=false;
       for (Heli p8:a1)
       {  
           if (p8.getID().equals(aid))
            { outStrm.println("Heli Found");
              outStrm.println("Enter new Heli ID");
              Scanner sc3 = new Scanner (System.in);
              String s1 = sc3.nextLine();
              char s2 = p8.getp();
              p8 = Heli.addNew (s1,s2);
              flag3=true;
            }
        }
            if (flag3)
            outStrm.println ("Existing Heli Details Edited");
            else
            outStrm.println ("Heli Not Found");
        }
    public static void createHeliPad(char ref1)
    {            
                 outStrm.println("Creating New HeliPad");
                 HeliPad n = new HeliPad (ref1);
                 b1.addAll(Arrays.asList(n));
                 outStrm.println("HeliPad Created");
    }
    
    public static Plane planeOpt(Port xp) throws IDDuplicateException
    {
        outStrm.println("Initiallizing Plane Arrival");
        Plane refp = null;
        outStrm.println("ID Options");
        outStrm.println("1) Generate Default ID");
        outStrm.println("2) Specify Prefix");
        outStrm.println("3) Specify Suffix");
        outStrm.println("4) Specify Prefix and Suffix");
        Scanner inp = new Scanner (System.in);
        int ch;
        do{try{
            Scanner inp1 = new Scanner (System.in);
            ch = inp1.nextInt();
            if(!(ch>=1)&&(ch<=4))
            throw new RangeMismatchException();
            break;
        }
        catch(InputMismatchException e1)
        {errStrm.println("Wrong Data Type ; Enter an Integer \nTry Again");}
        catch(RangeMismatchException e2)
        {errStrm.println(e2+" ; Enter A No. between 1 & 4\nTry Again");}
    }while(true);
    switch(ch)
    {
        case 1 : refp = xp.add();
                 if(Utilities.Duplicate.checkid(refp.getID(),a))
                 throw new IDDuplicateException();
                 return refp;
        case 2 : Scanner inp3 = new Scanner(System.in);
                 outStrm.println("Enter Prefix (String)");
                 String pr = inp3.nextLine().substring(0,2).toUpperCase();
                 refp = xp.add(pr);
                 if(Utilities.Duplicate.checkid(refp.getID(),a))
                 throw new IDDuplicateException();
                 return refp;
        case 3 : 
                int suf;
                 do{try{
                 Scanner inp4 = new Scanner(System.in);
                 outStrm.println("Enter Suffix (Integer)");
                 suf = inp4.nextInt();
                 if ((suf>9999)||(suf<0))
                 throw new RangeMismatchException();
                 break;
                }
                catch(InputMismatchException e1)
                {errStrm.println("Wrong Data Type ; Enter an Integer \nTry Again");}
                catch(RangeMismatchException e2)
                {errStrm.println(e2+"Enter A No. Between 0 and 9999\nTry Again");}
                }while(true);
                 refp = xp.add(suf);
                 if(Utilities.Duplicate.checkid(refp.getID(),a))
                 throw new IDDuplicateException();
                 return refp;
        case 4 : Scanner inp5 = new Scanner(System.in);
                 outStrm.println("Enter Prefix (String)");
                 int suf1;
                 String pr1 = inp5.nextLine().substring(0,2).toUpperCase();
                 do{try{
                 Scanner inp6 = new Scanner(System.in);
                 outStrm.println("Enter Suffix (Integer)");
                 suf1 = inp6.nextInt();
                 if ((suf1>9999)||(suf1<0))
                 throw new RangeMismatchException();
                 break;
                }
                catch(InputMismatchException e1)
                {errStrm.println("Wrong Data Type ; Enter an Integer \nTry Again");}
                catch(RangeMismatchException e2)
                {errStrm.println(e2+"Enter A No. Between 0 and 9999\nTry Again");}
                }while(true);
                refp = xp.add(pr1,suf1);
                 if(Utilities.Duplicate.checkid(refp.getID(),a))
                 throw new IDDuplicateException();
                 return refp;
       default : throw new RuntimeException();
    }
}
public static Heli heliOpt(HeliPad xp) throws IDDuplicateException
    {
        outStrm.println("Initiallizing Helicopter Arrival");
        Heli refp = null;
        outStrm.println("ID Options");
        outStrm.println("1) Generate Default ID");
        outStrm.println("2) Specify Prefix");
        outStrm.println("3) Specify Suffix");
        outStrm.println("4) Specify Prefix and Suffix");
        Scanner inp = new Scanner (System.in);
        int ch;
        do{try{
            Scanner inp1 = new Scanner (System.in);
            ch = inp1.nextInt();
            if(!(ch>=1)&&(ch<=4))
            throw new RangeMismatchException();
            break;
        }
        catch(InputMismatchException e1)
        {errStrm.println("Wrong Data Type ; Enter an Integer \nTry Again");}
        catch(RangeMismatchException e2)
        {errStrm.println(e2+" ; Enter A No. between 1 & 4\nTry Again");}
    }while(true);
    switch(ch)
    {
        case 1 : refp = xp.add();
                 if(Utilities.Duplicate.checkid(refp.getID(),a1))
                 throw new IDDuplicateException();
                 return refp;
        case 2 : Scanner inp3 = new Scanner(System.in);
                 outStrm.println("Enter Prefix (String)");
                 String pr = inp3.nextLine().substring(0,2).toUpperCase();
                 refp = xp.add(pr);
                 if(Utilities.Duplicate.checkid(refp.getID(),a1))
                 throw new IDDuplicateException();
                 return refp;
        case 3 : 
                int suf;
                 do{try{
                 Scanner inp4 = new Scanner(System.in);
                 outStrm.println("Enter Suffix (Integer)");
                 suf = inp4.nextInt();
                 if ((suf>9999)||(suf<0))
                 throw new RangeMismatchException();
                 break;
                }
                catch(InputMismatchException e1)
                {errStrm.println("Wrong Data Type ; Enter an Integer \nTry Again");}
                catch(RangeMismatchException e2)
                {errStrm.println(e2+"Enter A No. Between 0 and 9999\nTry Again");}
                }while(true);
                 refp = xp.add(suf);
                 if(Utilities.Duplicate.checkid(refp.getID(),a1))
                 throw new IDDuplicateException();
                 return refp;
        case 4 : Scanner inp5 = new Scanner(System.in);
                 outStrm.println("Enter Prefix (String)");
                 int suf1;
                 String pr1 = inp5.nextLine().substring(0,2).toUpperCase();
                 do{try{
                 Scanner inp6 = new Scanner(System.in);
                 outStrm.println("Enter Suffix (Integer)");
                 suf1 = inp6.nextInt();
                 if ((suf1>9999)||(suf1<0))
                 throw new RangeMismatchException();
                 break;
                }
                catch(InputMismatchException e1)
                {errStrm.println("Wrong Data Type ; Enter an Integer \nTry Again");}
                catch(RangeMismatchException e2)
                {errStrm.println(e2+"Enter A No. Between 0 and 9999\nTry Again");}
                }while(true);
                refp = xp.add(pr1,suf1);
                 if(Utilities.Duplicate.checkid(refp.getID(),a1))
                 throw new IDDuplicateException();
                 return refp;
       default : throw new RuntimeException();
    }
    }
public static void addUser(User us)
  {
        u.add(us);
   }
public static void updateUser()
{
    currRec.addRecUser(u);
}
public static void displayPort(ArrayList<Port> pa)
   {int i =0;
       for (Port dp : pa)
       { i++;
           outStrm.println("Port No. = "+dp.getSl());
           outStrm.println("Port Capacity = "+dp.getC());
        }
    }
public static void displayHeliPad(ArrayList<HeliPad> pa)
   {int i =0;
       for (HeliPad dp : pa)
       { i++;
           outStrm.println("HeliPad No. = "+dp.getSl());
           outStrm.println("HeliPad Capacity = "+dp.getC());
        }
    }
public static void displayUser(ArrayList<User> pa)
   {int i =0;
       for (User dp : pa)
       { i++;
           outStrm.println("User Ticket No. = "+dp.tic.getNo());
           outStrm.println("Airways ID = "+dp.tic.getID());
        }
    }
}
