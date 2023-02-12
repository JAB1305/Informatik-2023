package january;

import org.testng.annotations.Test;

public class CaesarCipherTest {

    private final Integer key = 14;

    @Test
    public void testCipher() {
        Caesar caesar = new Caesar();
        caesar.setText("Hallo Ari");
        caesar.setKey(key);
        caesar.encrypt();
        assert caesar.getCipherText().equals("Vozzc Ofw");
    }

    @Test
    public void testDecryption() {
        Caesar caesar = new Caesar();
        caesar.setCipherText("Vozzc Ofw");
        caesar.setKey(key);
        caesar.decrypt();
        assert caesar.getText().equals("Hallo Ari");
    }
}
