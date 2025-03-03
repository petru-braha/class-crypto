package cipher;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class permutationC extends cipher {

  private final int[] rankArray;

  public permutationC(final char[] k) {

    int[] sortedRanks = new int[k.length];
    for (int i = 0; i < k.length; i++)
      sortedRanks[i] = (int) (k[i] - 'a');

    rankArray = Arrays.stream(sortedRanks).distinct().toArray();
    sortedRanks = Arrays.stream(sortedRanks).distinct().sorted().toArray();

    if (k.length != sortedRanks.length)
      System.out.printf("permutationC - warning: %s\n",
          "ignoring non-distinct elements");

    Map<Integer, Integer> rankMap = new HashMap<>();
    for (int i = 0; i < sortedRanks.length; i++)
      rankMap.put(sortedRanks[i], i);

    for (int i = 0; i < sortedRanks.length; i++)
      rankArray[i] = rankMap.get(rankArray[i]);
  }

  public char[] encrypt(char[] message) {

    cryptoText = message.clone();
    for (int i = 0; i < message.length; i += rankArray.length) {

      int count = i + rankArray.length;
      if (count > message.length) {

        final char INVALID = '\0';
        char[] values = new char[rankArray.length];
        for (int index = 0; index < values.length; index++) {
          if (i + index >= message.length)
            values[rankArray[index]] = INVALID;
          else
            values[rankArray[index]] = message[i + index];
        }

        int indexMessage = i;
        for (int index = 0; index < values.length; index++)
          if (INVALID != values[index])
            cryptoText[indexMessage++] = values[index];
        return cryptoText;
      }

      for (int index = i; index < count; index++)
        if (i + rankArray[index - i] < count)
          cryptoText[i + rankArray[index - i]] = message[index];
    }

    return cryptoText;
  }
}
