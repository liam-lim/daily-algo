package liamlim.algo.leetode.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */

public class MedianOfTwoSortedArray {

  @Test
  public void test_median_of_two_sorted_arrays() {
    Assert.assertEquals(2.5, findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }), 0);
    Assert.assertEquals(-1, findMedianSortedArrays(new int[] { 3 }, new int[] { -2, -1 }), 0);
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    if (nums1.length == 0 && nums2.length == 0) {
      return 0;
    }

    List<Integer> combined = new ArrayList<>();
    List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
    List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());


    for (int i = 0; i <= Math.max(list1.size(), list2.size()); i++) {

      if (i >= list1.size()) {
        combined.addAll(list2.subList(i, list2.size()));
        break;
      }

      if (i >= list2.size()) {
        combined.addAll(list1.subList(i, list1.size()));
        break;
      }

      if (list1.get(i) <= list2.get(i)) {
        combined.add(list1.get(i));
        combined.add(list2.get(i));
      }
      else {
        combined.add(list2.get(i));
        combined.add(list1.get(i));
      }

    }

    int mid = combined.size() / 2;

    if (combined.size() % 2 == 0) {
      int sum = combined.get(mid - 1) + combined.get(mid);
      return sum / 2.0;
    }
    else {
      return combined.get(mid);
    }

  }
}
