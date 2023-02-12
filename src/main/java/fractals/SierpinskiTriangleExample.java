package fractals;

import java.util.Scanner;
import java.io.*;

public class SierpinskiTriangleExample {
    static void sierpinskiTriangle(int n) {
        for (int y = n - 1; y >= 0; y--) {
//loop prints the space until the condition becomes false
            for (int i = 0; i < y; i++) {
                System.out.print(" ");
            }
//prints *
            for (int x = 0; x + y < n; x++) {
//calculates the position to print *s
//prints * if the value of x and y is 0
                if ((x & y) != 0)
                    System.out.print(" " + " ");
                else
                    System.out.print("* ");
            }
            System.out.print("\n");
        }
    }

    //driver code
    public static void main(String args[]) {
//defines the number of * in the outer most triangle
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");  //we have provided n=16
        int n = sc.nextInt();
//function calling
        sierpinskiTriangle(n);
    }
}
