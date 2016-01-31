package Problems.Sorting;

import java.util.Scanner;

public class InsertionSort {
	
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
		
		insertionSort(numList);
		
		scanner.close();
	}
	
	private static void printNumList(int[] numList)
	{
		for (int i = 0;i < (numList.length - 1);i++) {
			System.out.print(numList[i] + " ");
		}
		System.out.print(numList[numList.length - 1] + "\n");
	}
	
	private static void insertionSort(int[] numList)
	{
		for (int i = 1;i <= (numList.length - 1);i++) {
			int idx = numList[i];
			int j;
			for (j = i - 1;j >= 0;j--) {
				if (numList[j] > idx) {
					numList[j + 1] = numList[j];
				}
				else {					
					break;
				}
			}
			numList[j + 1] = idx;
			printNumList(numList);
		}
	}

}
//input samples
//29 20 73 34 64