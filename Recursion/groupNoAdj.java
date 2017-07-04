
public class groupNoAdj {

	public static boolean groupSum(int start, int[] nums, int target) {

		if (start >= nums.length) {

			if (target == 0) {
				return true;

			} else
				return false;
		}

		if (groupSum(start + 1, nums, target-nums[start]))
			return true;
		if (nums[start]!=6)
			{
				if(groupSum(start + 1, nums, target))
					return true;
			}

		return false;

	}

	public static void main(String[] args) {
		int[] nums = { 8, 4, 4, 9, 6 };
		int start = 0;
		int target = 8;

		System.out.println("output :" + groupSum(start, nums, target));

	}

}
