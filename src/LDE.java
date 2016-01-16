import java.util.ArrayList;
import java.util.Scanner;
public class LDE {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[]args)
	{
		Menu();
	}
	public static void Menu()
	{
		System.out.println("\n\n\t\t\t\t\t\t******* L I N E A R *******\n \t\t\t\t\tD I O P H A N T I N E\t E Q U A T I O N \n\t\t\t\t\t\t\tS O L V E R ");

		Variables v=new Variables();
		//These arraylists are needed for the application of the Euclidean Algorithm.
		ArrayList<Integer> xval=new ArrayList();
		ArrayList<Integer> yval=new ArrayList();
		ArrayList<Integer> rval=new ArrayList();
		ArrayList<Integer> qval=new ArrayList();
		
		//The 1st two rows of the x and y columns are added.
		xval.add(1);
		xval.add(0);
		
		yval.add(0);
		yval.add(1);
		
		
		
		System.out.println("A Linear Diophantine Equation is of the form ax + by = c\n");
		System.out.print("Enter the co-efficient of x: ");
		int x=sc.nextInt();
		
		System.out.print("Enter the co-efficient of y: ");
		int y=sc.nextInt();
		
		//Remember to add the larger number 1st in the rval.
				if(x>y)
				{
					rval.add(x);
					rval.add(y);
				}
				else
				{
					rval.add(y);
					rval.add(x);
				}
		
		System.out.print("Enter the value of c: ");
		int c=sc.nextInt();
		
		qval.add(0);
		qval.add(0);
	
		
		//Perform the initial check to see if the gcd(x,y) is divisible by c.
		int gcd=GCD.recursion(x,y);
		
		//This is the number that gets multiplied by the values of x and y to get one sample solution to the LDE.
		int commondiv=c/gcd;
		if(c%gcd==0)  //Solutions exist.
		{
			int q,r;
			int i=1;
			q=rval.get(i-1)/rval.get(i);
			r=rval.get(i-1)%rval.get(i);
			
			while(r!=0)
			{
			q=rval.get(i-1)/rval.get(i);
			qval.add(q);   //qval updated.
			r=rval.get(i-1)%rval.get(i);
			rval.add(r);  //rval updated.
			int xdup=xval.get(i-1)-(xval.get(i)*q);
			int ydup=yval.get(i-1)-(yval.get(i)*q);
			xval.add(xdup);
			yval.add(ydup);
			i++;
			}
			//Final values printed.

			
			int tryx=xval.get(i-1);
			int tryy=yval.get(i-1);

			
			//we have to try out two possible combinations.
			//(x*tryx)+(y*tryy)==gcd
			//(x*tryy)+(y*tryx)==gcd
			if((x*tryx)+(y*tryy)==gcd)
			{
				System.out.println("\nOne particular solution: (x,y)=("+(tryx*commondiv)+","+(tryy*commondiv)+")");
				int compx=(tryx*commondiv);
				int compy=(tryy*commondiv);
				print(compx,compy,x,y,gcd,c);
			}
			else if((x*tryy)+(y*tryx)==gcd)
			{
				System.out.println("\nOne particular solution: (x,y)=("+(commondiv*tryy)+","+(commondiv*tryx)+")");
				int compx=(tryy*commondiv);
				int compy=(tryx*commondiv);
				print(compx,compy,x,y,gcd,c);
			}
		}
		else
		{
			System.out.println("\nThere are no real solutions to this LDE.");
			
			v.allcalc.add("The LDE of the form ax + by = c,where a="+x+" ,b="+y+" and c="+c+" has no real solutions.");
		}
		retry();
		
	}
	//This method prints out the results of the computations.
	//The different cases take care of all possible combinations of signs(positive,negative).
	public static void print(int compx,int compy,int x,int y,int gcd,int c)
	{
		Variables v=new Variables();
		if((y/gcd)<0 & (x/gcd)<0)  //if b/d and a/d are both negative.
		{
			System.out.println("Complete solution: (x,y)=("+compx+" - "+(y/gcd)+"n,"+compy+" + "+(x/gcd)+"n"+")");
			v.allcalc.add("Complete solution to "+x+"x + "+y+"y = "+c+":\n(x,y)=("+compx+"-"+(y/gcd)+"n,"+compy+"+"+(x/gcd)+"n"+")");
		}
		else if((y/gcd)<0 & (x/gcd)>0)  //if b/d is negative,a/d is positive.
		{
			System.out.println("Complete solution: (x,y)=("+compx+" - "+(y/gcd)+"n,"+compy+" - "+(x/gcd)+"n"+")");
			v.allcalc.add("Complete solution to "+x+"x + "+y+"y = "+c+":\n(x,y)=("+compx+"-"+(y/gcd)+"n,"+compy+"-"+(x/gcd)+"n"+")");
		}
		else if((y/gcd)>0 & (x/gcd)<0)  //if b/d is positive,a/d is negative.
		{
			System.out.println("Complete solution: (x,y)=("+compx+" + "+(y/gcd)+"n,"+compy+" + "+(x/gcd)+"n"+")");
			v.allcalc.add("Complete solution to "+x+"x + "+y+"y = "+c+":\n(x,y)=("+compx+"+"+(y/gcd)+"n,"+compy+"+"+(x/gcd)+"n"+")");
		}
		else  ////if both are positive.
		{
			System.out.println("Complete solution: (x,y)=("+compx+" + "+(y/gcd)+"n,"+compy+" - "+(x/gcd)+"n"+")");
			v.allcalc.add("Complete solution to "+x+"x + "+y+"y = "+c+":\n(x,y)=("+compx+"+"+(y/gcd)+"n,"+compy+"-"+(x/gcd)+"n"+")");
		}
			
	}
	public static void retry()
	{
		Variables v=new Variables();
		System.out.println("\nChoose from the following and then press ENTER\n");
		System.out.println("(1) -> to return to the Main Menu");
		System.out.println("(2) -> if you wish to stay within the LDE Calculator");
		System.out.println("(3) -> if you wish to exit");
		System.out.print("-> ");
		int input=sc.nextInt();
		
		switch(input)
		{
		case 1:
			v.counter++;
			IntroClass.MainMenu();
			break;
			
		case 2:
			Menu(); 
			break;
			
		case 3:
			Variables.display();
			break;
			
			default:
				System.out.println("Option not available.\nTry again.");
				retry();
				break;
		}
	}
}

