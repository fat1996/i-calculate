import java.util.ArrayList;
import java.util.Scanner;
public class Quadratic {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[]args)
	{
		Menu();
	}
	public static void Menu()
	{
		System.out.println("\n\n\t\t\t\t\t* * * * * * * QUADRATIC EQUATION SOLVER * * * * * * *");
		System.out.println("A quadratic equation is of the form y = ax^2 + bx +c\n");
		ArrayList<Double> terms=new ArrayList();
		Variables v=new Variables();
		
		//Quadratic equation solver.
		System.out.print("Enter the co-efficient of x^2: ");
		String coeff1=sc.next();
		terms.add(Double.parseDouble(coeff1));
		
		System.out.print("Enter the co-efficient of x: ");
		String coeff2=sc.next();
		terms.add(Double.parseDouble(coeff2));
		
		System.out.print("Enter the constant term: ");
		String constant=sc.next();
		terms.add(Double.parseDouble(constant));
		
		//begin with the discriminant.
		Double a=terms.get(0);
		Double b=terms.get(1);
		Double c=terms.get(2);
		
		Double dis=(Math.pow(b,2.0))-(4*a*c);
		if(dis < 0)
		{
			System.out.println("\nThis equation has no real roots.");
			if(c>0)
			{
				v.allcalc.add("y = "+a+"x^2 + "+b+"x + "+c+": "+"No real roots");
			}
			else
			{
				v.allcalc.add("y = "+a+"x^2 + "+b+"x "+c+": "+"No real roots");
			}
			
		}
		else
		{
			System.out.println("\nx = "+((Math.pow(dis,0.5)-b)/(2*a))+" OR "+"x = "+((-1*(Math.pow(dis,0.5))-b)/(2*a)));
			v.allcalc.add("y = "+a+"x^2 + "+b+"x "+c+": x = "+((Math.pow(dis,0.5)-b)/(2*a))+" OR "+"x = "+((-1*(Math.pow(dis,0.5))-b)/(2*a)));
		}
		System.out.println("\n");
		retry();
		
	}

	public static void retry()
	{
		Variables v=new Variables();
		System.out.println("Choose from the following and then press ENTER\n");
		System.out.println("(1) -> to return to the Main Menu");
		System.out.println("(2) -> if you wish to stay within the Quadratic Equation Solver");
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

