package markdown.model;

public class MarkDownColumn {
    private final String columnName;
    private final Alignment alignment;
    private final int length;


    public MarkDownColumn(String columnName, Alignment alignment, int length) {
        this.columnName = columnName;
        this.alignment = alignment;
        this.length = length;
    }

    public String getColumnName() {
        return columnName;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "MarkDownColumn{" +
                "columnName='" + columnName + '\'' +
                ", alignment=" + alignment +
                ", length=" + length +
                '}';
    }
}
