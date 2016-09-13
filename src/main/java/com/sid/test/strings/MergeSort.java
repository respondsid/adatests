package com.sid.test.strings;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] unsortedList = { 3, 2, 6, 4, 8, 1 };
		int[] sortedList = mergeSort(unsortedList);
		System.out.println("Sorted List ::");
		for(int i:sortedList){
			System.out.println(i);
		}
	}

	private static int[] mergeSort(int[] unsortedList) {
		// TODO Auto-generated method stub
		if (unsortedList.length == 1) {
			return unsortedList;
		}
		int midIdx = unsortedList.length / 2;
		int[] halfArray1 = new int[midIdx];
		int[] halfArray2 = new int[unsortedList.length - midIdx];
		System.arraycopy(unsortedList, 0, halfArray1, 0, halfArray1.length);
		System.arraycopy(unsortedList, midIdx, halfArray2, 0, halfArray2.length);
		int[] leftList = mergeSort(halfArray1);
		int[] rightList = mergeSort(halfArray2);
		int sortedArray[] = mergeSortedArrays(leftList, rightList, unsortedList);
		return sortedArray;
	}

	private static int[] mergeSortedArrays(int[] leftList, int[] rightList, int[] unsortedList) {
		int l = 0, r = 0, i = 0;
		while (l < leftList.length && r < rightList.length) {
			if (leftList[l] > rightList[r]) {
				unsortedList[i] = rightList[r];
				r++;
			} else {
				unsortedList[i] = leftList[l];
				l++;
			}
			i++;
		}
		while (l < leftList.length) {
			unsortedList[i] = leftList[l];
			l++;
			i++;
		}
		while (r < rightList.length) {
			unsortedList[i] = rightList[r];
			r++;
			i++;
		}

		return unsortedList;
	}

}
