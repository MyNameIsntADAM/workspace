package structures;

import java.util.Iterator;
import java.util.Scanner;

import structures.GeneralList.GLIterator;

public class StructuresMain {
	
	private static Queue<Member> mq;
	private static Stack<Member> ms;
	private static SortedQueue<Member> msq;
	private static boolean forward = true;
	//private SortedQueue<Member> memSortedQueue = new SortedQueue<Member>();
	
	private static String prompt = "          +===================================================+\n" + 
			"          |    CS 394 Assignment:   Linked List Structures    | \n" + 
			"          +===================================================+\n" + 
			"          | G: Ask for a N, and generate N members of mixed   |\n" + 
			"          |     kinds and put them into three list structures.|\n" + 
			"          |     Make sure you destroy the lists before        |\n" + 
			"          |     creating new ones if the lists are not empty. |\n" + 
			"          +---------------------------------------------------+\n" + 
			"          | R: Ask for boolean value (true/false) set iterator|\n" + 
			"          |    directoion to forward or backward.             | \n" + 
			"          +---------------------------------------------------+\n" + 
			"          | S: List members in stack, 1 memebr per line,      |\n" + 
			"          |     20 members per screen with header line, allow |\n" + 
			"          |     Q/q to quit listing after each 20 members.    |\n" + 
			"          +---------------------------------------------------+\n" + 
			"          | Q: List members in queue (same requirements).     |\n" + 
			"          +---------------------------------------------------+\n" + 
			"          | O: List members in ordered queue sorted by SSN    |\n" + 
			"          |    (same requirements).                           |\n" + 
			"          |                                                   |\n" + 
			"          +---------------------------------------------------+\n" + 
			"          | D: Remove first element from queue, pop member    |\n" + 
			"          |    from stack, and delete the same member from    |\n" + 
			"          |    sorted queue as the one removed from stack.    |\n" + 
			"          |                                                   |\n" + 
			"          +---------------------------------------------------+\n" + 
			"          | I: Randomly generate new member, and put          |\n" + 
			"          |    the object into the three structures. Print    |\n" + 
			"          |    out the new member added in.                   |\n" + 
			"          +---------------------------------------------------+\n" + 
			"          | H/?: Display this menu.                           |\n" + 
			"          | E  : Exit                                         |\n" + 
			"          +===================================================+";
	
	static void help() {
		System.out.println(prompt);
	}
	
	static void generate(Scanner scan) {
		System.out.print("Enter how many members you would like to generate: ");
		int size = scan.nextInt();
		fillAllLists(size);
		System.out.printf("Generated %d members.\n", size);
	}
	
	static void fillAllLists(int size) {
		mq = new Queue<Member>();
		ms = new Stack<Member>();
		msq = new SortedQueue<Member>();
		for(int i = 0; i < size; i++) {
			int rnd = (int)(Math.random()*5);
			switch(rnd) {
			case 0: addSomething(new Member()); break;
			case 1: addSomething(new Student()); break;
			case 2: addSomething(new Employee()); break;
			case 3: addSomething(new Staff()); break;
			case 4: addSomething(new Faculty()); break;
			default: addSomething(new Member());
			}
		}
	}
	
	static void addSomething(Member m) {
		mq.enqueue(m);
		ms.push(m);
		msq.enqueue(m);
	}
	
	static void printAddSomething(Member m) {
		addSomething(m);
		System.out.printf("Added %s to the current queue and stack. \n", m.getFullName());
	}
	
	static void reverse() {
		forward = !forward;
		if(!forward) {
			System.out.println("Iterator direction is now backward.");
		}
		else {
			System.out.println("Iterator direction is now forward.");
		}
	}
	
	static void printStack(Scanner scan) {
		if(ms == null) {
			System.out.println("You must initialize the Stack first! Press 'g' to initialize each list.");
		}
		scan = new Scanner(System.in);
		boolean check = true;
		boolean increment = true;
		GLIterator itr = ms.iterator(forward);
		int i = 1;
		int j = 1;
		while(check && itr.hasNext()) {
			System.out.println(itr.next());
			if(ms.size() - j <= 0) {
				System.out.printf("\nPrinted out %d members.\n", ms.size());
			}
			else if(increment && check && i % 20 == 0) {
				System.out.printf("Printed 20 members. There are %d members unprinted. Would"
						+ " you like to print more members? (Y)es/(N)o/Print (A)ll: \n", ms.size() - i);
				char input = scan.next().toLowerCase().charAt(0);
				switch(input) {
				case 'y': break;
				case 'n': System.out.println("Stopped printing Queue.");check = false; break;
				case 'a': increment = false; break;
				default: break;
				}
			}
			if(increment) i++;
			j++;
		}
	}
	
	static void printQueue(Scanner scan) {
		if(ms == null) {
			System.out.println("You must initialize the Queue first! Press 'g' to initialize each list.");
		}
		scan = new Scanner(System.in);
		boolean check = true;
		boolean increment = true;
		GLIterator itr = mq.iterator(forward);
		int i = 1;
		int j = 1;
		while(check && itr.hasNext()) {
			System.out.println(itr.next());
			if(mq.size() - j <= 0) {
				System.out.printf("\nPrinted out %d members.\n", mq.size());
			}
			else if(increment && check && i % 20 == 0) {
				System.out.printf("Printed 20 members. There are %d members unprinted. Would"
						+ " you like to print more members? (Y)es/(N)o/Print (A)ll: \n", mq.size() - i);
				char input = scan.next().toLowerCase().charAt(0);
				switch(input) {
				case 'y': break;
				case 'n': System.out.println("Stopped printing Queue.");check = false; break;
				case 'a': increment = false; i = mq.size(); break;
				default: break;
				}
			}
			if(increment) i++;
			j++;
		}
	}
	
	static void printSortedQueue(Scanner scan) {
		if(msq == null) {
			System.out.println("You must initialize the SortedQueue first! Press 'g' to initialize each list.");
		}
		scan = new Scanner(System.in);
		boolean check = true;
		boolean increment = true;
		GLIterator itr = msq.iterator(forward);
		int i = 1;
		int j = 1;
		while(check && itr.hasNext()) {
			System.out.println(itr.next());
			if(msq.size() - j <= 0) {
				System.out.printf("\n Printed out %d members.\n", msq.size());
			}
			else if(increment && check && i % 20 == 0) {
				System.out.printf("Printed 20 members. There are %d members unprinted. Would"
						+ " you like to print more members? (Y)es/(N)o/Print (A)ll: \n", msq.size() - i);
				char input = scan.next().toLowerCase().charAt(0);
				switch(input) {
				case 'y': break;
				case 'n': System.out.println("Stopped printing Queue.");check = false; break;
				case 'a': increment = false; i = msq.size(); break;
				default: break;
				}
			}
			if(increment) i++;
			j++;
		}
	}
	
	static void removeSomething() {
			if(mq.size() <= 0 || ms.size() <= 0) return;
			Member m = mq.dequeue();
			String name1 = m.getFullName();
			String name2 = ms.pop().getFullName();
			String name3 = msq.remove(m).getFullName();
			System.out.printf("Dequeued %s from the Queue and SortedQueue respectively. Popped %s from the Stack. %s", name1, name2);
	}
	
	static void printSizes() {
		System.out.println("MQ: "+ mq.size() + " MS: " + ms.size() + " MSQ:" + msq.size());
	}

	static void run() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter H/h/? for help, or command: ");
		char curr = scan.next().toLowerCase().charAt(0);
		while(curr != 'e') {
			switch(curr) {
			case 'h': help(); break;
			case 'g': generate(scan); break;
			case 'r': reverse(); break;
			case 's': printStack(scan); break;
			case 'o': printSortedQueue(scan); break;
			case 'q': printQueue(scan); break;
			case 'd': removeSomething(); break;
			case 'i': printAddSomething(new Member()); break;
			case '?': help(); break;
			case 'j': printSizes(); break;
			default: System.out.println("Unknown command");
			}
			curr = scan.next().charAt(0);
		}
	}
	
	public static void main(String[] args) {
		run();
	}
	
}
