import java.util.*;


public class IntroClass {
	static Scanner a =new Scanner(System.in);
		public static void main(String[]args)
		{
			MainMenu();
		}
		
		public static void MainMenu()
		{
			
			ArrayList InputList=new ArrayList<>();
			
			Variables v=new Variables();
			
			if(v.counter==0)
			{
				System.out.println("\t\t\t\t\t\t* * * * * * * Welcome to * * * * * * * \n\t\t\t\t\t\t\t     i-calculate\n ");
			v.counter++;
			}
			else
			{
				System.out.println("\n\n\t\t\t\t\t\t* * * * * * * MAIN MENU * * * * * * *");
			}
			System.out.println("Choose from the following and then press ENTER\n");
			System.out.println("(1) -> Basic Arithmetic");
			System.out.println("(2) -> GCD Calculator");
			System.out.println("(3) -> Linear Diophantine Equations");
			System.out.println("(4) -> Quadratic Equation Solver");
			System.out.println("(5) -> Higher Degree Polynomials");
			System.out.println("(6) -> Exit");
			System.out.print("-> ");
			int input=a.nextInt();
			
			switch(input)
			{
			case 1:
				BasicArithmetic.Menu();
				break;
				
			case 2:
				GCD.Menu();
				break;
				
			case 3:
				LDE.Menu();
				break;
			
			case 4:
				Quadratic.Menu();
				break;
				
			case 5:
				HigherDegree.Menu();
				break;
				
			case 6:
				Variables.display();
				System.exit(0);
				break;
				
				default:
					System.out.println("Option not available./nTry again.");
					MainMenu();
					break;
			}
			
		}
		

	}


