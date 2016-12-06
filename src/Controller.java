import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
public abstract class Controller
{
	private static TimeAnalyzer ta = new NanoTimeAnalyzer("MyAnalyzer");
	private static PrintWriter outStrm = new PrintWriter(System.out,true);
	private static PrintWriter errStrm = new PrintWriter(System.err,true);
	private static class util
	{
		private static void newUserFunc()
		{
			new User().main();
		}
		private static void setRate()
		{
			outStrm.println("Enter Ticket Type For Which Rate Is To Be Specified");
			outStrm.println("1) Commercial Plane");
			outStrm.println("2) Jet Plane");
			outStrm.println("3) Commercial Helicopter");
			outStrm.println("4) HeliCarrier");
			int ch;
			do{try{
				Scanner in = new Scanner (System.in);
				ch = in.nextInt();
				in.close();
				if(ch<1||ch>4)
					throw new RangeMismatchException();
				else
					break;
			}
			catch(InputMismatchException e1)
			{errStrm.println("Wrong Input ; Enter a Number");}
			catch(RangeMismatchException e2)
			{errStrm.println(e2+"\n Enter a No. between 1 and 4");}
			}while(true);
			switch(ch)
			{
			case 1 : CPTicket.setRate();return;
			case 2 : JPTicket.setRate();return;
			case 3 : CHTicket.setRate();return;
			case 4 : HCTicket.setRate();return;
			default : throw new UnexpectedAbortionException();
			}
		}
		private static void setCap()
		{
			outStrm.println("Setting Commercial Plane Capacity");
			CPTicket.setCap();
		}
		@SuppressWarnings("resource")
		private static void setCurrency()
		{
			outStrm.println("Enter Ticket Type For Which Currency Is To Be Specified");
			outStrm.println("1) Commercial Plane");
			outStrm.println("2) Jet Plane");
			outStrm.println("3) Commercial Helicopter");
			outStrm.println("4) HeliCarrier");
			int ch;
			do{try{
				Scanner in = new Scanner (System.in);
				ch = in.nextInt();
				in.close();
				if(ch<1||ch>4)
					throw new RangeMismatchException();
				else
					break;
			}
			catch(InputMismatchException e1)
			{errStrm.println("Wrong Input ; Enter a Number");}
			catch(RangeMismatchException e2)
			{errStrm.println(e2+"\n Enter a No. between 1 and 4");}
			}while(true);
			outStrm.println("Enter Currency Symbol");
			Scanner in2 = new Scanner (System.in);
			String curr = in2.nextLine();
			switch(ch)
			{
			case 1 : CPTicket.setCurrency(curr);return;
			case 2 : JPTicket.setCurrency(curr);return;
			case 3 : CHTicket.setCurrency(curr);return;
			case 4 : HCTicket.setCurrency(curr);return;
			default : throw new UnexpectedAbortionException();
			}
		}
		@SuppressWarnings("resource")
		private static boolean intro(String disp)
		{
			outStrm.println("You Have Opted For "+disp+"\nContinue ? (Press 0 to Exit)");
			if(new Scanner(System.in).nextLine().equals("0"))
			{
				errStrm.println("Exiting Current Function");
				return false;
			}
			outStrm.println("Performing Opted Function");
			return true;
		}
		@SuppressWarnings("resource")
		private static void exit(int exitCode)
		{
			char ch;
			do{
				outStrm.println("Do You Want To Exit ? (Y/N)");
				do{
					try{
						ch = new Scanner(System.in).nextLine().charAt(0);
						break;
					}
					catch(StringIndexOutOfBoundsException e)
					{errStrm.println("No String Entered ; Try Again");}
				}while(true);
				switch(ch){
				case 'y':
				case 'Y': outStrm.println("Saving Data");
				Airport_Manager.refresh();
				outStrm.println("Thank You For Using This System");
				System.out.println("Time Taken = "+ta.getElapsedTime(TimeUnit.SECONDS));
				System.exit(exitCode);
				case 'n':
				case 'N': outStrm.println("Returning To Current Task");
				return;
				default : errStrm.println("Wrong Choice ; Enter Either 'Y' or 'N'");
				}
			}while(true);
		}
	}
	@SuppressWarnings("resource")
	public static void main(String[] args){
		ta.start();
		try{
			try{
				outStrm.println("Welcome To Aviation Management System");
				outStrm.println("Today's Date = "+new DateInfo().getDate());
				Airport_Manager.refresh();
				outerLabel :
					do{
						outStrm.println("Functions Available Are - ");
						int c = 0;
						outStrm.println((++c)+")"+"Plane Arrival");//#1
						outStrm.println((++c)+")"+"Helicopter Arrival");//#2
						outStrm.println((++c)+")"+"Plane Departure");//#3
						outStrm.println((++c)+")"+"Helicopter Departure");//#4
						outStrm.println((++c)+")"+"Create New Port");//#5
						outStrm.println((++c)+")"+"Create New Helipad");//#6
						outStrm.println((++c)+")"+"Display Plane Status");//#7
						outStrm.println((++c)+")"+"Display Helicopter Status");//#8
						outStrm.println((++c)+")"+"Display Port Status");//#9
						outStrm.println((++c)+")"+"Display Helicopter Status");//#10
						outStrm.println((++c)+")"+"Set Ticket Rates");//#11
						outStrm.println((++c)+")"+"Set Commercial Plane Capacity");//#12
						outStrm.println((++c)+")"+"New User/Customer Reservation");//#13
						outStrm.println((++c)+")"+"Display List Of Planes");//#14
						outStrm.println((++c)+")"+"Display List Of Helicopters");//#15
						outStrm.println((++c)+")"+"Display List Of Ports");//#16
						outStrm.println((++c)+")"+"Display List Of HeliPads");//#17
						outStrm.println((++c)+")"+"Display List Of Boarded Users");//#18
						outStrm.println((++c)+")"+"Load Existing Record");//#19
						outStrm.println((++c)+")"+"Update Current Record");//#20
						outStrm.println((++c)+")"+"Refresh Data");//#21
						outStrm.println((++c)+")"+"Set Currency");//#22
						outStrm.println((++c)+")"+"Exit");//#23
						int ch;
						do{try{
							ch = new Scanner(System.in).nextInt();
							if(ch<1||ch>c)
								throw new RangeMismatchException();
							break;
						}
						catch(InputMismatchException e1)
						{errStrm.println("Wrong Input ; Enter an Integer");}
						catch(RangeMismatchException e2)
						{errStrm.println(e2+"\nEnter a Value Between 1 and "+c);}
						}while(true);
						if(ch==c){
							ta.stop();
							util.exit(0);
						}
						switch(ch)
						{
						case 1 : if(!util.intro("Plane Arrival"))
							break;
						if(Airport_Manager.PlaneArrival()) errStrm.println("Plane Arrived Successfully");
						else errStrm.println("Plane Arrival Failed");
						util.exit(ch);
						break;
						case 2 : if(!util.intro("Helicopter Arrival"))
							break;
						if(Airport_Manager.HeliArrival()) errStrm.println("Helicopter Arrived Successfully");
						else errStrm.println("Helicopter Arrival Failed");
						util.exit(ch);
						break;
						case 3 : if(!util.intro("Plane Departure"))
							break;
						outStrm.println("Enter Port No. -");
						do{
							try{
								Airport_Manager.departP(new Scanner(System.in).nextLine().charAt(0));
								break;
							}
							catch(StringIndexOutOfBoundsException e)
							{errStrm.println("No String Entered ; Try Again");}
						}while(true);
						util.exit(ch);
						break;
						case 4 : if(!util.intro("Helicopter Departure"))
							break;
						outStrm.println("Enter HeliPad No. -");
						do{try{
							Airport_Manager.departP(new Scanner(System.in).nextLine().charAt(0));
							break;
						}
						catch(StringIndexOutOfBoundsException e)
						{errStrm.println("No String Entered ; Try Again");}
						}while(true);
						util.exit(ch);
						break;
						case 5 : if(!util.intro("Creation Of New Port"))
							break;
						outStrm.println("Enter New Port No.-");
						char ref;
						do{try{
							ref = new Scanner(System.in).nextLine().charAt(0);
							break;
						}catch(StringIndexOutOfBoundsException e)
						{errStrm.println("No String Entered ; Try Again");}
						}while(true);
						if(Utilities.Duplicate.checkp(ref,Airport_Manager.b))
						{errStrm.println("Port With Similar No. Already Present");
						break;}
						Airport_Manager.createPort(ref);
						util.exit(ch);
						break;
						case 6 : if(!util.intro("Creation Of New HeliPad"))
							break;
						outStrm.println("Enter New HeliPad No.-");
						char ref1;
						do{try{
							ref1 = new Scanner(System.in).nextLine().charAt(0);
							break;
						} catch(StringIndexOutOfBoundsException e)
						{errStrm.println("String Entered Is Too Small ; Enter At Least 6 Characters");}
						}while(true);
						if(Utilities.Duplicate.checkp(ref1,Airport_Manager.b1))
						{errStrm.println("HeliPad With Similar No. Already Present");
						break;}
						Airport_Manager.createHeliPad(ref1);
						util.exit(ch);
						break;
						case 7 : if(!util.intro("Display Plane Status"))
							break;
						outStrm.println("Enter Plane ID");
						do{try{
							Airport_Manager.findP(new Scanner(System.in).nextLine().substring(0,6).toUpperCase());
							break;
						}catch(StringIndexOutOfBoundsException e)
						{{errStrm.println("String Entered Is Too Small ; Enter At Least 6 Characters");}}
						}while(true);
						util.exit(ch);
						break;
						case 8 : if(!util.intro("Display Helicopter Status"))
							break;
						outStrm.println("Enter Helicopter ID");
						do{try{
							Airport_Manager.findH(new Scanner(System.in).nextLine().substring(0,6).toUpperCase());
							break;
						}catch(StringIndexOutOfBoundsException e)
						{{errStrm.println("String Entered Is Too Small ; Enter At Least 6 Characters");}}
						}while(true);
						util.exit(ch);
						break;
						case 9 : if(!util.intro("Display Port Status"))
							break;
						outStrm.println("Enter Port No.");
						char s1;
						do{try{
							s1 = new Scanner(System.in).nextLine().toUpperCase().charAt(0);
							break;
						}catch(StringIndexOutOfBoundsException e)
						{{errStrm.println("String Entered Is Too Small ; Enter At Least 6 Characters");}}
						}while(true);
						boolean flg = false;
						for(Port x : Airport_Manager.b)
							if(x.getSl()==s1)
							{Airport_Manager.pStatus(x);
							flg=true;}
						if(!flg)
							outStrm.println("Port Not Found");
						util.exit(ch);
						break;
						case 10 : if(!util.intro("Display HeliPad Status"))
							break;
						outStrm.println("Enter HeliPad No.");
						char s2;
						do{try{
							s2 = new Scanner(System.in).nextLine().toUpperCase().charAt(0);
							break;
						}catch(StringIndexOutOfBoundsException e)
						{errStrm.println("String Entered Is Too Small ; Enter At Least 6 Characters");}
						}while(true);
						boolean flg2 = false;
						for(Port x : Airport_Manager.b)
							if(x.getSl()==s2)
							{Airport_Manager.pStatus(x);
							flg2=true;}
						if(!flg2)
							outStrm.println("HeliPad Not Found");
						util.exit(ch);
						break;
						case 11 : if(!util.intro("Set Ticket Rates"))
							break;
						util.setRate();
						util.exit(ch);
						break;
						case 12 : if(!util.intro("Set Commercial Plane Capacity"))
							break;
						util.setCap();
						util.exit(ch);
						break;
						case 13 : if(!util.intro("New User/Customer Reservation"))
							break;
						util.newUserFunc();
						util.exit(ch);
						break;
						case 14 : if(!util.intro("Display List Of Planes"))
							break;
						Airport_Manager.displayPlane(Airport_Manager.a);
						util.exit(ch);
						break;
						case 15 : if(!util.intro("Display List Of Helicopters"))
							break;
						Airport_Manager.displayHeli(Airport_Manager.a1);
						util.exit(ch);
						break;
						case 16 : if(!util.intro("Display List Of Ports"))
							break;
						Airport_Manager.displayPort(Airport_Manager.b);
						util.exit(ch);
						break;          
						case 17 : if(!util.intro("Display List Of HeliPads"))
							break;
						Airport_Manager.displayHeliPad(Airport_Manager.b1);
						util.exit(ch);
						break;
						case 18 : if(!util.intro("Display List Of Boarded Users"))
							break;
						Airport_Manager.displayUser(Airport_Manager.u);
						util.exit(ch);
						break;
						case 19 : if(!util.intro("Load Existing Record"))
							break;
						outStrm.println("Enter Record Serial No.");
						int n;
						do{try{
							n = new Scanner(System.in).nextInt();
							break;
						}
						catch(InputMismatchException ie)
						{errStrm.println("Wrong Input ; Enter A Number");}
						}while(true);
						boolean recflg = false;
						outStrm.println("Loading Record");
						for(Record r : Airport_Manager.rec)
							if(r.getSl()==n) {
								outStrm.println(r);
								recflg = true;
							}
						if(!recflg)
							outStrm.println("Record Not Found");
						break;
						case 20 : if(!util.intro("Update Current Record"))
							break;
						outStrm.println("Updating Data");
						Airport_Manager.updateAll();
						util.exit(ch);
						break;
						case 21 : if(!util.intro("Refresh Date"))
							break;
						innerLabel :
							do{
								outStrm.println("Warning This Is Going To Erase The Current Record ; You Won't Be Able To Make Changes To It");
								outStrm.println("Continue ? (Y/N)");
								do{
									try{
										ch = new Scanner(System.in).nextLine().charAt(0);
										break;
									}
									catch(StringIndexOutOfBoundsException e)
									{errStrm.println("String Entered Is Too Small ; Enter At Least 6 Characters");}
								}while(true);
								switch(ch){
								case 'y':
								case 'Y': outStrm.println("Refreshing Data");
								break innerLabel;
								case 'n':
								case 'N': outStrm.println("Aborting Task");
								continue outerLabel;
								default : errStrm.println("Wrong Choice ; Enter Either 'Y' or 'N'");
								}
							}while(true);
						Airport_Manager.refresh();
						util.exit(ch);
						break;
						case 22 : if(!util.intro("Set Currency"))
							break;
						util.setCurrency();
						util.exit(ch);
						break;
						}
					}while(true);
			}
			catch(Exception e)
			{outStrm.println("Encountered An Exception");
			e.printStackTrace();
			util.exit(47);
			main(new String[10]);}
		}
		finally{ta.stop();
		System.out.println("Time Taken = "+ta.getElapsedTime(TimeUnit.SECONDS));
		}
	}
}