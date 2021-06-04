package Array;

import java.util.Arrays;

public class DuplicateZero {

	public static int [] duplicatesZeros(int[] arr) {

		int[] array = arr;
		int possibleDups = 0;
		int length = array.length - 1;

		// Find the number of zeros to be duplicated
		// Stopping when left points beyond the last element in the original array
		// which would be part of the modified array

		for (int left = 0; left <= length - possibleDups; left++) {
			// count the zeros
			if (array[left] == 0) {
				// Edge case: This zero can't be duplicated. We have no more space,
				// as left is pointing to the last element which could be included

				if (left == length - possibleDups) {
					// For this zero we just copy it without duplication
					array[length] = 0;
					length = length - 1;
					break;
				}
				possibleDups++;
			}
		}

		// Start backwards from the last element which would be part of new array
		int last = length - possibleDups;

		// Copy zero twice and non zero once
		for (int i = last; i >= 0; i--) {
			if (array[i] == 0) {
				array[i + possibleDups] = 0;
				possibleDups--;
				array[i + possibleDups] = 0;
			} else {
				array[i + possibleDups] = array[i];
			}
		}
		
		return array;
	}

	public static int [] duplicateZeros(int[] arr) {
		int [] array = arr;
		if (array == null || array.length == 0)
			return null;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				for (int j = array.length - 1; j > i; j--) {
					array[j] = array[j - 1];
				}
				i++; // we don't want to traverse over the duplicate zero
			}
			
		}
		return array;
		
	}

	public static void main(String[] args) {
		int arr[] = { 1, 0, 2, 0, 3, 4, 0, 5 };
		int arr1[] = { 1, 0, 2, 2, 0, 4, 0, 5 };

		System.out.println(Arrays.toString(duplicateZeros(arr)));
		System.out.println("------------------------------------");
		System.out.println(Arrays.toString(duplicatesZeros(arr1)));
	}
}
