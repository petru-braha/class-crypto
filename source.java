import java.util.Random;

import cipher.language;
import cipher.substitutionC;
import cipher.permutationC;
import cipher.affineC;

public class source {

  public static int g(final int startInclusive, final int endExclusive) {
    Random utility = new Random();
    return utility.nextInt(startInclusive, endExclusive);
  }

  public static long g(final long startInclusive, final long endExclusive) {
    Random utility = new Random();
    return utility.nextLong(startInclusive, endExclusive);
  }

  public static void select(final int k, char[] results) {
    if (k > results.length) {
      System.out.println("warning: select() failed");
      return;
    }

    int it_index_array = 0;
    for (; it_index_array < k; it_index_array++) {
      final int it_index_chosen = g(it_index_array, results.length);
      final char answer = results[it_index_chosen];
      results[it_index_chosen] = results[it_index_array];
      results[it_index_array] = answer;
    }
  }

  private static char[] message;

  private static void testSub() {

    char[] key = language.enL.toCharArray();
    select(key.length, key);
    substitutionC encryptor = new substitutionC(1, 1, key);

    char[] result = encryptor.encrypt(message);

    System.out.print("keySub: ");
    System.out.print(key);
    System.out.print("\", cripto-text: ");
    System.out.println(result);
  }

  private static void testPrm() {

    int n = g(5, 15);
    char[] key = new char[n];
    for (int i = 0; i < key.length; i++)
      key[i] = language.enL.charAt(g(0, language.enL.length()));

    permutationC encryptor = new permutationC(key);
    char[] result = encryptor.encrypt(message);

    System.out.print("keyPrm: ");
    System.out.print(key);
    System.out.print("\", cripto-text: ");
    System.out.println(result);
  }

  private static void testAfn() {

    final int a = g(Integer.MIN_VALUE, Integer.MAX_VALUE),
        b = g(Integer.MIN_VALUE, Integer.MAX_VALUE);
    affineC encryptor = new affineC(a, b);

    char[] result = encryptor.encrypt(message);
    System.out.printf("keyAfn: %d %d, cripto-text: ", a, b);
    System.out.println(result);
  }

  /*
   * standard: language.enL
   * we are assuming the constraints found at language.java
   */
  public static void main(String[] args) {

    if (args.length > 1) {
      System.out.println("error: wrong number of arguments");
      return;
    }

    System.out.printf("the analysis is human-based.\n");
    if (0 == args.length)
      message = "ilovemygirlfriend".toCharArray();
    else
      message = args[0].toCharArray();

    testSub();
    testPrm();
    testAfn();
  }
}
