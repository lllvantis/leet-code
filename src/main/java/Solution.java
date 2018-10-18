import java.util.*;

/**
 * @author vantis 闲舟江流夕照晚 =。= 2018/10/17
 * @version 1.0.0
 */
public class Solution {
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

    // region 2. add-two-numbers
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, false);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, boolean prevCarry) {
        boolean l1Null = null == l1;
        boolean l2Null = null == l2;
        if (l1Null && l2Null) {
            if (prevCarry) return new ListNode(1);
            return null;
        }

        int v1 = l1Null ? 0 : l1.val;
        int v2 = l2Null ? 0 : l2.val;
        int i = v1 + v2;
        if (prevCarry) i = i + 1;
        boolean carry = i >= 10;
        ListNode node = new ListNode(carry ? i - 10 : i);
        node.next = addTwoNumbers(l1Null ? null : l1.next, l2Null ? null : l2.next, carry);
        return node;
    }

    public static ListNode constructor(List<Integer> nums) {
        if (nums.isEmpty()) return null;
        Iterator<Integer> iterator = nums.iterator();
        Integer first = iterator.next();
        ListNode result = new ListNode(first);
        ListNode temp = result;
        while (iterator.hasNext()) {
            temp.next = new ListNode(iterator.next());
            temp = temp.next;
        }
        return result;
    }

    public static String toString(ListNode node) {
        if (null == node) return "";
        StringBuffer result = new StringBuffer();
        result.append(node.val);
        ListNode next = node.next;
        while (null != next) {
            result.append(", ").append(next.val);
            next = next.next;
        }
        return result.toString();
    }
    // endregion

    // region 3. longest-substring-without-repeating-characters
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        int from = 0;
        int result = 0;
        HashMap<Character, Integer> positionMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char pending = chars[i];
            if (positionMap.containsKey(pending)) {
                Integer position = positionMap.get(pending) + 1;
                if (position > from) from = position;
            }
            positionMap.put(pending, i);
            int pendingResult = i - from + 1;
            if (result < pendingResult) result = pendingResult;
        }
        return result;
    }
    // endregion

    // region 4. median-of-two-sorted-arrays
    //endregion
    public static void main(String[] args) {
        int result = new Solution().lengthOfLongestSubstring("abba");
        System.out.println(result);
    }
}
