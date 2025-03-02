package cipher;

public abstract class cipher {

  protected char[] cryptoText;

  public abstract char[] encrypt(char[] message);

  public char[] getCriptoText() {
    return cryptoText;
  }
}
