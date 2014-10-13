package com.number.logic.permutation;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	private static Main main = null;
	
	public static void main(String[] args) {
		
		main = new Main();
		main.instanceMain(args);
		
	}
	
	private void instanceMain(String[] args) {
		
		//printSamplePermutationList();
		
		printPermutationListOneByOne();
		
		System.out.println("program exited");
		
	}
	
	private void printSamplePermutationList() {
		Permutation<Integer> samplePermutation = new Permutation<Integer>() {
			
			@Override
			public void onPermutationFind(List<Integer> permutation) {
				
				for (int i = 0;i < permutation.size();i++) {
					System.out.print(permutation.get(i));
				}
				System.out.println();
				
			}
			
			@Override
			public void printPermutation(List<Integer> permutation) {
				if (permutation == null) {
					return;
				}
				
				for (int i = 0;i < permutation.size();i++) {
					System.out.print(permutation.get(i));
				}
				
				System.out.println();
				
			}
		};
		
		List<Integer> allObjectList = new ArrayList<Integer>();
		for (int i = 1;i <= 5;i++) {
			allObjectList.add(i);
		}
		
		System.out.println("The permutations are");
		samplePermutation.findAllPermutations(allObjectList, null);
		
	}
	
	private void printPermutationListOneByOne() {
		
		Permutation<Integer> samplePermutation = new Permutation<Integer>() {
			
			@Override
			public void onPermutationFind(List<Integer> permutation) {
				
				for (int i = 0;i < permutation.size();i++) {
					System.out.print(permutation.get(i));
				}
				System.out.println();
				
			}
			
			@Override
			public void printPermutation(List<Integer> permutation) {
				if (permutation == null) {
					return;
				}
				
				for (int i = 0;i < permutation.size();i++) {
					System.out.print(permutation.get(i));
				}
				
				System.out.println();
				
			}
		};
		
		List<Integer> allObjectList = new ArrayList<Integer>();
		for (int i = 1;i <= 4;i++) {
			allObjectList.add(i);
		}
		
		
		samplePermutation.setAllObjectList(allObjectList);
		samplePermutation.initPermutationState();
		
		List<Integer> permutation = null;
		
		System.out.println("The permutations are");
		
		do {
			
			permutation = samplePermutation.getPermutation();
			
			printPermutation(permutation);
			
			
		}while (permutation != null);
	}

	private void printPermutation(List<Integer> permutation) {
		
		if (permutation == null) {
			return;
		}
		
		for (int i = 0;i < permutation.size();i++) {
			System.out.print(permutation.get(i));
		}
		
		System.out.println();
		
	}
}
