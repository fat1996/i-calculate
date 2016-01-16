import java.text.DecimalFormat;
import java.util.*;

public class HigherDegree {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[]args)
	{
		Menu();
	}
	public static void Menu()
	{
		System.out.println("\n\n\t\t\t\t\t* * * * * * * HIGHER DEGREE POLYNOMIALS * * * * * * *");
		System.out.println("Please select from the following options: ");
		System.out.println("1. Remainder Calculation");
		System.out.println("2. Determining the roots of Higher Degree Polynomials");
		int option=sc.nextInt();
		
		//This method is accessed by both options.
				ArrayList<Double> input=new ArrayList();
				//Determining the roots.
				System.out.print("Please enter the highest power of x in your polynomial");
				int counter=sc.nextInt();
				
				String val;
				for(int i=counter;i>=1;i--)
				{
					System.out.print("Enter the co-efficient of the x^"+i+" term: ");
					val=sc.next();
					input.add(Double.parseDouble(val));
					
				}
				System.out.print("Enter the constant term: ");
				val=sc.next();
				input.add(Double.parseDouble(val));
				
				//Printing out the polynomial.
				//System.out.println("The polynomial is: ");
				//for(int i=0;i<input.size()-1;i++)
				//{
					//System.out.println(input.get(i)+"x^"+(input.size()-i-1));
				//}
				//System.out.println(input.get(input.size()-1));
				
if(option==1)
{
	System.out.println("Please enter the value of x to be substituted: ");
	Double factor=sc.nextDouble();
	RemainderCalc(factor,counter,input);
	
}
else if(option==2)
{
	RootCalc(input,counter);
}
else
{
	System.out.println("Option not available.\nTry again.");	
}

System.out.println("\n");
retry();
	}
	public static void repeat(ArrayList<Double> input,int counter)
	{
		System.out.println("Would you like to substitute a different value in the previously entered expression?");
		System.out.println("Press (1) for yes");
		System.out.println("Press (2) for no");
		int userinp=sc.nextInt();
		
		if(userinp==1)
		{
			System.out.println("Please enter the value of x to be substituted: ");
			Double factor=sc.nextDouble();
			RemainderCalc(factor,counter,input);
			
		}
		else if(userinp==2)
		{
			retry();
		}
		else
		{
			System.out.println("Option not available.\nTry again.");
			repeat(input,counter);
		}
		
	}
	public static void RemainderCalc(double factor,int counter,ArrayList<Double> input)
	{
		ArrayList<Double> comp=new ArrayList();
		//Check all the factors from listfactors to see if they return 0 when plugged into the polynomial.
		
		int count=counter;  //highest power in the polynomial.
		Double total=0.0;  //has to be declared within the outer for loop,since its value needs to be initialized to 0 each time a factor is evaluated.
		for(int i=0;i<input.size();i++)
		{
			comp.add((input.get(i)*(Math.pow(factor,count-i))));
		}
		
		//This loop adds all the terms,to give us the total.
		for(int i=0;i<comp.size();i++)
		{
			total=total+comp.get(i);
		}
	System.out.println("Remainder: "+total);
		repeat(input,counter);
	}
	public static void RootCalc(ArrayList<Double> input,int counter)
	{
		        //applying the rational roots theorem.
				Double p=input.get(input.size()-1);  //p is the constant term.
				Double q=input.get(0);   //q is the co-efficient of the highest power in the polynomial.
				
				
				//System.out.println("\np is: "+p);
				//System.out.println("q is: "+q);
				
				//Determine all possible factors of p and q.
				//Store them in different arrays.
				ArrayList<Double> pfactors=new ArrayList();
				ArrayList<Double> qfactors=new ArrayList();
				
				//factors of p.
					for(double i=1;i<=Math.abs(p);i++)
					{
						if(Math.abs(p)%i==0)
						{
							pfactors.add(i);
							pfactors.add(i*-1);
						}
					}
					
				//factors of q.
				for(double i=1;i<=Math.abs(q);i++)
				{
					if(Math.abs(q)%i==0)
					{
						qfactors.add(i);
						qfactors.add(-1*i);
					}
				}
				//System.out.println("Factors of p: "+pfactors);
				//System.out.println("Factors of q: "+qfactors);
				
				//Make all possible combinations of factors.
				ArrayList<Double> listfactors=new ArrayList();
				
				for(int i=0;i<pfactors.size();i++)
				{
					for(int j=0;j<qfactors.size();j++)
					{
						listfactors.add((double) (pfactors.get(i)/qfactors.get(j)));
					}
				}
				//System.out.println("Length: "+listfactors.size()+"All possible roots: "+listfactors);
				//Once you have the list of all possible factors,we have to remove all duplicates.
				//the removedup method is called.
				removedup(listfactors,counter,input);
	}
	public static void removedup(ArrayList<Double> listfactors,int counter,ArrayList<Double> input)
	{
				ArrayList<Double> nodup=new ArrayList();
				//Remove duplicates.
				for(int i=0;i<listfactors.size();i++)
				{
					if(!nodup.contains(listfactors.get(i)))
					{
						nodup.add(listfactors.get(i));
					}
				}
				//listfactors contains all the possible roots,with the duplicates removed. 
				//System.out.println("Length: "+nodup.size()+"Refined list of factors: "+nodup);
				
				//Once we have the refined list of factors,we need to plug each one of them into the original expression to check the remainder.
				ArrayList<Double> comp=new ArrayList();
				//Check all the factors from listfactors to see if they return 0 when plugged into the polynomial.
				
				int count=counter;  //highest power in the polynomial.
				for(int j=0;j<nodup.size();j++)	
				{
					Double total=0.0;  //has to be declared within the outer for loop,since its value needs to be initialized to 0 each time a factor is evaluated.
				for(int i=0;i<input.size();i++)
				{
					comp.add((input.get(i)*(Math.pow(nodup.get(j),count-i))));
				}
				
				//This loop adds all the terms,to give us the total.
				for(int i=0;i<comp.size();i++)
				{
					total=total+comp.get(i);
				}
				if(total==0.0)
				{
				System.out.println("Factor: "+nodup.get(j));
				}
				comp.clear();  //This array that stores the result of the computation needs to be re-initialized too.
			    } 
	}

	
	public static void retry()
	{
		Variables v=new Variables();
		System.out.println("Choose from the following and then press ENTER\n");
		System.out.println("(1) -> to return to the Main Menu");
		System.out.println("(2) -> if you wish to stay within Higher Degree Polynomials");
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
