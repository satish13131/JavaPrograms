package com.number.logic.combination;

import java.util.ArrayList;
import java.util.List;

public class Combination<GenericObjectClass> {

	private List<GenericObjectClass> allObjectList = null;
	//private long allCombinationsSize = 0;
	
	//private int previousCombinationReturned = 0;
	private List<Boolean> currentCombinationStatus = null;
	private Boolean isCombinationInitStatus = true;
	private boolean isAllCombinationsDone = false;
	
	
	public Combination() {
		
	}

	public List<GenericObjectClass> getAllObjectList() {
		return allObjectList;
	}

	public void setAllObjectList(List<GenericObjectClass> allObjectList) {
		this.allObjectList = allObjectList;		
	}

	/*public long getAllCombinationsSize() {
		return allCombinationsSize;
	}*/

	/*public void setAllCombinationsSize(long allCombinationsSize) {
		this.allCombinationsSize = allCombinationsSize;
	}*/
	
	public void initCombination() {
		isCombinationInitStatus = true;
		if (allObjectList != null) {
			//setAllCombinationsSize((long) Math.pow(2, allObjectList.size()));
			currentCombinationStatus = new ArrayList<Boolean>();
			initCurrentCombinationStatus();
		}
		else {
			//setAllCombinationsSize(0);
			currentCombinationStatus = null;
		}
	}
	private void initCurrentCombinationStatus() {
		if (currentCombinationStatus == null) {
			return;
		}
		currentCombinationStatus.clear();
		for (int i = 0;i < allObjectList.size();i++) {
			currentCombinationStatus.add(i, false);
		}
	}
	
	/**
	 * 
	 * 
	 * @return
	 * a list containing a combination. Size may vary from zero to n.
	 * This method can be called until all the combinations are consumed
	 * After that the method returns null
	 * Use setObjectList and initCombination() to reinitialize the combination
	 * 
	 */
	public List<GenericObjectClass> getCombination() {		
		
		if (currentCombinationStatus == null) {
			return null;
		}	
		
//		if (previousCombinationReturned == allCombinationsSize) {
//			return null;
//		}
		
		/*if (isLastCombinationAlreadyReturned()) {
			return null;
		}*/
		
		if (isAllCombinationsDone) {
			return null;
		}
		
		List<GenericObjectClass> combinationList = new ArrayList<GenericObjectClass>();
		
		//System.out.println("currentCombinationStatus size is " + currentCombinationStatus.size());
		//System.out.println("currentCombinationStatus is ");
		
		for (int i = 0;i < currentCombinationStatus.size();i++) {
			//System.out.print(currentCombinationStatus.get(i) + " ");
			if (currentCombinationStatus.get(i)) {
				combinationList.add(allObjectList.get(i));
			}
		}
		
		incrementToNextCombination();
			
		return combinationList;
		
	}
	
	/**
	 * 
	 * 
	 * @return
	 * a list containing a combination of size 1
	 * This method can be called until all the combinations are consumed
	 * After that the method returns null
	 * Use setObjectList and initCombination() to reinitialize the combination
	 * 
	 */
	public GenericObjectClass getCombinationOfSizeOne() {
		
		if (currentCombinationStatus == null) {
			return null;
		}
		
		GenericObjectClass combinationItem = null;
		
		for (int i = 0;i < currentCombinationStatus.size();i++) {
			if (!currentCombinationStatus.get(i)) {
				currentCombinationStatus.set(i, true);
				combinationItem =  allObjectList.get(i);
				return combinationItem;
			}
		}
		
		return null;
		
	}
	
	private void incrementToNextCombination() {
		
		if (currentCombinationStatus == null) {
			return;
		}
		
		if (isLastCombinationAlreadyReturned()) {
			isAllCombinationsDone = true;
			return;
		}
		
		for (int i = currentCombinationStatus.size() - 1;i >= 0;i--) {
			if (currentCombinationStatus.get(i)) {
				currentCombinationStatus.set(i, false);
			}
			else {
				currentCombinationStatus.set(i, true);
				break;
			}
		}
		
		
		
	}
	
	private boolean isLastCombinationAlreadyReturned() {
		if (currentCombinationStatus == null) {
			return true;
		}
		
		for (int i = 0;i < currentCombinationStatus.size();i++) {
			if (!currentCombinationStatus.get(i)) {
				return false;
			}
		}
		
		return true;
	}
}
