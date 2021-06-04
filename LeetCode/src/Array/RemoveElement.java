package Array;



public class RemoveElement {

	public static int removeDuplicates(int[] arr, int n) {
		// Return, if array is empty
		// or contains a single element
		if (n == 0 || n == 1)
			return n;

		int[] temp = new int[n];

		// Start traversing elements
		int j = 0;
		for (int i = 0; i < n - 1; i++) {
			// If current element is not equal
			// to next element then store that
			// current element

			if (arr[i] != arr[i + 1])
				temp[j++] = arr[i];
		}

		// Store the last element as whether
		// it is unique or repeated, it hasn't
		// stored previously

		temp[j++] = arr[n - 1];

		// MOdify orginal array
		for (int i = 0; i < j; i++) {
			arr[i] = temp[i];
		}
		return j;
	}

	public static int removeElement(int[] arr, int val) {
		int array[] = arr;
		if (array == null || array.length == 0)
			return 0;

		int i = 0, j = array.length - 1;
		while (i <= j) {

			if (array[i] == val) {
				if (array[j] == val) {
					j--;
					continue;
				} else {
					array[i] = array[j];
					j--;

				}
			}
			i++;

		}
		return i;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 4, 2, 2, 4, 7, 5 };

		// System.out.println("After removing the given value : " + removeElement(arr,
		// 2));

		int n = arr.length;

		n = removeDuplicates(arr, n);

		// Print updated array
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");

	}

}
