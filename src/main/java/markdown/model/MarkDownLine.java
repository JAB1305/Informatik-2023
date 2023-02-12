package markdown.model;

public class MarkDownLine {

    private final String[] contents;

    public MarkDownLine(String... contents) {
        this.contents = contents;
    }

    public MarkDownLine(Number... contents) {
        String[] stringContents = new String[contents.length];
        for (int i = 0; i < contents.length; i++) {
            stringContents[i] = String.valueOf(contents[i]);
        }
        this.contents = stringContents;
    }

    public String[] getContents() {
        return contents;
    }

    public String getByColumnId(int id) {
        //DEBUG: if (id >= contents.length) throw new RuntimeException("Column index out of bounds for line");
        if (id >= contents.length) return "";
        return contents[id];
    }
}
