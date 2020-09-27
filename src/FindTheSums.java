/*
 * FindTheSums.java
 * Author:  Joseph Nguyen 
 * Submission Date:  4/20/2020
 *
 * Purpose: The purpose of this program is to make a class with methods that can turn the array into string format
 * and finds out if adjacent values adds up to a sum specified by user.
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing 
 * or posting of source code for this assignment is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia.  
 */

public class FindTheSums {

	//copys the parameter array into a new array
	public static int[][] copyArray(int[][] a) {
		int[][] returnArray = new int[a.length][a[0].length];
		for (int row = 0; row < a.length; row++) {
			for (int column = 0; column < a[row].length; column++) {
				returnArray[row][column] = a[row][column];
			}
		}
		return returnArray;
	}

	//turns the array into a string format
	public static String arrayToString(int[][] a) {
		String toString = "";
		for (int row = 0; row < a.length; row++) {
			for (int column = 0; column < a[row].length; column++) {
				toString += a[row][column];
				if (!(column == a[row].length - 1)) {
					toString += " ";
				}
			}
			if (!(row == a.length - 1)) {
				toString += "\n";
			}
		}
		return toString;
	}

	//finds horizontal adjacent values in each row and sees if it adds up to the specified user input
	public static int[][] horizontalSums(int[][] a, int sumToFind) {
		int[][] horizontalSumArray = copyArray(a);
		for(int row = 0; row < horizontalSumArray.length; row++) {
			int sum = 0;
			int start = 0;
			int indexToKeep = -1;
			for (int column = 0; column < horizontalSumArray[row].length; column++) {
				sum += horizontalSumArray[row][column];
				if (sum == sumToFind) {
					indexToKeep = column;
					start++;
					column = start - 1;
					sum = 0;
				}
				else if (sum > sumToFind) {
					if (start > indexToKeep) {
						horizontalSumArray[row][start] = 0;
					}
					start++;
					column = start - 1;
					sum = 0;
				}
				else if (sum < sumToFind && column == horizontalSumArray[row].length - 1) {
					if (start > indexToKeep) {
						for (int i = start; i < horizontalSumArray[row].length; i++) {
							horizontalSumArray[row][i] = 0;
						}
					}
					else {
						start++;
						column = start - 1;
						sum = 0;
					}
				}
			}

		}
		return horizontalSumArray;

	}

	//finds vertical adjacent values in each column and sees if it adds up to the specified user input
	public static int[][] verticalSums(int[][] a, int sumToFind) {
		int[][] verticalSums = copyArray(a);
		for(int column = 0; column < verticalSums[0].length; column++) {
			int sum = 0;
			int start = 0;
			int indexToKeep = -1;
			for (int row = 0; row < verticalSums.length; row++) {
				sum += verticalSums[row][column];
				if (sum == sumToFind) {
					indexToKeep = row;
					start++;
					row = start - 1;
					sum = 0;
				}
				else if (sum > sumToFind) {
					if (start > indexToKeep) {
						verticalSums[start][column] = 0;
					}
					start++;
					row = start - 1;
					sum = 0;
				}
				else if (sum < sumToFind && row == verticalSums.length - 1) {
					if (start > indexToKeep) {
						for (int i = start; i < verticalSums.length; i++) {
							verticalSums[i][column] = 0;
						}
					}
					else {
						start++;
						row = start - 1;
						sum = 0;
					}
				}
			}

		}
		return verticalSums;

	}

}
