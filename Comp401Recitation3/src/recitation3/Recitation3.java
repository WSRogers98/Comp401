package recitation3;

import java.util.Scanner;

/* Name: Wiliam Rogers
 * Onyen: 730149662
 * Recitation Code: 803901 I think i couldn't see it that well
 */
// I had a really hard time reading this even with the bigger font so this code is about to be rough
// this also went way to fast for me
public class Recitation3 {
	public static void main(String[] args) {
		
		Scanner s =  new Scanner(System.in);
		int size = s.nextInt();
	//	int [] arr = { 24, 234, 1000 };
	//	int [] arr2 = new int[3];
		
//		int[] array1 = fillarray(size);
//		arrayToString(array1);
//		
//		int[] sorted = sortIntArray(array1);
//		arrayToString(sorted);
		int[][] array = fillarray(size);
		twoDimensionalArrayToString(array);
	}

	
	
	
	public static int[][] fillarray(int size){
		int [][] arr = new int[size][size];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				arr[i][j] = (int)(10*Math.random());
				
			}
		}
		return arr;
	}
	
	
	
	
	
//	public static int[] fillarray(int size) {
//		int numbers[] = new int[size];
//		for (int i = 0; i > numbers.length; i ++) {
//			numbers[i] = (int)(10*Math.random());
//		}
//		return numbers;
//	}
//	
//	public static int[] clonearray(int[] arr) {
//	int clone[] = new int[arr.length];
//	for( int i=0; i < clone.length; i ++) {
//		
//	}
//	}
	public static void arrayToString(int[] arr) {
//		Loops through array and uses string concatenation to print out array values nicely
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
	
	public static int[] sortIntArray(int[]  arr) {
//		insertion sort algorithm used to sort numbers
		for(int i = 0; i < arr.length; i++) {
			for(int j = i; j > 0; j--) {
				if(arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
		return arr;
	}
	
	public static void twoDimensionalArrayToString(int[][] arr) {
//		loops through first array dimension and makes use of one dimensional print method to print out 2-d array
		for(int i = 0; i < arr.length; i++) {
			arrayToString(arr[i]);
		}
	}
}

