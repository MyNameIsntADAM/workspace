package structures;

import java.util.*;

public class Member implements Comparable<Member> {
	protected String firstName, lastName;
	protected long id;
	private List<Member> members = new LinkedList<Member>();
	//Should've been called an initializer
	public Member() {
		/*firstName = "John";
		lastName = "Doe";
		id = (int)(Math.random()*1000000000);
		*/
		generate();
	}

	public Member(Member m) {
		firstName = m.getFirstName();
		lastName = m.getLastName();
		id = m.getID();
	}

	public Member(String first, String last, long id) {
		firstName = first;
		lastName = last;
		this.id = id;
	}
	
	public String toString() {
		return toString(false);
	}

	public String toString(boolean bool) {
		return String.format("%s%03d-%02d-%04d %20s, %-20s", bool ? "MEM " : "" , id/1000000, id%1000000/10000, id%10000, lastName, firstName);	
	}

	public boolean equals(Member m) {
		if(m.getID() == id) return true;
		return false;
	}
	
	public int compareTo(Member m) {
		return (int)(id - m.getID());
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public long getID() {
		return id;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public void generate() {
		String fn = Names.firstName[(int)(Math.random()*Names.firstName.length)];	
		String ln = Names.lastName[(int)(Math.random()*Names.lastName.length)];
		long tempID = (int)(Math.random()*1000000000);
		//This is what Dr. Wang did.
		/*Random rnd = new Random();
		  long tempID = rnd.nextInt(999999999 - 10000000 + 1) + 10000000;
		  */
		//Use this to debug inside Member.java
		//members.add(new Member(fn, ln, tempID));
		firstName = fn;
		lastName = ln;
		id = tempID;
	}

	public int hashCode() {
		//return super.hashCode();
		return (int)id;
	}
	
	public String htmlRow(String color) {
		return "<tr bgcolor=" + color + ">" + htmlColumns() + "</tr>";
	}

	public String htmlColumns() {
		return "<td>" + String.format("%03d-%02d-%04d",  
				id / 1000000, id % 1000000 / 10000, id % 10000) + "</td>" + "<td>" + String.format("%s", lastName) + "</td>" + "<td>" + firstName + "</td>";
	}

	public void printMembers() {
		for(int i = 0; i < members.size(); i++) {
			System.out.println(members.get(i).toString(true) + " ");
		}
	}
}
