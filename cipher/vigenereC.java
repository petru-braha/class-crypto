package cipher;

public class vigenereC extends cipher {

  private final int[] key;

  public vigenereC(final int[] k) {
    key = k.clone();
  }

  public char[] encrypt(char[] message) {

    cryptoText = message.clone();
    for (int i = 0; i < message.length; i++) {
      cryptoText[i] = 'a';
      int number = ((message[i] - 'a') + key[i % key.length]);
      number %= language.enL.length();
      cryptoText[i] += (char) number;
    }

    return cryptoText;
  }

}
