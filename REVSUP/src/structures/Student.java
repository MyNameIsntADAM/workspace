package structures;

public class Student extends Member {

	private String major;
	private double GPA;
	
	public Student() {
		super();
	}
	
	public void generate() {
		super.generate();
		this.GPA = (int)(Math.random()*450 + 1)/100.0f;
		this.major = Names.department[(int)(Math.random()*Names.department.length)];
	}
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean bool) {
		return super.toString(bool) + String.format("%-13.2f %s", GPA, major);
	}
	
	public String htmlRow(String color) {
		return "<tr>" + htmlColumns() + "</tr>";
	}
	
	public String htmlColumns() {
		return super.htmlColumns() + "<td>" + String.format("%4.2f", GPA) + " </td>" + "<td colspan=2>" + major + "</td>";
	}

}