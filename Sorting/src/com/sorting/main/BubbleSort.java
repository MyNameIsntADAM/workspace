package com.sorting.main;

public class BubbleSort {

	int size, max;
	int[] arr;
	
	public BubbleSort(int s, int m) {
		size = s;
		max = m;
		arr = new int[s];
		for(int i = 0; i < s; i++) {
			arr[i] = (int)(Math.random()*m);
		}
		System.out.println("============= Unsorted ============");
		for(int c : arr) {
			System.out.print(c + " ");
		}
		System.out.println();
		arr = bubbleSort(arr);
		System.out.println("============= Sorted ==============");
		for(int c : arr) {
			System.out.print(c + " ");
		}
	}
	
	public static int[] bubbleSort(int[] list) {
		boolean needNextPass = true;
		for(int i = 0; i < list.length && needNextPass; i++) {
			needNextPass = false;
			for(int j = 0; j < list.length - i - 1; j++) {
				if(list[j] > list[j + 1]) {
					int temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
					needNextPass = true;
				}
			}
		}
		return list;
	}
	
}
