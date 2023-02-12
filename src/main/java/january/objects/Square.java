package january.objects;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Square {

    private int width;
    private int height;


    private static final String ALPHABET_UPPER = "ABCDEFGHIKLMNOPQRSTUVWXYZ";


    private char[][] content;

    public Square(int width, int height) {
        this.width = width;
        this.height = height;
        content = new char[this.width][this.height];
    }

    public void print() {
        for (char[] chars : this.content) {
            System.out.println(chars);
        }
    }

    public void addString(String str) {
        str = removeDuplicates(str);
        if (str.length() > width * height) {
            throw new IllegalArgumentException("String exceeds Square Size");
        }
        int stringIndex = 0;
        char[] chars = str.toCharArray();
        for (char[] chars1 : this.content) {
            for (int i = 0; i < chars1.length; i++) {
                if (chars1[i] != '\u0000') continue;
                if (stringIndex == chars.length) break;
                chars1[i] = chars[stringIndex];
                stringIndex++;
            }
        }
    }

    public void fillWithRemainingLetters() {
        char[] allChars = ALPHABET_UPPER.toCharArray();
        List<Character> allCharList = new ArrayList<>();
        for (char allChar : allChars) {
            allCharList.add(allChar);
        }
        for (char[] chars : this.content) {
            for (char c : chars) {
                allCharList.remove(Character.valueOf(c));
            }
        }
        StringBuilder str = new StringBuilder();
        for (Character character : allCharList) {
            str.append(character);
        }
        this.addString(str.toString());
    }

    public String removeDuplicates(String str) {
        char[] chars = str.toCharArray();
        LinkedHashSet<Character> characters = new LinkedHashSet<>();
        for (char c : chars) {
            characters.add(c);
        }
        System.out.println(characters);
        StringBuilder strWithoutDuplicates = new StringBuilder();
        for (Character character : characters) {
            strWithoutDuplicates.append(character);
        }
        return strWithoutDuplicates.toString();
    }

    public String getNeighbours(char c1, char c2) {
        // Get positions
        int xPosC1 = -1;
        int yPosC1 = -1;
        int xPosC2 = -1;
        int yPosC2 = -1;
        System.out.println("Searching " + c1 + " " + c2);
        for (int x = 0; x < this.content.length; x++) {
            for (int y = 0; y < this.content[x].length; y++) {
                if (this.content[x][y] == c1) {
                    xPosC1 = x;
                    yPosC1 = y;
                }
                if (this.content[x][y] == c2) {
                    xPosC2 = x;
                    yPosC2 = y;
                }
            }
        }
        if (xPosC1 == xPosC2) { // Same row
            // Increase X, if out of bounds reset
            int y1 = yPosC1;
            int y2 = yPosC2;
            y1++;
            y2++;
            while (y1 >= height) {
                xPosC1++;
                y1 -= height;
            }
            while (y2 >= height) {
                xPosC2++;
                y2 -= height;
            }
            return "" + this.content[xPosC1][y1] + this.content[xPosC2][y2];
        }
        if (yPosC1 == yPosC2) { // Same column
            // Increase Y, if oob reset
            int x1 = xPosC1;
            int x2 = xPosC2;
            x1++;
            x2++;
            while (x1 >= width) {
                yPosC1++;
                x1 -= width;
            }
            while (x2 >= width) {
                yPosC2++;
                x2 -= width;
            }
            return "" + this.content[x1][yPosC1] + this.content[x2][yPosC2];
        }

        // Keeping X same, swapping Y values

        int newYC1 = yPosC2;
        int newYC2 = yPosC1;

        return "" + this.content[xPosC1][newYC1] + this.content[xPosC2][newYC2];
    }


    public String getReverseNeighbours(char c1, char c2) {
        // Get positions
        int xPosC1 = -1;
        int yPosC1 = -1;
        int xPosC2 = -1;
        int yPosC2 = -1;
        for (int x = 0; x < this.content.length; x++) {
            for (int y = 0; y < this.content[x].length; y++) {
                if (this.content[x][y] == c1) {
                    xPosC1 = x;
                    yPosC1 = y;
                } else if (this.content[x][y] == c2) {
                    xPosC2 = x;
                    yPosC2 = y;
                }
            }
        }
        if (xPosC1 == xPosC2) { // Same row
            // Increase X, if out of bounds reset
            int y1 = yPosC1;
            int y2 = yPosC2;
            y1--;
            y2--;
            while (y1 < 0) {
                xPosC1--;
                y1 += height;
            }
            while (y2 < 0) {
                xPosC2--;
                y2 += height;
            }
            return "" + this.content[xPosC1][y1] + this.content[xPosC2][y2];
        }
        if (yPosC1 == yPosC2) { // Same column
            // Increase Y, if oob reset
            int x1 = xPosC1;
            int x2 = xPosC2;
            x1++;
            x2++;
            while (x1 >= width) {
                yPosC1--;
                x1 += width;
            }
            while (x2 >= width) {
                yPosC2--;
                x2 += width;
            }
            return "" + this.content[x1][yPosC1] + this.content[x2][yPosC2];
        }

        // Keeping X same, swapping Y values

        int newYC1 = yPosC2;
        int newYC2 = yPosC1;

        return "" + this.content[xPosC1][newYC1] + this.content[xPosC2][newYC2];
    }
}
