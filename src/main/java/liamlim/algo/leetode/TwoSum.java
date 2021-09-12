package liamlim.algo.leetode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */

public class TwoSum {

  @Test
  public void test_two_sum() {
    Assert.assertArrayEquals(twoSum(new int[] { 2, 7, 11, 15 }, 9), new int[] { 0, 1 });
  }

  public int[] twoSum(int[] nums, int target) {
    int[] sol = new int[2];
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int curr = nums[i];
      int diff = target - curr;

      if (map.containsKey(curr)) {
        sol[0] = map.get(curr);
        sol[1] = i;
        return sol;
      }
      else {
        map.put(diff, i);
      }
    }

    return sol;
  }
}
