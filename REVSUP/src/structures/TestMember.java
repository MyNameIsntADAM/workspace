package structures;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class TestMember {
	
	static Member[] ms;
	static String color = "#d3d3d3";
	
	private static String prompt = "\t\t================ CS 394 Assignment 1 ===============\r\n" + 
			"		G/g  : Ask for a N, and generate N members of mixed\r\n" + 
			"                       Member class's objects, and store in a Vector \r\n" + 
			"		       and a array Objects.\r\n" + 
			"\r\n" + 
			"		S/s  : Sort the members in the vector and array in\r\n" + 
			"                       ascending order.\r\n" + 
			"\r\n" +
			"		P/p  : Print out a list of each member.\r\n\n" +
			"		V/v  : Show the members in the vector and array.\r\n" + 
			"\r\n" + 
			"		O/o  : Save objects inside vector into a HTML file\r\n" + 
			"		       with objects saved in the format of HTML\r\n" + 
			"		       Table.\r\n" + 
			"		F/f  : Show HTML file contents on screen.\r\n\n" + 
			"\r\n" + 
			"		L/l  : Launch the default internet browser to\r\n" + 
			"		       display the generated HTML file.\r\n" + 
			"		--------------------------------------------------\r\n" + 
			"		H/h/?: Display this menu.\r\n" + 
			"		E/e  : Exit\r\n" + 
			"		=================================================";
	
	static void help() {
		System.out.println(prompt);
	}
	
	static void sortMembers() {
		if(ms != null) {
			Arrays.sort(ms);
			System.out.println("Successfully sorted list of members by ID.");
		}
		else System.out.println("You haven't initialized the list of members yet! Press 'g' to initialize.");
	}
	
	static void generate(Scanner scan) {
		System.out.print("Enter how many members you would like to create: ");
		int numMembers = scan.nextInt();
		fill(numMembers);
		System.out.printf("Successfully stored %d members.\n", numMembers);
	}
	
	static void fill(int size) {
		ms = new Member[size];
		for(int i = 0; i < size; i++) {
			int rand = (int)(Math.random()*3);
			switch(rand) {
			case 0: ms[i] = new Student(); break;
			case 1: ms[i] = new Faculty(); break;
			case 2: ms[i] = new Staff(); break;
			default: ms[i] = new Member();
			}
		}
	}
	
	static void printMembers() {
		System.out.println();
		System.out.println();
		if(ms == null) {
			System.out.println("You haven't initialized the members list yet! Press 'g' to initialize.");
		}
		else {
			for(int i = 0; i < ms.length; i++) {
				if(ms[i] != null) System.out.printf("%05d %s\n", i + 1, ms[i].toString(true));
			}
			System.out.println();
			System.out.println();
		}
	}
	
	static void printMembersArray() {
		if(ms == null) System.out.println("You haven't initialized the members list yet! Press 'g' to initialize.");
		else {
			System.out.println(ms);
		}
	}
	
	static void createHTMLFile(String fileName) {
		if(ms == null) {
			System.out.println("You haven't initialized the members list yet! Press 'g' to initialize.");
			return;
		}
		FileWriter fWriter;
		BufferedWriter bWriter;
		try {
			fWriter = new FileWriter(fileName);
			bWriter = new BufferedWriter(fWriter);
			bWriter.write(createHTMLText());
			bWriter.newLine();
			bWriter.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.printf("Successfully saved to %s\n", fileName);
	}
	
	static String createHTMLText() {
		String html = "<table><tr bgcolor=\"#d3d3d3\"><td>ID</td><td>Last Name</td><td>First Name</td></tr>";
		for(int i = 0; i < ms.length; i++) {
			html += ms[i].htmlRow(color);
		}
		return html + "</table>";
	}
	
	static void printHTMLFile(String fileName) {
		FileReader fReader;
		BufferedReader bReader;
		try {
			fReader = new FileReader(fileName);
			bReader = new BufferedReader(fReader);
			for(String line; (line = bReader.readLine()) != null;) {
				System.out.print(line);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static void launchHTMLFile(String fileName) {
		if(Desktop.isDesktopSupported()) {
			try {
				File file = new File(fileName);
				Desktop.getDesktop().browse(file.toURI());
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	static void run() {
		Scanner scan = new Scanner(System.in);
		char curr = scan.nextLine().toLowerCase().charAt(0);
		while(curr != 'e') {
			switch(curr) {
			case 'h': help(); break;
			case 'g': generate(scan); break;
			case 's': sortMembers(); break;
			case 'p': printMembers(); break;
			case 'v': printMembersArray(); break;
			case 'o': createHTMLFile("members.html"); break;
			case 'f': printHTMLFile("members.html"); break;
			case 'l': launchHTMLFile("members.html"); break;
			case '?': help(); break;
			case ':': break;
			default: System.out.println("Unknown command");
			}
			curr = scan.next().charAt(0);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("\n\n\n\n\nEnter H/h/? for help, or command :");
		run();
	}
	
}
