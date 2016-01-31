package Problems.Sorting;

import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);		
		System.out.println("Enter the numbers separated by spaces");
		String input = scanner.nextLine();
		String[] inputList = input.split(" ");
		int[] numList = new int[inputList.length];
		for (int i = 0; i < inputList.length;i++)
		{
			numList[i] = Integer.parseInt(inputList[i]);
		}
		printNumList(numList);
		
		bubbleSort(numList);
		
		scanner.close();
	}
	
	private static void printNumList(int[] numList)
	{
		for (int i = 0;i < (numList.length - 1);i++) {
			System.out.print(numList[i] + " ");
		}
		System.out.print(numList[numList.length - 1] + "\n");
	}
	
	private static void bubbleSort(int[] numList)
	{
		int len = numList.length;
		int temp = -1;
		for (int i = (len - 1);i > 0;i--)
		{
			for (int j = 0;j < i;j++)
			{
				if (numList[j] > numList[j + 1])
				{
					temp = numList[j];
					numList[j] = numList[j + 1];
					numList[j + 1] = temp;
					printNumList(numList);
				}
			}
		}
	}
	
}
//input samples:
//7 4 6 2 1 9
//7 4 9 2 6 1