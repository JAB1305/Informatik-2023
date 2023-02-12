package january;

import org.testng.annotations.Test;

public class VegenaireCipherTest {

    private String PASSWORD = "PASSWOREGAL";

    @Test
    public void testEncryption() {
        Vegenaire vegenaire = new Vegenaire();
        vegenaire.setKey(PASSWORD);
        vegenaire.setText("Hallo das ist ein cooler komplexer Test-Satz mit Sonderzeichen $%&/()= WOOOOOHOOOO");
        vegenaire.encrypt();
        assert vegenaire.getCipherText().equals("Waddk uey tht web guowtr ckagpkxpg Lwoh-Wgtk mal Gfrjecoeaudse $%&/()= KFSUOZWOGGK");
    }

    @Test
    public void testDecryption() {
        Vegenaire vegenaire = new Vegenaire();
        vegenaire.setKey(PASSWORD);
        vegenaire.setCipherText("Waddk uey tht web guowtr ckagpkxpg Lwoh-Wgtk mal Gfrjecoeaudse $%&/()= KFSUOZWOGGK");
        vegenaire.decrypt();
        assert vegenaire.getText().equals("Hallo das ist ein cooler komplexer Test-Satz mit Sonderzeichen $%&/()= WOOOOOHOOOO");
    }
}
