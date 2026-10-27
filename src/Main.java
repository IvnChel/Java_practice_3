import java.util.Scanner;

public class Main {

    static void printEvenReversed(int[] a) {
        int k = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] % 2 == 0) {
                System.out.println(a[i]);
                k++;
            }
        }
        System.out.println("Количество: " + k);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        printEvenReversed(a);
    }
}