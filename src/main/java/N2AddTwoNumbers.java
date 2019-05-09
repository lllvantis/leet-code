import java.util.Iterator;
import java.util.List;

public class N2AddTwoNumbers {

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

    public static void main(String[] args) {
        final ListNode n00 = new ListNode(2);
        final ListNode n01 = new ListNode(4);
        final ListNode n02 = new ListNode(3);

        n00.next = n01;
        n01.next = n02;

        final ListNode n10 = new ListNode(5);
        final ListNode n11 = new ListNode(6);
        final ListNode n12 = new ListNode(4);

        n10.next = n11;
        n11.next = n12;

        final ListNode listNode = new N2AddTwoNumbers().addTwoNumbers(n00, n10);
        System.out.println(toString(listNode));
    }
}
