package Problems;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args)
	{
		//Make change from list of coins using dynamic programming
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the list of coins separated by spaces");
		String input = scanner.nextLine();
		String[] inputList = input.split(" ");
		int[] coinList = new int[inputList.length];
		for (int i = 0; i < inputList.length;i++)
		{
			coinList[i] = Integer.parseInt(inputList[i]);
		}
		System.out.println("Enter the max change");
		input = scanner.nextLine();
		int maxChange = Integer.parseInt(input);
		int[] coinsUsed = new int[maxChange];
		makeChange(coinList, coinsUsed);
		scanner.close();
	}
	
	private static void makeChange(int[] coinList, int[] coinsUsed)
	{
		
		for (int i = 0;i < coinsUsed.length;i++)
		{
			int change = i + 1;
			int minCoins = change;
			for (int j = 0;j < coinList.length;j++)
			{
				if (coinList[j] > change)
				{
					continue;
				}
				if (coinList[j] == change)
				{
					minCoins = 1;
					continue;
				}
				if ((coinsUsed[i - coinList[j]] + 1) < minCoins) {
					minCoins = coinsUsed[i - coinList[j]] + 1;
				}
				
			}
			
			coinsUsed[i] = minCoins;
			
		}
		
		
		printCoinsUsedList(coinsUsed);
		
	}
	
	private static void printCoinsUsedList(int[] coinsUsed)
	{
		for (int i = 0;i < (coinsUsed.length - 1);i++) {
			System.out.print((i + 1) + "-" + coinsUsed[i] + " ");
		}
		System.out.print(coinsUsed.length + "-" + coinsUsed[coinsUsed.length - 1] + "\n");
	}
	
	
	
}

//input samples
//1 2 4 8 16 
//7
//1 2 3 6 9
//7