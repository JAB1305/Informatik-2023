package january;

import january.objects.Square;

import java.util.Locale;

public class Playfair implements Crypter {

    private String text;
    private String password;
    private String cipherText;

    @Override
    public void setKey(Object key) {
        if (!(key instanceof String password)) {
            throw new IllegalArgumentException("Playfair encryption received key of wrong type, Expected STRING received " + key.getClass().getName());
        }
        if (((String) key).length() == 0) {
            throw new IllegalArgumentException("Password must be longer than 0");
        }
        password = password.toUpperCase(Locale.ROOT);
        if (password.contains("J")) {
            throw new IllegalArgumentException("Password can not contain J");
        }
        this.password = password;
    }

    @Override
    public void setText(String text) {
        if (text.length() % 2 != 0) {
            throw new IllegalArgumentException("Text must be of even length");
        }
        this.text = text;
    }

    @Override
    public String getCipherText() {
        return this.cipherText;
    }

    @Override
    public boolean encrypt() {
        Square square = new Square(5 ,5);
        StringBuilder cipher = new StringBuilder();
        square.addString(this.password);
        square.fillWithRemainingLetters();
        square.print();
        char[] chars = this.text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) {
                String s = square.getNeighbours(chars[i], chars[i + 1]);
                cipher.append(s);
            }
        }
        this.cipherText = cipher.toString();
        return true;
    }

    @Override
    public boolean decrypt() {
        Square square = new Square(5 ,5);
        StringBuilder text = new StringBuilder();
        square.addString(this.password);
        square.fillWithRemainingLetters();
        char[] chars = this.cipherText.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) {
                String s = square.getReverseNeighbours(chars[i], chars[i + 1]);
                text.append(s);
            }
        }
        this.text = text.toString();
        return true;
    }

    public String getText() {
        return text;
    }

    public void setCipherText(String cipherText) {
        this.cipherText = cipherText;
    }
}
