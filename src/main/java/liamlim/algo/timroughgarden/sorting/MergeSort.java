package liamlim.algo.timroughgarden.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://www.hackerearth.com/practice/algorithms/sorting/merge-sort/tutorial/
// https://www.youtube.com/watch?v=rBd5w0rQaFo&list=PLEGCF-WLh2RLHqXx6-GZr_w7LgqKDXxN_&index=6&ab_channel=StanfordAlgorithms

public class MergeSort {

  @Test
  public void test_mergeSort() {
    List<Integer> input = Arrays.asList(5, 4, 1, 8, 7, 2, 6, 3, 9, 2, 2);
    List<Integer> output = mergeSort(input);

    Collections.sort(input);
    System.out.println("actual " + output);
    System.out.println("expected " + input);

    Assert.assertEquals(output, input);
  }

  private static List<Integer> mergeSort(List<Integer> input) {

    if (input.size() <= 1) {
      return input;
    }

    List<Integer> jl = input.subList(0, input.size() / 2);
    List<Integer> kl = input.subList(input.size() / 2, input.size());

    return merge(mergeSort(jl), mergeSort(kl));
  }

  private static List<Integer> merge(List<Integer> jl, List<Integer> kl) {

    ArrayList<Integer> output = new ArrayList<>();

    int j = 0;
    int k = 0;

    while (j != jl.size() || k != kl.size()) {

      if (j == jl.size()) {
        output.addAll(kl.subList(k, kl.size()));
        break;
      }

      if (k == kl.size()) {
        output.addAll(jl.subList(j, jl.size()));
        break;
      }

      if (jl.get(j) < kl.get(k)) {
        output.add(jl.get(j));
        j++;
      }
      else {
        output.add(kl.get(k));
        k++;
      }
    }

    return output;
  }
}
