package vsu.cs.ru.num16;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n = readValue('n');

        if (n <= 2) {
            System.out.println("You entered incorrect n. Variable n must be greater than 2.");
            return;
        }

        int a = readValue('a');
        int a1 = 1, a2 = 2, a3 = 3;
        int initialSum = calcInitialSum(a1, a2, a3, a);
        int finalSum = calcFinalSum(n, a, a1, a2, a3, initialSum);
        printElements(n, a1, a2, a3);
        printFinalSum(finalSum);
    }

    private static int readValue(char name) {
        System.out.printf("Input %s: ", name);
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    private static int calcInitialSum(int a1, int a2, int a3, int a) {
        if (a > a3) {
            return a1 + a2 + a3;
        } else if (a > a2) {
            return a1 + a2;
        } else if (a > a1) {
            return a1;
        } else return 0;
    }

    private static int calcFinalSum(int n, int a, int a1 , int a2 , int a3, int initialSum) {
        int finalSum = initialSum;

        for (int k = 4; k <= n; k++) {
            int Ak = a3 + a2 - 2 * a1;
            a1 = a2; a2 = a3; a3 = Ak;
            if (Ak < a) {
                finalSum += Ak;
            }
        }
        return finalSum;
    }

    private static void printFinalSum(int finalSum) {
        System.out.println();
        System.out.println("Сумма чисел = " + finalSum);
    }
    
    private static void printElements(int n, int a1, int a2, int a3) {
        System.out.print("Элементы последовательности: " + a1 + " " + a2 + " " + a3 + " ");

        for (int k = 4; k <= n; k++) {
            int Ak = a3 + a2 - 2 * a1;
            System.out.print(Ak + " ");
            a1 = a2; a2 = a3; a3 = Ak;
        }
    }
}