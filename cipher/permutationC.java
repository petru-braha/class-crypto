package cipher;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class permutationC extends cipher {

  private final int[] rankArray;

  public permutationC(final char[] k) {

    int[] sortedUnique = new int[k.length];
    sortedUnique = Arrays.stream(sortedUnique).distinct().sorted().toArray();

    Map<Integer, Integer> rankMap = new HashMap<>();
    for (int i = 0; i < sortedUnique.length; i++)
      rankMap.put(sortedUnique[i], i);

    rankArray = new int[sortedUnique.length];
    for (int i = 0; i < sortedUnique.length; i++)
      rankArray[i] = rankMap.get(sortedUnique[i]);
  }

  public char[] encrypt(char[] message) {

    cryptoText = message.clone();
    for (int i = 0; i < message.length; i += rankArray.length) {

      int count = i + rankArray.length;
      if (count >= message.length)
        count = message.length;

      for (int index = i; index < count; index++)
        cryptoText[i + rankArray[index - i]] = message[index];
    }

    return cryptoText.clone();
  }
}
