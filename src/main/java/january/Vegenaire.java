package january;

public class Vegenaire extends Caesar {

    private String password;

    @Override
    public void setKey(Object key) {
        if (!(key instanceof String password)) {
            throw new IllegalArgumentException("Vegenaire encryption received key of wrong type, Expected STRING received " + key.getClass().getName());
        }
        if (((String) key).length() == 0) {
            throw new IllegalArgumentException("Password must be longer than 0");
        }
        this.password = password;
    }

    @Override
    public boolean encrypt() {
        String text = super.getText();
        StringBuilder cipherText = new StringBuilder();
        for (int textIndex = 0; textIndex < text.length(); textIndex++) {
            char txtChar = text.charAt(textIndex);
            int pwCharIndex = textIndex % this.password.length();
            char pwChar = password.charAt(pwCharIndex);
            cipherText.append(super.encryptString(super.getCharIndex(pwChar), String.valueOf(txtChar)));
        }
        super.setCipherText(cipherText.toString());
        return true;
    }


    @Override
    public boolean decrypt() {
        String text = super.getCipherText();
        StringBuilder decryptedString = new StringBuilder();
        for (int textIndex = 0; textIndex < text.length(); textIndex++) {
            char txtChar = text.charAt(textIndex);
            int pwCharIndex = textIndex % this.password.length();
            char pwChar = password.charAt(pwCharIndex);
            decryptedString.append(super.decryptString(super.getCharIndex(pwChar), String.valueOf(txtChar)));
        }
        super.setText(decryptedString.toString());
        return true;
    }
}
