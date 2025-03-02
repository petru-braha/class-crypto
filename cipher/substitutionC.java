package cipher;

/*
 * monographic/polygraphic
 * monoalphabetic/polyalphabetic
 */
public class substitutionC extends cipher {

  // key
  private final int countTrials;
  private final int countSymbols;
  private final char[] alphabetPermutation;

  public substitutionC(final int cT, final int cS, final char[] aP) {
    countTrials = cT;
    countSymbols = cS;
    alphabetPermutation = aP;
  }

  public char[] encrypt(char[] message) {

    cryptoText = message.clone();
    for (int trial = 0; trial < countTrials; trial++) {
      int iSymbol = 0;
      for (; iSymbol < message.length; iSymbol += countSymbols) {

        int nSymbol = iSymbol + countSymbols;
        if (nSymbol >= message.length)
          nSymbol = message.length;

        for (int i = iSymbol; i < nSymbol; i++) {
          int indexPermutation = message[i] - 'a';
          cryptoText[i] = alphabetPermutation[indexPermutation];
        }
      }
    }

    return cryptoText;
  }

  public int getTrails() {
    return countTrials;
  }

  public int getSymbols() {
    return countSymbols;
  }
}
