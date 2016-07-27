package com.sorting.main;

public class Sort {

	private int[] arr;
	private int[] uArr;
	
	public Sort(int size, int min, int max) {
		arr = new int[size];
		uArr = new int[size];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*(max - min + 1)) + min;
			uArr[i] = arr[i];
		}
	}
	
	public int[] getUnsortedArray() {
		return uArr;
	}
	
	public int[] getSortedArray() {
		return arr;
	}
	
	public void selectionSort() {
		for(int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			if(min > i) {
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
	}
	
	public void bubbleSort() {
		boolean needNextPass = true;
		for(int i = 0; i < arr.length && needNextPass; i++) {
			needNextPass = false;
			for(int j = 0; j < arr.length - i - 1; j++) {
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					needNextPass = true;
				}
			}
		}
	}
	
	public void quickSort() {
		quickSort(0, arr.length - 1);
	}
	
	public void quickSort(int low, int high) {
		int mid = (low + high)/2;
		int pivot = arr[mid];
		int i = low;
		int j = high;
		while(i <= j) {
			//Go from the left and find the index 'i' that points to a value greater than 'pivot'
			while(arr[i] < pivot) {
				i++;
			}
			while(arr[j] > pivot) {
				j--;
			}
			if(i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		if(low < j) {
			quickSort(low, j);
		}
		if(high > i) {
			quickSort(i, high);
		}
		
	}
	
}
