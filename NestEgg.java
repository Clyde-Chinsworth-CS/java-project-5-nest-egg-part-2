//Nest Egg Project v.2
//21/04/2018
import java.io.*;
import java.util.*;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class NestEgg
{
	public static void main(String args[]) throws IOException
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
				case 2: years = Integer.parseInt(args[i]); //amount of years program runs for
					break;
				case 3: infla = Double.parseDouble(args[i]); //inflation rate
					break;
			}
		}
		
		if (salary == 0 || save == 0 || years == 0)
		{
			System.out.println("Error: values not entered.");
			System.out.println("Syntax: java NestEgg <salary> <% annually into account> <amount of years to save for> <OPTIONAL: annual inflation rate>");
		}
		else if (years > 59) //Text file only has 59 lines
		{
			System.out.println("Error: Enter an amount of years less than 60");
		}
		else
		{
			//Text file starts at 1960, goes to 2019
		
			double F = salary * save * 0.01; //base funds
			
			FileReader fr = new FileReader("growthRate.txt");
			BufferedReader textReader = new BufferedReader(fr);
			
			for (int i = 1; i <= years; i++)
			{
				growthRate = Double.parseDouble(textReader.readLine());
				F = F * (1+0.01 * growthRate) + salary * save * 0.01;
				if (infla != 0)
					F = F * (1 - 0.01 * infla); //converts inflation input to decimal
				System.out.println("End of year " + (i) + ": $" + F);
			}
		}
	}
}
