package january;

public class Caesar implements Crypter {

    private int key;
    private String text;
    private String cipherText;

    private static final String ALPHABET_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String ALPHABET_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public void setKey(Object key) {
        if (!(key instanceof Integer intKey)) {
            throw new IllegalArgumentException("Caeser encryption received key of wrong type, Expected INT received " + key.getClass().getName());
        }
        this.key = intKey;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getCipherText() {
        return cipherText;
    }

    protected void setCipherText(String cipherText) {
        this.cipherText = cipherText;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean encrypt() {
        this.cipherText = this.encryptString(this.key, this.text);
        return true;
    }

    protected String encryptString(int key, String txt) {
        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < txt.length(); i++) {
            char c = txt.charAt(i);
            int charIndex = getCharIndex(c);
            if (charIndex == -1) {
                cipherText.append(c);
                continue;
            }
            int newIndex = charIndex + key;
            if (newIndex > 25) newIndex -= 26;
            cipherText.append(Character.isLowerCase(c) ? ALPHABET_LOWER.charAt(newIndex) : ALPHABET_UPPER.charAt(newIndex));
        }
        return cipherText.toString();
    }

    protected int getCharIndex(char c) {
        return Character.isLowerCase(c) ? ALPHABET_LOWER.indexOf(c) : ALPHABET_UPPER.indexOf(c);
    }

    @Override
    public boolean decrypt() {
        this.text = this.decryptString(this.key, this.cipherText);
        return true;
    }

    protected String decryptString(int key, String cipher) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < cipher.length(); i++) {
            char c = cipher.charAt(i);
            int charIndex = Character.isLowerCase(c) ? ALPHABET_LOWER.indexOf(c) : ALPHABET_UPPER.indexOf(c);
            if (charIndex == -1) {
                text.append(c);
                continue;
            }
            int newIndex = charIndex - key;
            if (newIndex < 0) newIndex += 26;
            text.append(Character.isLowerCase(c) ? ALPHABET_LOWER.charAt(newIndex) : ALPHABET_UPPER.charAt(newIndex));
        }
        return text.toString();
    }
}
