package january;

import january.objects.Square;
import org.testng.annotations.Test;

public class PlayfairCipherTest {

    @Test
    public void testEncryption() {
        Playfair playfair = new Playfair();
        playfair.setText("COOLERTEXTMALSCHAUENOBDASFUNKTIONIERTT");
        playfair.setKey("OSHUABENNNING");
        playfair.encrypt();
        assert playfair.getCipherText().equals("MBACIPPGZQTODAFOBANIBCLSHDHILRBUIGIPVV");
    }

    @Test
    public void testDecryption() {
        Playfair playfair12 = new Playfair();
        playfair12.setCipherText("UDTU");
        playfair12.setKey("BA");
        playfair12.decrypt();
        System.out.println(playfair12.getText());
    }

}
