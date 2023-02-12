package markdown.model;

public enum Alignment {
    LEFT("x:"),
    CENTER(":x:"),
    RIGHT(":x");

    private String base;

    Alignment(String base) {
        this.base = base;
    }

    public String genString(int length) {
        return base.replace("x", genWidthIndicator(length));
    }

    private String genWidthIndicator(int length) {
        StringBuilder builder = new StringBuilder();
        for (int c = 0; c < length; c++) {
            builder.append("-");
        }
        return builder.toString();
    }
}
