package structures;

public class Faculty extends Employee {

	protected String degreeHeld;
	
	public Faculty() {
		super();
	}
	
	public void generate() {
		super.generate();
		degreeHeld = Names.degree[(int)(Math.random()*Names.degree.length)];
	}
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean bool) {
		return super.toString(bool) + String.format( " %-5s", degreeHeld);
	}
	
	public String htmlRow(String color) {
		return "<tr>" + htmlColumns() + "</tr>";
	}
	
	public String htmlColumns() {
		return super.htmlColumns() + "<td>" + String.format(" %5s", degreeHeld) + " </td>";
	}
	
}
