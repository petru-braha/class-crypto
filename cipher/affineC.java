package cipher;

public class affineC extends cipher {

  private final int a, b;

  public affineC(final int pa, final int pb) {
    a = pa;
    b = pb;
  }

  public char[] encrypt(char[] message) {

    cryptoText = message.clone();
    for (int i = 0; i < message.length; i++) {
      int x = (int) message[i];
      int c = (a * x + b) % language.enL.length();
      cryptoText[i] = (char) (c + 'a');
    }

    return cryptoText;
  }
}
