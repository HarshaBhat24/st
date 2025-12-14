package st.triangle;

import java.util.Scanner;

public class TriangleType {

    private static final int MIN_SIDE = 1;
    private static final int MAX_SIDE = 10;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int a = readSide(sc, 1);
            int b = readSide(sc, 2);
            int c = readSide(sc, 3);

            if (!isValidRange(a, b, c)) {
                System.out.println("Invalid input! Each side must be between 1 and 10.");
                return;
            }

            if (!isTriangle(a, b, c)) {
                System.out.println("Not a Triangle");
                return;
            }

            System.out.println(classifyTriangle(a, b, c));
        }
    }

    private static int readSide(Scanner sc, int sideNumber) {
        System.out.print("Enter side " + sideNumber + ": ");
        return sc.nextInt();
    }

    private static boolean isValidRange(int a, int b, int c) {
        return isInRange(a) && isInRange(b) && isInRange(c);
    }

    private static boolean isInRange(int side) {
        return side >= MIN_SIDE && side <= MAX_SIDE;
    }

    private static boolean isTriangle(int a, int b, int c) {
        // Triangle inequality: sum of any two sides must be greater than the third
        return a + b > c && a + c > b && b + c > a;
    }

    private static String classifyTriangle(int a, int b, int c) {
        if (a == b && b == c) {
            return "Equilateral Triangle";
        }
        if (a == b || b == c || a == c) {
            return "Isosceles Triangle";
        }
        return "Scalene Triangle";
    }
}