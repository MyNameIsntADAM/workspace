package com.sorting.main;

import java.util.Scanner;

public class SortMain {
	
	static Sort sort;
	
	private static String prompt = 
			"          +===================================================+\n" + 
			"          |  Sorting Algorithms: Quick, Bubble, and Selection |\n" + 
			"          +===================================================+\n" + 
			"          | G: Generate a list of random integers given a     |\n" + 
			"          |    size, max, and min.                            |\n" + 
			"          +---------------------------------------------------+\n" + 
			"          | B: Sort the array with a bubble sort.             |\n" + 
			"          +---------------------------------------------------+\n" + 
			"          | Q:	Sort the array with a quick sort.             |\n" + 
			"          +---------------------------------------------------+\n" + 
			"          | S: Sort the array with a selection sort.          |\n" + 
			"          +---------------------------------------------------+\n" + 
			"          | P: Print all integers in the sorted array.        |\n" + 
			"          +---------------------------------------------------+\n" + 
			"          | U: Print all integers in the unsorted array.      |\n" + 
			"          +---------------------------------------------------+\n" + 
			"          | H/?: Display this menu.                           |\n" + 
			"          | E  : Exit                                         |\n" + 
			"          +===================================================+";
	
	private static void generate(Scanner scan) {
		System.out.print("Enter how many numbers you would like to generate: ");
		int size = scan.nextInt();
		System.out.print("Enter the MINIMUM integer you want to be randomly generated: ");
		int min = scan.nextInt();
		System.out.print("Enter the MAXIMUM integer you want to be randomly generated: ");
		int max = scan.nextInt();
		sort = new Sort(size, min, max);
		System.out.printf("\nGenerated %d integers and added them into the unsorted array and sorted array. \n", size);
	}
	
	private static void bubbleSort() {
		if(sort != null) {
			sort.bubbleSort();
			System.out.println("Successfully sorted the array with a bubble sort.");
		}
		else System.out.println("You must sort the array first! Type 'H' to see a list of sorts.");
	}
	
	private static void selectionSort() {
		if(sort != null) {
			sort.selectionSort();
			System.out.println("Successfully sorted the array with a selection sort.");
		}
		else System.out.println("You must sort the array first! Type 'H' to see a list of sorts.");
	}
	
	private static void quickSort() {
		if(sort != null) {
			sort.quickSort();
			System.out.println("Successfully sorted the array with a quick sort.");
		}
		else System.out.println("You must sort the array first! Type 'H' to see a list of sorts.");
	}
	
	private static void search(Scanner scan) {
		if(sort == null) {
			System.out.println("You must initialize the array first. Press 'g' to initialize.");
			return;
		}
		System.out.println("Enter a number you would like to\nsearch for using linear search: ");
		int input = scan.nextInt();
		int pos = Search.linearSearch(input, sort.getSortedArray());
		if(pos >= 0) {
			System.out.printf("\nThe number %d was found at position %d.\n", input, pos);
		}
		else System.out.printf("%d was not found in the array.\n", input);
	}
	
	private static void binary(Scanner scan) {
		if(sort == null) {
			System.out.println("You must initialize the array first. Press 'g' to initialize.");
			return;
		}
		System.out.println("Enter a number you would like to\nsearch for using binary search: ");
		int input = scan.nextInt();
		int pos = Search.binarySearch(input, sort.getSortedArray());
		if(pos >= 0) {
			System.out.printf("\nThe number %d was found at position %d.\n", input, pos);
		}
		else System.out.printf("%d was not found in the array.\n", input);
	}
	
	private static void printUnsorted() {
		System.out.println("\nUnsorted array: ");
		int c = 0;
		for(int i : sort.getUnsortedArray()) {
			System.out.print(i + " ");
			c++;
			if(c % 20 == 0) System.out.println();
		}
		System.out.println();
	}
	
	private static void printSorted() {
		System.out.println("\nSorted array: ");
		int c = 0;
		for(int i : sort.getSortedArray()) {
			System.out.print(i + " ");
			c++;
			if(c % 20 == 0) System.out.println();
		}
		System.out.println();
	}
	
	private static void help() {
		System.out.println(prompt);
	}
	
	static void run() {
		System.out.println("Enter H/h/? for help, or command :");
		Scanner scan = new Scanner(System.in);
		char curr = scan.nextLine().toLowerCase().charAt(0);
		while(curr != 'e') {
			switch(curr) {
			case 'h': help(); break;
			case 'g': generate(scan); break;
			case 'b': bubbleSort(); break;
			case 's': selectionSort(); break;
			case 'q': quickSort(); break;
			case 'u': printUnsorted(); break;
			case 'p': printSorted(); break;
			case 'l': search(scan); break;
			case 'i': binary(scan); break;
			default: System.out.println("Unknown command");
			}
			curr = scan.next().charAt(0);
		}
	}
	
	public static void main(String[] args) {
		run();
	}

}
