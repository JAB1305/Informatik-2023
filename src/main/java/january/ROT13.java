package january;

public class ROT13 extends Caesar {

    public ROT13() {
        super();
        super.setKey(13);
    }

    @Override
    public void setKey(Object key) {
        throw new RuntimeException("Key of ROT13 can not be changed");
    }

    @Override
    public boolean decrypt() {
        return super.encrypt();
    }
}
