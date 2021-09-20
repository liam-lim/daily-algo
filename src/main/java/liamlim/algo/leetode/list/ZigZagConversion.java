package liamlim.algo.leetode.list;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 */

public class ZigZagConversion {

  @Test
  public void test_convert() {
    Assert.assertEquals("PAHNAPLSIIGYIR", convert("PAYPALISHIRING", 3));
    Assert.assertEquals("A", convert("A", 2));
    Assert.assertEquals("AB", convert("AB", 1));
  }

  public String convert(String s, int numRows) {

    if (numRows <= 1) {
      return s;
    }

    StringBuilder[] list = new StringBuilder[numRows];

    boolean b = true;
    int count = -1;
    for (int i = 0; i < s.length(); i++) {

      if (count == numRows - 1) {
        b = false;
      }

      if (count == 0) {
        b = true;
      }

      count = b ? ++count : --count;
      char c = s.charAt(i);

      list[count] = list[count] == null ?
          new StringBuilder().append(c) :
          list[count].append(c);
    }

    StringBuilder out = new StringBuilder();
    for (StringBuilder sb : list) {
      if (sb != null) {
        out.append(sb);
      }
    }

    return out.toString();
  }

}
