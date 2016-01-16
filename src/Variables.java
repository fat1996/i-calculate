import java.util.*;
import java.text.DecimalFormat;
public class Variables {
	
	//this arraylist stores the results of all previous computations.
	static ArrayList allcalc=new ArrayList();
	
	//This counter is for the main menu.The lengthy introduction at the beginning is only when the user 1st starts the program.
	//After that,if the main menu is accessed again,the lengthy description isn't provided.
	static int counter=0;
	
	public static void display()
	{
		Scanner a=new Scanner(System.in);
		Variables v=new Variables();
		System.out.println("\nBefore exiting,do you wish to view all previous calculations?\n");
		System.out.println("(1) -> Yes");
		System.out.println("(2) -> to terminate");
		System.out.print("-> ");
		int input=a.nextInt();
		
		if(input==1)
		{
			System.out.println("\nDisplaying all previous calculations: \n");
			for(int i=0;i<v.allcalc.size();i++)
			{
				System.out.println(v.allcalc.get(i)+"\n");
			}
			System.out.println("\nGoodbye!");
		}
		else if(input==2)
		{
			System.out.println("Goodbye!");
		}
		else
		{
			System.out.println("Option not available.\nTry again.");
			display();
		}
		
		
	}
	
}

