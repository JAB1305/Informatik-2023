package markdown;


import markdown.model.MarkDownColumn;
import markdown.model.MarkDownLine;

import java.util.ArrayList;
import java.util.Arrays;

public class MarkDownUtility {

    private final ArrayList<MarkDownColumn> columns;
    private final ArrayList<MarkDownLine> lines;

    public MarkDownUtility(MarkDownColumn... columns) {
        this.columns = new ArrayList<>();
        this.lines = new ArrayList<>();

        this.columns.addAll(Arrays.asList(columns));
    }

    public void addLine(MarkDownLine line) {
        this.lines.add(line);
    }

    public String genTable() {
        StringBuilder table = new StringBuilder();
        addHeader(table);
        table.append("\n");
        addContent(table);
        return table.toString();
    }

    private void addHeader(StringBuilder table) {
        StringBuilder header = new StringBuilder();

        // First line of table; names
        StringBuilder headerLine1 = new StringBuilder("|");
        // Second line of table; alignments
        StringBuilder headerLine2 = new StringBuilder("|");

        for (MarkDownColumn column : columns) {
            headerLine1.append(column.getColumnName());
            headerLine1.append("|");
            headerLine2.append(column.getAlignment().genString(column.getLength()));
            headerLine2.append("|");
        }

        header.append(headerLine1);
        header.append("\n");
        header.append(headerLine2);
        table.append(header);
    }

    private void addContent(StringBuilder table) {
        StringBuilder content = new StringBuilder();

        for (MarkDownLine line : lines) {
            StringBuilder lineString = new StringBuilder("|");
            for (int columnId = 0; columnId < columns.size(); columnId++) {
                lineString.append(line.getByColumnId(columnId));
                lineString.append("|");
            }
            content.append(lineString);
            content.append("\n");
        }

        table.append(content);
    }
}
