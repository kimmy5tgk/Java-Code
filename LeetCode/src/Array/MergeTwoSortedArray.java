package Array;

import java.util.Arrays;

public class MergeTwoSortedArray {

	// Solution 1, Return new array, Time O(m+n), Space O(m+n),
	// m and n are the lengths of two arrays
	public static int[] mergeSortedArray(int[] a, int[] b) {
		int[] res = new int[a.length + b.length];
		int i = 0, j = 0, k = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j])
				res[k++] = a[i++];
			else
				res[k++] = b[j++];
		}
		while (i < a.length)
			res[k++] = a[i++];
		while (j < b.length)
			res[k++] = b[j++];

		return res;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Solution 2, merge in place
		int a1[] = { 0, 4, 5, 19, 21, 33, 36, 38, 61, 0, 0, 0, 0, 0 };

		System.out.println("Array 1:" + Arrays.toString(a1));

		int b1[] = { 1, 2, 7, 30, 40 };

		System.out.println("Array 2:" + Arrays.toString(b1));

		System.out.println("Merge in place : " + Arrays.toString(mergeSortedArray(a1, b1)));

		
	
	}

}
