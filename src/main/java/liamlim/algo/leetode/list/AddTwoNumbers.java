package liamlim.algo.leetode.list;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */

public class AddTwoNumbers {

  @Test
  public void test_add_two_numbers() {
    ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
    ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

    ListNode solOne = addTwoNumbers(l1, l2);
    Assert.assertEquals(solOne.val, 7);
    Assert.assertEquals(solOne.next.val, 0);
    Assert.assertEquals(solOne.next.next.val, 8);

    ListNode solTwo = addTwoNumbers2(l1, l2);
    Assert.assertEquals(solTwo.val, 7);
    Assert.assertEquals(solTwo.next.val, 0);
    Assert.assertEquals(solTwo.next.next.val, 8);
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode sol = new ListNode();
    ListNode node = sol;
    int carry = 0;

    while (l1 != null || l2 != null || carry > 0) {
      int val1 = 0;
      int val2 = 0;

      if (l1 != null) {
        val1 = l1.val;
        l1 = l1.next;
      }

      if (l2 != null) {
        val2 = l2.val;
        l2 = l2.next;
      }

      int sum = val1 + val2 + carry;
      node.val = sum % 10;
      carry = sum / 10;

      if (l1 != null || l2 != null || carry > 0) {
        node.next = new ListNode();
        node = node.next;
      }

    }

    return sol;
  }

  public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

    ListNode sol = new ListNode();
    ListNode node = sol;
    int carry = 0;

    do {
      node.next = new ListNode();
      node = node.next;

      int val1 = 0;
      int val2 = 0;

      if (l1 != null) {
        val1 = l1.val;
        l1 = l1.next;
      }

      if (l2 != null) {
        val2 = l2.val;
        l2 = l2.next;
      }

      int sum = val1 + val2 + carry;
      node.val = sum % 10;
      carry = sum / 10;
    } while (l1 != null || l2 != null || carry > 0);

    return sol.next;
  }
}
