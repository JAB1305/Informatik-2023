package january;

public interface Crypter {
    void setKey(Object key);
    void setText(String text);
    String getCipherText();
    boolean encrypt();
    boolean decrypt();
}
