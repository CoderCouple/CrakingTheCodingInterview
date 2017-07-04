
public class GroupSum_Variation_Recursion {

	public static boolean groupSum(int start, int[] nums, int target, int sum) {

		if (start >= nums.length) {
			return (target == sum); 
		}

		return (groupSum(start + 1, nums, target, sum + nums[start]))
			|| groupSum(start + 1, nums, target, sum);
	}

	public static void main(String[] args) {
		int[] nums = { 2, 2, 5 };
		int start = 0;
		int target = 6; 
		int sum = 0;

		System.out.println("output :" + groupSum(start, nums, target, sum));

	}

}
