import java.util.ArrayList;
import java.util.Scanner;

public class GCD {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[]args)
	{
		Menu();
	}
	public static void Menu()
	{
		int big,small,remainder,gcd;  //Variables declared.
		Variables v=new Variables();
		
		ArrayList<Integer> listofnum=new ArrayList();  //Contains the numbers entered by the user.
		System.out.println("\n\n\t\t\t\t\t\t* * * * * * * GCD Calculator * * * * * * *");
		System.out.print("\nEnter the number of values you want to calculate the GCD of: ");
		int counter=sc.nextInt();
		
		for(int i=0;i<counter;i++)
		{
			System.out.print("Value #"+(i+1)+": ");
			int val=sc.nextInt();
			listofnum.add(val);
		}
	
		//Sorting algorithm.
		//This removed the need of conditional statements(we don't have to check if the 1st number is greater than the 2nd element 
		//before applying Euclid's algorithm.
		//The outer loop ensures that the maximum number of swaps are occurred.
		//It ensures the implementation of the swapping process as many times as there are numbers in the array.
		for(int i=0;i<listofnum.size();i++)
		{
			//The inner loop performs the swapping.
			for(int j=1;j<listofnum.size();j++)
			{
				if(listofnum.get(j-1)>listofnum.get(j))
				{
					int dummyvar=listofnum.get(j);
					int dummyvar2=listofnum.get(j-1);
					listofnum.set(j-1, dummyvar);
					listofnum.set(j,dummyvar2);
					
				}
			}
		}
		
		//Remove duplicates from the arraylist containing the user input.
		//nodup contains the array containing the userinput,without any duplicates.
		ArrayList<Integer> nodup=new ArrayList();
		//Remove duplicates.
		for(int i=0;i<listofnum.size();i++)
		{
			if(!nodup.contains(listofnum.get(i)))
			{
				nodup.add(listofnum.get(i));
			}
		}

		//Since the array is sorted in ascending order,we can easily determine which of the indexes has the bigger and smaller values.
	
		 if(nodup.size()==1)
		 {
			 System.out.println("GCD: "+nodup.get(0));
			 v.allcalc.add("GCD of "+nodup+": "+nodup.get(0));
			 
		 }
		 else if(counter==1)
		 {
			 System.out.println("GCD: "+listofnum.get(0));
			 v.allcalc.add("GCD of "+nodup+": "+nodup.get(0));
		 }
		 else  
		 {
			 //The algorithm fails if one of the numbers is 0.
			 if(nodup.get(0)==0)  //To cater to the case when one of the numbers is 0.
			 {
				 big=nodup.get(1);
				 int result=big;
				 greaterthan2(nodup,result,2,listofnum); 
			 }
			 else
			 {
				 small=nodup.get(0);
				 big=nodup.get(1);
				 int result=recursion(big,small);
				 greaterthan2(nodup,result,2,listofnum); 
			 }
			 
		 }
		 retry();
		
	}
	public static void greaterthan2(ArrayList<Integer> nodup,int gcd,int counter,ArrayList<Integer> listofnum)
	{
		Variables v=new Variables();
		if(counter==nodup.size())
		{
			System.out.println("GCD: "+gcd);
			v.allcalc.add("GCD of "+listofnum+": "+gcd);
		}
		else
		{
		//listofnum is already sorted in ascending order.
		int small=gcd;
		int big=nodup.get(counter);
		int result=recursion(big,small);
		counter++;
		greaterthan2(nodup,result,counter,listofnum);
		}
		
		
	}
	//recursive method.
	public static int recursion(int big,int small)
	{
		int remainder=big%small;
		if(remainder==0)
		{
			//small;
		}
		else
		{
			big=small;
			small=remainder;
			return recursion(big,small);
		}
		return small;
	}
	
	public static void retry()
	{
		Variables v=new Variables();
		System.out.println("\nChoose from the following and then press ENTER\n");
		System.out.println("(1) ->  to return to the Main Menu");
		System.out.println("(2) -> if you wish to stay within GCD calculator");
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

