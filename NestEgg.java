//Nest Egg Project
//07/04/2018
import java.io.*;
import java.util.*;
public class NestEgg
{
	public static void main(String args[])
	{
		//VARIABLES : salary, save, growthRate, years, infla
		for(int i = 0; i < args.length; i++)
		{
		
		}
		
	
		double F = salary * save * 0.01; //base funds
		
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
