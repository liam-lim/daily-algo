package liamlim.algo.leetode.slidingwindow;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

public class LongestSubstring {

  @Test
  public void test_length_of_longest_substring() {
    Assert.assertEquals(0, lengthOfLongestSubstring(""));
    Assert.assertEquals(3, lengthOfLongestSubstring("abcabcbbba"));
    Assert.assertEquals(1, lengthOfLongestSubstring("bbbb"));
  }

  public int lengthOfLongestSubstring(String s) {
    int sol = 0;

    Map<Character, Integer> lookup = new HashMap<>();
    int left = 0;

    for (int i = 1; i <= s.length(); i++) {
      char c = s.charAt(i - 1);

      if (lookup.containsKey(c)) {
        left = Math.max(left, lookup.get(c));
      }

      lookup.put(c, i);
      sol = Math.max(sol, i - left);
    }

    return sol;
  }
}
