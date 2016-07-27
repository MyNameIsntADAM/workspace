package hash;

import java.util.Scanner;

import structures.Member;

public class TestHash {
	HashTable<Member> members;
	String prompt = 
			"          +===================================================+\n" + 
			"          |  Hashtable Generator and Remover Application      |\n" + 
			"          +===================================================+\n" + 
			"          | G: Generate a list of random members given a size.|\n" + 
			"          +---------------------------------------------------+\n" + 
			"          | P: Print all members in the hashtable.            |\n" + 
			"          +---------------------------------------------------+\n" + 
			"          | C: Clear the entire hashtable.                    |\n" + 
			"          +---------------------------------------------------+\n" + 
			"          | R: Remove a member given a valid ID.              |\n" + 
			"          +---------------------------------------------------+\n" + 
			"          | V: Verify that all members are retrievable.       |\n" + 
			"          +---------------------------------------------------+\n" + 
			"          | H/?: Display this menu.                           |\n" + 
			"          | E  : Exit                                         |\n" + 
			"          +===================================================+";
	
	public TestHash() {
		Scanner scan = new Scanner(System.in);
		System.out.print(">> ");
		char in = scan.next().toLowerCase().charAt(0);
		while(in != 'e') {
			switch(in) {
			case 'h': help();
				break;
			case 'g': fill(scan);
				break;
			case 'p': print();
				break;
			case 'c': clear();
				break;
			case 'r': remove(scan);
				break;
			case 'v': verify();
				break;
			case '?': help();
				break;
			case 'f': fakeRemove(scan);
				break;
			default: System.out.println("Unknown command");
			}
			System.out.print(">> ");
			in = scan.next().toLowerCase().charAt(0);
		}
	}
	
	private void help() {
		System.out.println(prompt);
	}
	
	private void fill(Scanner scan) {
		System.out.print("Enter how many members to generate: ");
		int i = scan.nextInt(), j = i;
		members = new HashTable<>();
		while(i > 0) {
			members.put(new Member());
			i--;
		}
		System.out.println("Successfully generated hashtable with " + j + " members.");
	}
	
	private void print() {
		members.show();
	}
	
	private void clear() {
		System.out.println("Clearing hashtable.");
		members.clear();
		if(members.isEmpty()) {
			System.out.println("Hashtable cleared.");
		}
		else System.out.println("An unknown error has occurred. The hashtable was not successfully emptied.");
	}
	
	private void remove(Scanner scan) {
		if(members == null) {
			System.out.println("You must initiate the Hashtable first! Enter 'G' to generate.");
		}
		System.out.print("Enter the ID of the member you would like to remove from the table: ");
		long id = scan.nextLong();
		Member m = members.remove(new Member(id));
		if(m != null)
			System.out.println("Successfully removed " + m.getFullName() + " from the table.");
		else System.out.printf("Member with ID #%09d could not be found.\n", id);
	}
		
	private void verify() {
		int fails = members.verify();
		System.out.printf("%d %s unretrievable. %s is wrong with the code.\n", fails, fails == 1 ? "member was" : "members were", fails > 0 ? "Something" : 
			"Nothing");
	}
	
	private void fakeRemove(Scanner scan) {
		if(members == null) {
			System.out.println("You must initiate the Hashtable first! Enter 'G' to generate.");
		}
		System.out.print("Enter the POSITION of the member you would like to remove from the table: ");
		int pos = scan.nextInt();
		Member m = members.removeAt(pos);
		if(m != null)
			System.out.println("Successfully removed " + m.getFullName() + " from the table.");
		else System.out.printf("Member at position %09d could not be found.\n", pos);
	}
	
	public static void main(String[] args) {
		new TestHash();
	}
	
}
