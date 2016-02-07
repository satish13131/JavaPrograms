package Problems.Sorting;

import java.util.Scanner;

public class QuickSort {
	
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
		
		quickSort(numList);
		
		printNumList(numList);
		
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
	
	private static void quickSort(int[] numList)
	{
		quickSort(numList, 0, numList.length - 1);
	}
	
	private static void quickSort(int[] numList, int start, int end)
	{
		if (start >= end)
		{
			return;
		}
		
		int temp;
		
		if (end == (start + 1))
		{
			if (numList[end] < numList[start])
			{
				temp = numList[start];
				numList[start] = numList[end];
				numList[end] = temp;				
			}
			return;
		}
		
		int pivot = ((start + end) / 2);
		
		if (numList[pivot] != numList[end])
		{
			temp = numList[pivot];
			numList[pivot] = numList[end];
			numList[end] = temp;
		}
		else
		{
			
			int tempMid = pivot;
			while (tempMid < end && numList[tempMid] == numList[end])tempMid++;
			
			if (tempMid == end)
			{
				tempMid = pivot;
				while (tempMid >= start && numList[tempMid] == numList[end])tempMid--;
				if ((tempMid < start) || (tempMid == start && numList[tempMid] < numList[end]))
				{
					return;
				}
				else {
					pivot = tempMid;
				}
			}
			else{
				pivot = tempMid;
			}
			
			temp = numList[pivot];
			numList[pivot] = numList[end];
			numList[end] = temp;
		}	
		
		
		int pt1 = start;
		int pt2 = (end - 1);
		
		while (pt1 < pt2)
		{
			while (numList[pt1] < numList[end] && (pt1 < pt2))
			{				
				pt1++;				
			}
			
			while (numList[pt2] >= numList[end] && (pt1 < pt2))
			{
				pt2--;
			}
			
			if (pt1 < pt2)
			{
			    temp = numList[pt1];
				numList[pt1] = numList[pt2];
				numList[pt2] = temp;
			}
			
		}
		
		if (numList[pt2] >= numList[end])
		{

			temp = numList[pt2];
			numList[pt2] = numList[end];
			numList[end] = temp;
			printNumList(numList, start, end);
			quickSort(numList, start, pt2 - 1);
			quickSort(numList, pt2, end);
		}
		else {
			printNumList(numList, start, end);

			quickSort(numList, start, end - 1);
			
		}
		
		
	}
	
}

//input samples
//3 1 5 6 2 9 8
//4 2 5 7 8 8 9 1
//7 3 7 2 7 7 9 1 8
//7 8 8
//2 2 1
//9 8 7 6 5 4
//1 2 3 4 5
//1 3 2 2 2
//3 1 2 2 2
