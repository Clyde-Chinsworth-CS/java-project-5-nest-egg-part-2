//Nest Egg Project v.2
//21/04/2018
import java.io.*;
import java.util.*;
public class NestEgg
{
	public static void main(String args[])
	{
		//VARIABLES : salary, save, growthRate, years, infla
		double salary = 0;
		double save = 0;
		double growthRate = 0;
		int years = 0;
		double infla = 0;
		
		for(int i = 0; i < args.length; i++)
		{
			switch (i) {
				case 0: salary = Double.parseDouble(args[i]); //amount user makes yearly
					break;
				case 1: save = Double.parseDouble(args[i]); //how much user will put into account each year
					break;
				case 2: growthRate = Double.parseDouble(args[i]); //percentage that account will increase by yearly
					break;
				case 3: years = Integer.parseInt(args[i]); //amount of years program runs for
					break;
				case 4: infla = Double.parseDouble(args[i]); //inflation rate
					break;
			}
		}
		
		if (salary == 0 || save == 0 || growthRate == 0 || years == 0)
		{
			System.out.println("Error: values not entered.");
			System.out.println("Syntax: java NestEgg <salary> <% annually into account> <% annual growth rate> <amount of years to save for> <OPTIONAL: annual inflation rate>");
		}
		else
		{
			double F = salary * save * 0.01; //base funds
			
			for (int i = 1; i <= years; i++)
			{
				F = F * (1+0.01 * growthRate) + salary * save * 0.01;
				if (infla != 0)
					F = F * (1 - 0.01 * infla); //converts inflation input to decimal
				System.out.println("End of year " + (i) + ": $" + F);
			}
		}
	}
}
