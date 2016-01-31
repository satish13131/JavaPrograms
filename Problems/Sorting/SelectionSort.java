package Problems.Sorting;

import java.util.Scanner;

public class SelectionSort {
	
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
		
		selectionSort(numList);
		
		scanner.close();
	}
	
	private static void printNumList(int[] numList)
	{
		for (int i = 0;i < (numList.length - 1);i++) {
			System.out.print(numList[i] + " ");
		}
		System.out.print(numList[numList.length - 1] + "\n");
	}
	
	private static void selectionSort(int[] numList)
	{
		for (int i = 0;i < (numList.length - 1);i++)
		{
			int min = i;
			for (int j = i + 1;j < numList.length;j++){
				if (numList[j] < numList[min])min = j;
			}
			int temp = numList[i];
			numList[i] = numList[min];
			numList[min] = temp;
			printNumList(numList);
		}
	}

}
//input sample - 29 64 73 34 20