package Problems;

import java.util.Scanner;

public class ValidateLocation {

	public static void main(String[] args) {
		
		
		//Validate location coordinates string - (decimalnum, decimalnum)
		Scanner scanner = new Scanner(System.in);		
		
		System.out.println("Enter the input");
		String inputString = scanner.nextLine();
		
		if (inputString.matches("\\([0-9]+[\\.]{0,1}[0-9]+\\, [0-9]+[\\.]{0,1}[0-9]+\\)")) {
			System.out.println("Valid Input");
		}
		else {
			System.out.println("Invalid Input");
		}
		
		scanner.close();
		
	}
	
	
}
