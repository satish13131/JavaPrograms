package Problems;

import java.util.Scanner;

public class MaxContiguousSubSeqSum {
	
	public static void main(String[] args) {
		
		//maximum contiguous subsequence sum
		
		Scanner scanner = new Scanner(System.in);		
		System.out.println("Enter the numbers separated by spaces");
		String input = scanner.nextLine();
		String[] inputList = input.split(" ");
		int[] numList = new int[inputList.length];
		for (int i = 0; i < inputList.length;i++)
		{
			numList[i] = Integer.parseInt(inputList[i]);
		}
		
		getMaxContiguousSubSeqSum(numList);
		
		scanner.close();
		
	}
	
	private static int getMaxContiguousSubSeqSum(int[] numList)
	{		
		int maxSum = 0;
		int seqStart = -1;
		int seqEnd = -1;
		int maxStart = 0;
		int maxEnd = 0;
		int curSum = 0;
        boolean isAllNegative = true;		
		int maxNeg = 0;
        
		seqStart = 0;
		seqEnd = 0;
		
		for (int i = 0;i < numList.length;i++)
		{
			curSum += numList[i];
			
			if (numList[i] >= 0) {
				isAllNegative = false;
			}
			
			if (curSum > maxSum)
			{
				maxSum = curSum;
				maxStart = seqStart;
				maxEnd = i;
			}
			else
			{
				if (curSum < 0)
				{
					seqStart = i + 1;
					curSum = 0;
				}
			}			
			
			if (isAllNegative)
			{
				if (maxNeg == 0 || numList[i] > maxNeg) {
					maxNeg = numList[i];
					maxStart = i;
					maxEnd = i;
					maxSum = maxNeg;
				}
			}
			
		}
		
		System.out.println("Maximum sum - " + maxSum + ";Range - " + maxStart + "-" + maxEnd);
		
		return maxSum;
		
	}
	

}

//input samples
//3 -4 1 2 3 -2
//3 -2 1 3 4 -5 1 2
//3 -2 1 3 4 -5 1 2 3
//-5 -6 -8 -2 -3
//-5 -6 -8 -2 -3 0
//-5 -6 -8 -2 -3 0 1 3
