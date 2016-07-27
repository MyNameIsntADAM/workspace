package com.sorting.main;

public class InsertionSort {

	int[] arr;
	int size;
	int maxInt;
	
	public InsertionSort(int size, int max) {
		this.size = size;
		arr = new int[size];
		maxInt = max + 1;
		for(int i = 0; i < size; i++) {
			this.arr[i] = (int)(Math.random()*maxInt);
		}
		System.out.println("============= Unsorted =============");
		for(int c : arr) {
			System.out.print(c + " ");
		}
		System.out.println();
		this.arr = insertSort(arr);
		System.out.println("============== Sorted ==============");
		for(int c : arr) {
			System.out.print(c + " ");
		}
	}
	
	public int[] insertSort(int[] list) {
		for(int i = 1; i < list.length; i++) {
			int curr = list[i];
			int k;
			for(k = i - 1; k >= 0 && list[k] > curr; k--) {
				list[k + 1] = list[k];
			}
			list[k + 1] = curr;
		}
		return list;
	}
	
}
