package cipher;

public abstract class cipher {

  protected String cryptoText = "";

  public abstract String encrypt(String maessage);

  public String getCriptoText() {
    return cryptoText;
  }
}
