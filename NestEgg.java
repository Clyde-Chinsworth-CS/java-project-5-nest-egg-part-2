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
		double salary = 0;
		double save = 0;
		int years = 0;
		int retire = 0;
		double expenses = 0;
		double infla = 0;
		Boolean isZero = false;
		
		for(int i = 0; i < args.length; i++)
		{
			switch (i) {
				case 0: salary = Double.parseDouble(args[i]); //amount user makes yearly
					break;
				case 1: save = Double.parseDouble(args[i]); //how much user will put into account each year
					break;
				case 2: years = Integer.parseInt(args[i]); //amount of years program runs for
					break;
				case 3: retire = Integer.parseInt(args[i]); // amount of years required to retire
					break;
				case 4: expenses = Double.parseDouble(args[i]); //Expenses for years after retirement
					break;
				case 5: infla = Double.parseDouble(args[i]); //inflation rate
					break;
			}
		}
		
		if (salary == 0 || save == 0 || years == 0)
		{
			System.out.println("Error: values not entered.");
			System.out.println("Syntax: java NestEgg <salary> <% annually into account> <amount of years to save for> <OPTIONAL: years to retire> <OPTIONAL: annual retirement expenses> <OPTIONAL: annual inflation rate>");
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
			
			double[] growthRates;
			growthRates = new double[years];
			
			for (int i = 0; i < years; i++)
			{
				growthRates[i] = Double.parseDouble(textReader.readLine());
			}
			 
			for (int i = 1; i <= years; i++)
			{
				if (retire != 0 && i >= retire)
				{
					if (i == (retire))
					{
						System.out.println("RETIREMENT"); //seperates retired years
						if (expenses == 0)
						{ 
							double G = F; //does not change value of F
							expenses = G / years - retire;
							while (isZero == false)
							{
								for (int j = i; j <= years; j++) //simulates the program to determine optimal expenses value through systematic trial and error
								{
									G = (G - expenses) * (1 + 0.01 * growthRates[j-1]); 
								}
								if (G > 20) //increases expenses if outcome of balance is too high
								{
									expenses += 0.05;
									G = F;
								}
								else if (G < -20) //decreases expenses if outcome of balance is too low
								{
									expenses -= 0.05;
									G = F;
								}
								else //stops simulation if outcome is in optimal range
								{
									isZero = true;
									System.out.println("Annual expenses: $" + expenses);
									//as the number of years increase, risk of infinite loop also increases
								}
							} 
						}
					}
				}

				
				if (i < retire || retire == 0)
					F = F * (1+0.01 * growthRates[i-1]) + salary * save * 0.01;
				else
					F = (F - expenses) * (1+0.01 * growthRates[i-1]);
				
				if (infla != 0)
					F = F * (1 - 0.01 * infla); //converts inflation input to decimal
				System.out.println("End of " + (i + 1959) + ": $" + F + " Growth Rate: " + growthRates[i-1] + "%");
			}
		}
	}
}
