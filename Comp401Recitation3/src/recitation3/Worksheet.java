package recitation3;

import java.util.Scanner;

public class Worksheet {

	public static void main(String[] args) {
		//Don't change the main method
				Scanner s = new Scanner(System.in);
				int size = s.nextInt();
				int[][] numbers = fill2DArray(size);
				twoDimensionalArrayToString(numbers);
				int max = findMax(numbers);
				int sum = findSum(numbers);
				int mode = findMode(numbers);
				System.out.println("Max: " + max);
				System.out.println("Sum: " + sum);
				System.out.println("Mode: " + mode);
	}
	
	public static int[][] fill2DArray(int size){
		int [][] arr = new int[size][size];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				arr[i][j] = (int)(10*Math.random());
				
			}
		}
		return arr;
	}
	
	public static int findMax(int[][] numbers) {
		//deliverable
		int max = 0;
		for(int i = 0; i < numbers.length; i++) {
			for(int j = 0; j < numbers[0].length; j++) {
				if (numbers[i][j] > max) {
					max = numbers[i][j];
				}
				}
			}
		return max;
	}
	
	public static int findSum(int[][] numbers) {
		//deliverable
		int sum = 0;
		for(int i = 0; i < numbers.length; i++) {
			for(int j = 0; j < numbers[i].length; j++) {
				sum = sum + numbers[i][j];
			}
			}
		return sum;
	}
	
	public static int findMode(int[][] numbers) {
		//deliverable
		// no idea how to do this
		int mode = 0;
		
		return mode;
	}
	
	public static void twoDimensionalArrayToString(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			arrayToString(arr[i]);
		}
	}
	
	public static void arrayToString(int[] arr) {
//	Loops through array and uses string concatenation to print out array values nicely
		String arrayToString = "{ ";
		for(int i = 0; i < arr.length; i++) {
				if(i == arr.length - 1) {
					arrayToString += arr[i] + " }";
				}else {
					arrayToString += arr[i] + ", ";
				}
		}
	System.out.println(arrayToString);
}

}

