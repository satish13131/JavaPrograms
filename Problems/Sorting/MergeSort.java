package Problems.Sorting;

import java.util.Scanner;

public class MergeSort {
	
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
		
		mergeSort(numList);
		
		scanner.close();
	}
	
	private static void printNumList(int[] numList)
	{
		for (int i = 0;i < (numList.length - 1);i++) {
			System.out.print(numList[i] + " ");
		}
		System.out.print(numList[numList.length - 1] + "\n");
	}
	
	private static void printNumList(int[] numList, int start, int end)
	{
		for (int i = start;i < end;i++) {
			System.out.print(numList[i] + " ");
		}
		System.out.print(numList[end] + "\n");
	}
	
	private static void mergeSort(int[] numList)
	{
		int[] tmpArray = new int[numList.length];
		mergeSort(numList, tmpArray, 0, numList.length - 1);
	}
	
	private static void mergeSort(int[] numList, int[] tmpArray, int start, int end) {
		
		if (start >= end)return;
		
		if ((end - start) == 1) {
			if (numList[start] > numList[end]) {				
				int temp = numList[start];
				numList[start] = numList[end];
				numList[end] = temp;
			}
			printNumList(numList, start, end);
			return;
		}
		
		int mid = -1;
		if ((start + end) % 2 == 0) {
			mid = ((start + end) / 2);
		}
		else {
			mid = ((start + end - 1) / 2);
		}
		
		mergeSort(numList, tmpArray, start, mid);
		mergeSort(numList, tmpArray, mid + 1, end);

		int pt1 = start;
		int pt2 = mid + 1;
		int pt3 = start;
		
		while (pt1 <= mid && pt2 <= end) {
			
			if (numList[pt1] <= numList[pt2]) {
				tmpArray[pt3] = numList[pt1];
				pt3++;
				pt1++;
				continue;
			}
			else
			{
				tmpArray[pt3] = numList[pt2];
				pt3++;
				pt2++;
				continue;
			}
			
		}
		
		if (pt1 <= mid) {
			while (pt1 <= mid) {
				tmpArray[pt3] = numList[pt1];
				pt3++;
				pt1++;
			}
		}
		else if (pt2 <= end) {
			while (pt2 <= end) {
				tmpArray[pt3] = numList[pt2];
				pt3++;
				pt2++;
			}
		}
		
		for (int i = start;i <= end;i++) {
			numList[i] = tmpArray[i];
		}
		
		printNumList(numList, start, end);
		
		
	}
	
}
