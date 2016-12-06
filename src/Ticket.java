public abstract class Ticket
{
   public static int c = 1;
   public abstract String[] getName();
   public abstract double getPrice();
   public abstract double getRate();
   public abstract String getID();
   public abstract int getPassNo();
   public abstract String getNo();
   public abstract String toString();
   public void display()
   {System.out.println(this);}
}
