package com.sorting.main;

public class Search {

	public static int linearSearch(int find, int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(find == arr[i]) return i;
		}
		return -1;
	}
	
	public static int binarySearch(int find, int[] arr) {
		int high = arr.length - 1;
		int low = 0;
		while(low <= high) {
			int mid = (low + high)/2;
			if(find < arr[mid]) high = mid - 1;
			else if(find > arr[mid]) low = mid + 1;
			else return mid;
		}
		return -1;
	}
	
}
