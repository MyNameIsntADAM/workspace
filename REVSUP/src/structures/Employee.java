package structures;

import java.util.Calendar;

public class Employee extends Member {

	protected String department;
	protected int yearHired;
	
	public Employee() {
		super();
	}
	
	public void generate() {
		super.generate();
		int currYear = Calendar.getInstance().get(Calendar.YEAR);
		department = Names.department[(int)(Math.random()*Names.department.length)];
		yearHired = (int)(Math.random()*(currYear - 1965 + 1)) + 1965;
	}
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean bool) {
		return super.toString(bool) + String.format("%-14s %-4d", department, yearHired);
	}
	
	public String htmlRow(String color) {
		return "<tr>" + htmlColumns() + "</tr>";
	}
	
	public String htmlColumns() {
		return super.htmlColumns() + "<td>" + String.format("%s", department) + " </td>" + "<td colspan=2>" + yearHired + "</td>";
	}
	
	
}
