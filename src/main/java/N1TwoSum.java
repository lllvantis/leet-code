import java.util.Arrays;
import java.util.HashMap;

public class N1TwoSum {

    // region 1. two-sum
    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int pending = target - num;
            if (map.keySet().contains(pending)) return new int[]{i, map.get(pending)};
            map.put(num, i);
        }
        return new int[]{};
    }
    // endregion
    public static void main(String[] args) {
        final int[] ints = {1, 2, 3};
        System.out.println(Arrays.toString(new N1TwoSum().twoSum(ints, 3)));
    }
}
