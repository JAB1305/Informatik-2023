package fractals;

import markdown.MarkDownUtility;
import markdown.model.Alignment;
import markdown.model.MarkDownColumn;
import markdown.model.MarkDownLine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        MarkDownUtility markDownUtility = new MarkDownUtility(
                new MarkDownColumn("Anzahl Iterationen", Alignment.CENTER, 15),
                new MarkDownColumn("Kantenlänge", Alignment.CENTER, 15),
                new MarkDownColumn("Anzahl Seiten", Alignment.CENTER, 15),
                new MarkDownColumn("Flächeninhalt", Alignment.CENTER, 15),
                new MarkDownColumn("Anzahl Dreiecke", Alignment.CENTER, 15)

        );
        for (int i = 0; i < 5; i++) {
            markDownUtility.addLine(generateSierpinski(i, 3));
        }
        writeData(markDownUtility.genTable(), "test.md");
    }

    private static MarkDownLine generateSierpinski(int n, int baseLength) {
        double newLength = (1 / (Math.pow(2, n))) * baseLength;
        return new MarkDownLine(n,
                newLength,
                (int) Math.pow(3, n + 1),
                (double) Math.round(0.25 * newLength * newLength * Math.sqrt(3) * 1000) / 1000,
                (int) Math.pow(3, n));
    }


    public static void writeData(String content, String fileName)
            throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(content);

        writer.close();
    }

}
