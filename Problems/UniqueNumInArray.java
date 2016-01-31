package Problems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UniqueNumInArray {
	
	public static void main(String[] args) {
		
		//Input array consists of all num's double except one num. Find it using XOR
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the numbers separated by space");
		String input = null;
		String[] inputList = null;
		
		List<Integer> integerList = new ArrayList<Integer>();
		input = scanner.nextLine();
		inputList = input.split("[ ]+");
		
		for (int i = 0;i < inputList.length;i++) {
			integerList.add(Integer.parseInt(inputList[i]));
		}
		
		Iterator<Integer> iterator  = integerList.iterator();
		Integer tempNumber;
		tempNumber = iterator.next();
		Integer result = tempNumber;
		while (iterator.hasNext()) {
			tempNumber = iterator.next();
			result = result ^ tempNumber;
		}
		
		System.out.println("result is - " + result);
		
		scanner.close();
		
	}

}
