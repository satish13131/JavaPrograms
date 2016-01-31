package Problems;

import java.util.Scanner;

public class CombUsingPT {
	
	public static void main(String[] args) {
		
		//Get binomial coefficient or combination using Pascal Triangle
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter n,r separated by space");
		
		String input = scanner.nextLine();
		String[] inputList = input.split(" ");
		
		if (inputList.length != 2) {
			System.out.println("Invalid input");
		}
		
		int n = Integer.parseInt(inputList[0]);
		int r = Integer.parseInt(inputList[1]);
		
		if (n < r) {
			System.out.println("Invalid input");
		}
		
		int result = -1;
		result = getPTValue(n, r);
		
		System.out.println("Pascal Triangle Value - at " + n + "," + r + "  -  " + result);
		
		scanner.close();
		
	}
	
	private static int getPTValue(int n, int r)
	{
		if (r == 0 || n == r) {
			return 1;
		}
		return getPTValue(n-1, r-1) + getPTValue(n-1, r);
	}

}
