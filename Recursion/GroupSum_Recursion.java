
public class GroupSum_Recursion {

	public static boolean groupSum(int start, int[] nums, int target) {

		if (start >= nums.length) {

			if (target == 0) {
				return true;

			} else
				return false;
		}

		if (groupSum(start + 1, nums, target - nums[start]))
			return true;
		if (groupSum(start + 1, nums, target))
			return true;

		return false;

	}

	public static void main(String[] args) {

		int[] nums = { 2, 4, 8 };
		int start = 0;
		int target = 10;

		System.out.println("output :" + groupSum(start, nums, target));

	}

}
