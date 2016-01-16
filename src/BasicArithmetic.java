import java.util.ArrayList;
import java.util.Scanner;
public class BasicArithmetic {

	static Scanner a=new Scanner(System.in);
	static Variables v=new Variables();
	
	public static void main(String[] args)
	{
		Menu();
	}
	public static void Menu()
	{
		
		boolean datatype=false;
		
		//The while loop continues to execute as long as an incorrect data type is entered.
		while(datatype==false)
		{
		//The try catch statement ensures the correct data type is entered.
		try 
		{
			System.out.println("\n\n\t\t\t\t\t\t* * * * * * * BASIC ARITHMETIC * * * * * * *\n");
			System.out.println("Choose from the following and then press ENTER\n");
			System.out.println("(1) Addition");
			System.out.println("(2) Subtraction");
			System.out.println("(3) Multiplication");
			System.out.println("(4) Division");
			System.out.print("-> ");
			int Userinput=a.nextInt();
	
			datatype=true;
			
			if(Userinput==1)
			{
				System.out.println("\n**** A D D I T I O N ****");
				Computations(1);
			}
			else if(Userinput==2)
			{
				System.out.println("\n**** S U B T R A C T I O N ****");
				Computations(2);
			}
			else if(Userinput==3)
			{
				System.out.println("\n**** M U L T I P L I C A T I O N ****");
				Computations(3);
			}
			else if(Userinput==4)
			{
				System.out.println("\n**** D I V I S I O N ****");
			
					System.out.print("Value #1: ");
					Double val1=a.nextDouble();
					
					System.out.print("Value #2: ");
					Double val2=a.nextDouble();
					
					System.out.println("Result: "+(val1/val2));
					v.allcalc.add(val1+"/"+val2+": "+(val1/val2));
					
					retry();
			} 
			else
			{
				System.out.println("Option not available.Try again.");	
				Menu();
				
			}
		}
		catch (Exception e) 
		{
			//A warning message is printed out for the user.
			System.out.println("\nIncorrect data type entered.\nTry again.");
		}
		}
	
	}

		public static void Computations(int Operator)
		{
			ArrayList<Double> InputList=new ArrayList();
			Double input;
			
			System.out.print("\nPlease enter the number of inputs involved in this computation: ");
			int arraysize=a.nextInt();
			
			for(int i=0;i<arraysize;i++)
			{
				System.out.print("Value #"+(i+1)+": ");
				input=a.nextDouble();
				InputList.add(input);
			}
			
			//Addition
			if(Operator==1)
			{
				double sum=0;
				for(int i=0;i<arraysize;i++)
				{
					double element=InputList.get(i);
					sum=sum+element;
				}
				System.out.println("Result: "+sum);
				v.allcalc.add("Addition of "+InputList+": "+sum);
			}
			//Subtraction
			else if(Operator==2)
			{
				
				double sum=InputList.get(0);
				for(int i=1;i<arraysize;i++)
				{
					double element=InputList.get(i);
					sum=sum-element;
				}
				System.out.println("Result: "+sum);
				v.allcalc.add("Subtraction of "+InputList+": "+sum);
			}
			//Multiplication
			else if(Operator==3)
			{
				
				double sum=1;
				for(int i=0;i<arraysize;i++)
				{
					double element=InputList.get(i);
					sum=sum*element;
				}
				System.out.println("Result: "+sum);
				v.allcalc.add("Multiplication of "+InputList+": "+sum);
			}
			retry();
} 
		public static void retry()
		{
			
			System.out.println("\nChoose from the following and then press ENTER\n");
			System.out.println("(1) -> to return to the Main Menu");
			System.out.println("(2) -> if you wish to stay within Basic Arithmetic");
			System.out.println("(3) -> if you wish to exit");
			System.out.print("-> ");
			int input=a.nextInt();
			
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


