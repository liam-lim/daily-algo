package liamlim.algo.hackerrank.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

// https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

public class NewYearChaos {


  private static void minimumBribes(List<Integer> q) {
    int ans = 0;

    for (int i = q.size() - 1; i >= 0; i--) {

      if (q.get(i) - (i + 1) > 2) {
        System.out.println("Too chaotic");
        return;
      }

      for (int j = Math.max(0, q.get(i) - 2); j < i; j++) {
        if (q.get(j) > q.get(i)) {
          ans++;
        }
      }
    }

    System.out.println(ans);
  }


  private static void minimumBribes_firstAttempt(List<Integer> q) {

    List<Integer> checkList = new ArrayList<>();

    for (int i = 0; i < q.size(); i++) {
      int originIndex = i + 1;
      int bribeCount = q.get(i) - originIndex;
      checkList.add(bribeCount);
    }

    long count = checkList.stream()
        .filter(x -> x > 2)
        .count();

    if (count > 0) {
      System.out.println("Too chaotic");
      return;
    }

    int sum = checkList.stream()
        .filter(x -> x > 0)
        .mapToInt(x -> x)
        .sum();

    System.out.println(sum);
  }

  // [1, 2, 5, 3, 7, 8, 6, 4] -> 7
  // [1, 2, 3, 4, 5, 6, 7, 8]
  // [0, 0, +2, -1, +2, +2, -1, -4]

  // [1, 2, 3, 4, 5, 6, 7, 8]
  // [1, 2, 5, 3, 4, 6, 7, 8] +2
  // [1, 2, 5, 3, 7, 4, 6, 8] +2
  // [1, 2, 5, 3, 7, 8, 4, 6] +2
  // [1, 2, 5, 3, 7, 8, 6, 4] +1

  // -------------------------------------

  // [2, 5, 1, 3, 4] -> Too chaotic
  // [1, 2, 3, 4, 5]
  // [+1, +3, -2, -1, -1]

  // -------------------------------------

  // [2, 1, 5, 3, 4] -> 3
  // [1, 2, 3, 4, 5]
  // [+1, -1, +2, -1, -1]

  // -------------------------------------

  // [1, 2, 3, 5, 4, 6, 7, 8] -> 1
  // [1, 2, 3, 4, 5, 6, 7, 8]
  // [0, 0, 0, +1, -1, 0, 0, 0]

  // -------------------------------------

  // [4, 1, 2, 3] -> Too chaotic
  // [1, 2, 3, 4]
  // [+3, -1, -1, -1]

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t).forEach(tItr -> {
      try {
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        minimumBribes(q);
      }
      catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
  }

}
