package Array;

public class RemoveDuplicates {

	// two pointers i and j
	// i is the slow-runner while j is the fast-runner
	// as long as nums[i] = nums[j], we increment j to skip the duplicate

	// when nums[j] # nums[i], the duplicates run has ended
	// copy its value to nums[i+1], i is then incremented
	// repeating the same process again until j reaches the end of array
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}

	public static void main(String args[]) {
		int array[] = { 1, 1, 2 };
		int output = removeDuplicates(array);
		System.out.println(output);

	}
}
