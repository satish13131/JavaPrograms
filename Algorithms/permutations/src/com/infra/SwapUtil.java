package com.infra;

import java.util.List;

public class SwapUtil {
	
	public static <GenericObjectClass> void swap(int index1, int index2, List<GenericObjectClass> objectList) {
		if (objectList == null) {
			return;
		}
		
		if (index1 >= objectList.size() || index2 >= objectList.size()) {
			return;
		}
		
		GenericObjectClass object1 = objectList.get(index1);
		GenericObjectClass object2 = objectList.get(index2);
		
		objectList.remove(index2);
		objectList.add(index2, object1);
		
		objectList.remove(index1);
		objectList.add(index1, object2);
		
	}

}
