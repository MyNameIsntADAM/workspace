package structures;

import java.util.Scanner;

public class ReadFloat {
	
	private double midterm, hw, finalExam;
	private double midtermWeight, hwWeight, finalExamWeight;
	private double midtermPCT, hwPCT, finalExamPCT;
	private double finalGrade;

	public ReadFloat() {
		prompt();
		
		midtermPCT = midterm*midtermWeight/100;
		hwPCT = hw*hwWeight/60;
		finalExamPCT = finalExam*finalExamWeight/100;
		
		finalGrade = clamp(midtermPCT + hwPCT + finalExamPCT, 100, 0);
	
		System.out.println("Your final grade is: " + finalGrade + ". You earned an " + getGrade(clamp(finalGrade, 100, 0))  + " in the class!\n");
	}

	public double clamp(double num, double max, double min) {
		if(num >= max) {
			return	max;
		}
		if(num <= min) {
			return min;
		}
		return num;
	}
	
	public double getFinalGrade(double mid, double hw, double fin) {
		return clamp(mid + hw + fin, 100, 0);
	}

	public char getGrade(double percentage) {
		int point = (int)Math.round(percentage)/10;
		System.out.println(point);
		switch(point) {
			case 10:
			case 9: return 'A';
			case 8: return 'B'; 
			case 7: return 'C'; 
			case 6: return 'D';
		}
		return 'F';
	}

	public void prompt() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nEnter the midterm, homework, and final exam weights: \n\nMidterm weight percentage: ");
		midtermWeight = clamp(scan.nextDouble(), 100, 0);
		
		System.out.println("Homework weight percentage: ");
		hwWeight = clamp(scan.nextDouble(), 100, 0);
		
		System.out.println("Final exam weight percentage: ");
		finalExamWeight = clamp(scan.nextDouble(), 100, 0);
		
		System.out.println("Midterm Grade (Out of 100): ");
		midterm = clamp(scan.nextDouble(), 100, 0);
		
		System.out.println("Homework Grade (Out of 60): ");
		hw = clamp(scan.nextDouble(), 60, 0);
		
		System.out.println("Final Exam Grade (Out of 100): ");
		finalExam = clamp(scan.nextDouble(), 100, 0);
		
		scan.close();
	}
	
	public static void main(String[] args) {
		new ReadFloat();
	}

}
