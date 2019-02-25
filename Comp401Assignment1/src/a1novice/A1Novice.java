package a1novice;

import java.util.Scanner;

public class A1Novice {

	// Do not change the main method.	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		process(s);
	}
	
	public static void process(Scanner s) {
		// Put your code here.
		int loop = s.nextInt();
		String output = "";
		for( int i = 0; i <= loop; i++ ) {
			String firstName = s.next();
			String lastName = s.next();
			double assingmentGrade = s.nextDouble();
			double participationGrade = s.nextDouble();
			double midtermGrade = s.nextDouble();
			double finalGrade = s.nextDouble();
			char initial = firstName.charAt(0);
			double weightedAverage =  0;
			weightedAverage = weightedAverage + (assingmentGrade * .4);
			weightedAverage = weightedAverage + (participationGrade * .15);
			weightedAverage = weightedAverage + (midtermGrade * .2);
			weightedAverage = weightedAverage + (finalGrade * .25);
			
			String grade = "";
		if (weightedAverage < 60) 
			grade = "F";
		else if (weightedAverage < 65 && weightedAverage >= 60) 
			grade = "D";
		else if (weightedAverage < 70 && weightedAverage >= 65) 
			grade = "D+";
		else if (weightedAverage < 73 && weightedAverage >= 70) 
			grade = "C-";
		else if (weightedAverage < 76 && weightedAverage >= 73) 
			grade = "C";
		else if (weightedAverage < 80 && weightedAverage >=  76) 
			grade = "C+";
		else if (weightedAverage < 83 && weightedAverage >= 80) 
			grade = "B-";
		else if (weightedAverage < 86 && weightedAverage >= 83) 
			grade = "B";
		else if (weightedAverage < 90 && weightedAverage >= 86) 
			grade = "B+";
		else if (weightedAverage < 94 && weightedAverage >= 90) 
			grade = "A-";
		else if (weightedAverage >= 94) 
			grade = "A";
		output = (initial +". " + lastName + " " + grade);
		System.out.println(output);
		}
		
	}	
}
