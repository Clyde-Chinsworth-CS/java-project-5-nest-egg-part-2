//Nest Egg Project
//07/04/2018
import java.io.*;
import java.util.*;
public class NestEgg
{
	public static void main(String args[])
	{
		Scanner kbReader = new Scanner(System.in);
	
		System.out.println("Nest Egg Calculator");
		System.out.print("Enter your salary: $");
		double salary = kbReader.nextDouble();
		System.out.print("Enter the percentage of funds to put into the retirement fund: ");
		double save = kbReader.nextDouble();
		if (save > 100 || save < 0)
		{
			System.out.print("Please enter a sensible value. ");
			save = kbReader.nextDouble();
		}
		System.out.print("Enter the annual growth percentage: ");
		double growthRate = kbReader.nextDouble();
		if (growthRate > 100 || growthRate < 0)
		{
			System.out.print("Please enter a sensible value. ");
			growthRate = kbReader.nextDouble();
		}
		System.out.print("Enter the amount of years you want to save for: ");
		int years = kbReader.nextInt(); 
		double F = salary * save * 0.01; //base funds
		
		System.out.print("Incorporate inflation? (Y / N)");
		String ans = (kbReader.next()).toLowerCase(); //converts answer to lower case
		double infla = 0; //inflation rate: declared later
		System.out.println(ans);
		if (ans.equals("y")) // == does not work
		{
			System.out.println("hello");
			System.out.print("Enter annual inflation rate. ");
			infla = kbReader.nextDouble(); //value of money will increase by % every year
		}
		
		System.out.println("End of year 1: $" + F);
		for (int i = 1; i < years; i++)
		{
		F = F * (1+0.01 * growthRate) + salary * save * 0.01;
		if (ans.equals("y"))
			F = F * (1 - 0.01 * infla); //converts inflation input to decimal
		System.out.println("End of year " + (i + 1) + ": $" + F);
		}
	}
}
