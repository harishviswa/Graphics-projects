//Harish Viswa
//ITCS
//01.14.21
//ITCS - Array Practice

//TODO: Complete each method and test
public class ArrayPractice {

	/* TODO:
	 * Traverse through the given array, nums
	 * Use System.out.print() to print each element of the array separated by a space
	 * Remember to use System.out.println() once at the very end to ready the console for new output
	 * Sample Output:
	 * 2 4 6 8 10 11 12
	 */
	private static void printArray(int[] nums) {
		for(int num: nums){
			System.out.println(num);
		}
	}
	
	/* TODO:
	 * Given an array, nums, swap the position of the first and last element
	 * Ex.
	 * {2, 4, 6, 8} --> {8, 4, 6, 2}
	 * 
	 * Call printArray() passing in nums to verify that your code is correct
	 */
	private static void swapFirstLast(int[] nums) {
		
		int last = nums[nums.length - 1];
		int first = nums[0];
		nums[0] = last;
		nums[nums.length - 1] = first;
		
		System.out.println("Array with first and last values swapped: ");
		printArray(nums);
		
	}
	
	/*TODO:
	 * Given an array, nums, calculate and print the average of the values in the array
	 * Ex.
	 * {84, 92, 61, 89, 99, 74} --> 83
	 */
	private static void findAverage(int[] nums) {
		int sum = 0;
		for(int num: nums){
			sum += num;
		}
		sum /= nums.length;
		System.out.println("Average of nums array: " + sum);
	}
	
	/* TODO:
	 * Given an array, nums, find and return the INDEX OF
	 * the smallest number in the array
	 * Ex.
	 * {84, 92, 61, 89, 99, 74} --> 2
	 */
	private static void findSmallest(int[] nums) {
		int lowest = nums[0];
		int lowestIndex = 0;
		for(int i = 1; i < nums.length; i++){
			if(lowest > nums[i]){
				lowest = nums[i];
				lowestIndex = i;
			}
		}
		System.out.println("Index of smallest value in array: " + lowestIndex);
	}
	
	
	/* TODO:
	 * Extension
	 * Given an array, nums, print "In Order" if the elements of the array are in ascending order.
	 * Print "Not In Order" otherwise. 
	 * Ex.
	 * {1, 5, 9, 9, 10, 50} -> In order
	 * {9, 3, 5, 10, 50, 25} -> Not In Order
	 * 
	 * Note: you may need to create your own array in main to test this
	 * 		 as the given array will very rarely be in order. 
	 */	
	public static void isInOrder(int[] nums) {
		int first = nums[0];
		boolean order = true;
		for(int num: nums){
			if(first > num){
				order = false;
			}
		}
		if(order){
			System.out.println("In Order");
		}
		else{
			System.out.println("Not In Order");
		}
	}
	//Creates two test arrays
	//TODO: Call your methods to test them
	public static void main(String[] args) {
		//Generates a test array of variable size and values. 
		int[] testArray = new int[(int) (Math.random() * 7 + 3)];
		for (int i = 0; i < testArray.length; i++) {
			testArray[i] = (int) (Math.random() * 25);
		}
		
//		int[] testArray2 = {1,2,3,4,5};
		
		// TODO: call your methods here
		// Start by printing the array so we can see what values are in it
		printArray(testArray);
		swapFirstLast(testArray);
		findAverage(testArray);
		findSmallest(testArray);
		isInOrder(testArray);
		
		
	}

}
