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
		switch (i) {
			case 0: double salary = args[i] //amount user makes yearly
				break;
			case 1: double save = args[i] //how much user will put into account each year
				break;
			case 2: double growthRate = args[i] //percentage that account will increase by yearly
				break;
			case 3: int years = args[i] //amount of years program runs for
				break;
			case 4: double infla = args[i] //inflation rate
			
			}
		}
		
	
		double F = salary * save * 0.01; //base funds
		
		System.out.println("End of year 1: $" + F);
		for (int i = 1; i < years; i++)
		{
		F = F * (1+0.01 * growthRate) + salary * save * 0.01;
		if (ans.equals("y")) //CHANGE FOR STRING ARGUMENTS
			F = F * (1 - 0.01 * infla); //converts inflation input to decimal
		System.out.println("End of year " + (i + 1) + ": $" + F);
		}
	}
}
