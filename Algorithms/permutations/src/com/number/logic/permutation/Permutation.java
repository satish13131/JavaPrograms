package com.number.logic.permutation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.infra.SwapUtil;

public abstract class Permutation<GenericObjectClass> {
	
	private List<GenericObjectClass> allObjectList = null;
	
	private List<GenericObjectClass> currentPermutationState = null;
	
	private boolean isInitPermutation = true;
	
	public Permutation() {
		
	}

	public List<GenericObjectClass> getAllObjectList() {
		return allObjectList;
	}

	public void setAllObjectList(List<GenericObjectClass> allObjectList) {
		this.allObjectList = allObjectList;
	}
	
	public void initPermutationState() {
		if (currentPermutationState == null) {
			currentPermutationState = new ArrayList<GenericObjectClass>();
		}
		currentPermutationState.clear();
		currentPermutationState.addAll(allObjectList);
		isInitPermutation = true;
	}
	
	public List<GenericObjectClass> getPermutation() {
		
		if (currentPermutationState == null) {
			return null;
		}
		
		if (allObjectList == null) {
			return null;
		}
		
		if (allObjectList.size() != currentPermutationState.size()) {
			return null;
		}
		
		if (isInitPermutation) {
			isInitPermutation  = false;
			return currentPermutationState;
		}
		
		int size = currentPermutationState.size();
		int i = 0;
		int index1 = 0;
		int index2 = 0;
		
		
		//find index1 ,where increasing order of indices from right terminates
		for (i = (size - 1);i > 0; i--) {
			
			if (allObjectList.indexOf(currentPermutationState.get(i)) > allObjectList.indexOf(currentPermutationState.get(i - 1))) {
				break;
			}
			
		}	
		if (!(i > 0)) {
			return null;
		}
		
		index1 = i - 1;
		
		//find index2, whose value is just greater than that of index1 
		i = 0;
		int tempIndex = allObjectList.indexOf(currentPermutationState.get(index1));
		for (i = (size - 1);i > 0; i--) {
			
			if (allObjectList.indexOf(currentPermutationState.get(i)) > tempIndex) {
				break;
			}
			
		}
		
		index2 = i;
		//System.out.println("Index1 is " + index1);
		//System.out.println("Index2 is " + index2);
		//System.out.println("The state before swap is");
		//printPermutation(currentPermutationState);
		
		//swap index1 and index2
		SwapUtil.swap(index1, index2, currentPermutationState);
		
		//System.out.println("The state after swap is");
		//printPermutation(currentPermutationState);
		
		if (index1 >= (currentPermutationState.size() - 2)) {
			return currentPermutationState;
		}
		
		int index3 = index1 + 1;
		int index4 = currentPermutationState.size() - 1;
		
		while (index3 < index4) {
			SwapUtil.swap(index3, index4, currentPermutationState);
			index3++;
			index4--;
		}
		
		return currentPermutationState;
		
	}
	
	public void findAllPermutations(List<GenericObjectClass> allObjectList, List<GenericObjectClass> currentPermutationState) {
		
		if (allObjectList == null) {
			return;
		}
		
		if (currentPermutationState == null) {
			currentPermutationState = new ArrayList<GenericObjectClass>();
		}
		
		if (currentPermutationState.size() == allObjectList.size()) {
			onPermutationFind(currentPermutationState);
		}
		
		List<GenericObjectClass> tempCurrentPermutationState = new ArrayList<GenericObjectClass>();
		tempCurrentPermutationState.addAll(currentPermutationState);
		
		List<GenericObjectClass> iteratorList = new ArrayList<GenericObjectClass>();
		prepareIteratorList(iteratorList, allObjectList, currentPermutationState);
		
		Iterator<GenericObjectClass> iterator = iteratorList.iterator();
		while (iterator.hasNext()) {
			GenericObjectClass genericObject = iterator.next();
			currentPermutationState.add(genericObject);
			findAllPermutations(allObjectList, currentPermutationState);
			currentPermutationState.retainAll(tempCurrentPermutationState);
		}
		
		
	}
	
	
	private void prepareIteratorList(List<GenericObjectClass> iteratorList, List<GenericObjectClass> allObjectList, List<GenericObjectClass> currentPermutationState) {
		
		if (iteratorList == null) {
			return;
		}
		if (allObjectList == null) {
			return;
		}
		if (currentPermutationState == null) {
			return;
		}
		
		Iterator<GenericObjectClass> iterator = allObjectList.iterator();
		while (iterator.hasNext()) {
			GenericObjectClass genericObject = iterator.next();
			if (!currentPermutationState.contains(genericObject)) {
				iteratorList.add(genericObject);
			}
		}		
		
	}

	public abstract void onPermutationFind(List<GenericObjectClass> permutation);
	
	public abstract void printPermutation(List<GenericObjectClass> permutation);
}
