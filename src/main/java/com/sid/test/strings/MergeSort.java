package com.sid.test.strings;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int[] unsortedList={3,2,6,4,8,1};
			int[] sortedList=mergeSort(unsortedList);
	}

	private static int[] mergeSort(int[] unsortedList) {
		// TODO Auto-generated method stub
		if(unsortedList.length==1){
			return unsortedList;
		}
		int midIdx=unsortedList.length/2;
		int[] halfArray1=new halfArray[midIdx];
		int[] halfArray2=new halfArray[unsortedList.length-midIdx];
		System.arraycopy(unsortedList, 0,halfArray1, 0,midIdx-1);
		
		int[] sortList1=mergeSort(System.arraycopy(src, srcPos, dest, destPos, length);unsortedList);
		int[] sortList2=mergeSort(unsortedList);
		return null;
	}

}
