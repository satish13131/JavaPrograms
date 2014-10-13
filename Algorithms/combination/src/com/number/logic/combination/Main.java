package com.number.logic.combination;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private static Main main = new Main();
	
	private Scanner scanner = null;
	
	
	public static void main(String[] args) {
		
		main.instanceMain(args);
		
		System.out.println("program exited");
	}
	
	private void instanceMain(String[] args) {
		
	
		printSampleCombinationOfSizeOne();
	
	}
	
	private void printSampleCombination() {

		
		Combination<Integer> sampleCombination = new Combination<Integer>();
		
		List<Integer> integerList = new ArrayList<Integer>();
		
		for (int i = 1;i <= 2;i++) {
			integerList.add(i);
		}	
		
		sampleCombination.setAllObjectList(integerList);
		
		sampleCombination.initCombination();
		
		boolean isMoreCombination = true;
		
		System.out.println("The combinations are");
		
		while (isMoreCombination) {
			
			List<Integer> combinationIntegerList = sampleCombination.getCombination();
			
			if (combinationIntegerList == null) {
				isMoreCombination = false;
			}			
			
			printCombinationIntegers(combinationIntegerList);
			
		}	
	}
	
	private void printSampleCombinationOfSizeOne() {
		Combination<Integer> sampleCombination = new Combination<Integer>();
		
		List<Integer> integerList = new ArrayList<Integer>();
		
		for (int i = 1;i <= 5;i++) {
			integerList.add(i);
		}	
		
		sampleCombination.setAllObjectList(integerList);
		
		sampleCombination.initCombination();
		
		boolean isMoreCombination = true;
		
		System.out.println("The combinations of size one are");
		
		while (isMoreCombination) {
			Integer combinationItem = sampleCombination.getCombinationOfSizeOne();
			
			if (combinationItem == null) {
				isMoreCombination = false;
			}
			else {
				System.out.println(combinationItem + "");
			}
		}
		
	}
	
	private void printCombinationIntegers(List<Integer> integerList) {
		if (integerList == null) {
			return ;
		}
		
		
		for (int i = 0;i < integerList.size();i++) {
			System.out.print("" + integerList.get(i).intValue());
		}
		
		System.out.println();
	}
	
	
}