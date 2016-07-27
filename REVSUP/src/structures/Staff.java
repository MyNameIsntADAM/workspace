package structures;

public class Staff extends Employee {
	
	protected String jobTitle;

	public Staff() {
		super();
	}
	
	public void generate() {
		super.generate();
		jobTitle = Names.position[(int)(Math.random()*Names.position.length)];
	}
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean bool) {
		return super.toString(bool) + String.format(" %5s", jobTitle);
	}
	
	public String htmlRow(String color) {
		return "<tr>" + htmlColumns() + "</tr>";
	}
	
	public String htmlColumns() {
		return super.htmlColumns() + "<td>" + String.format("%s", jobTitle) + "</td>";
	}
	
}
