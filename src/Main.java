import java.util.Scanner;
import java.util.Arrays;

public class Main {

    static void task1(int[] a) {
        int k = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] % 2 == 0) {
                System.out.println(a[i]);
                k++;
            }
        }
        System.out.println("Количество: " + k);
    }

    static void task2(int[] array){
        int count = 0;
        boolean increasing = false;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                // Рост есть, но участок ещё не был посчитан.
                if (!increasing) {
                    count++;
                    increasing = true;
                }
            } else {
                // Рост закончился.
                increasing = false;
            }
        }

        System.out.println("Количество возрастающих участков: " + count);
    }

    static int[] task3(int[] a) {
        int[] b = new int[a.length];
        int sum = 0;

        for (int i = a.length - 1; i >= 0; i--) {
            sum += a[i];
            b[i] = sum;
        }

        return b;
    }

    static void task4(int[][] a){
        int n = a.length;

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        while (top <= bottom && left <= right) {
            // 1. Вниз по левому столбцу.
            for (int i = top; i <= bottom; i++) {
                System.out.print(a[i][left] + " ");
            }
            left++;

            // 2. Вправо по нижней строке.
            for (int j = left; j <= right; j++) {
                System.out.print(a[bottom][j] + " ");
            }
            bottom--;

            // 3. Вверх по правому столбцу, если он ещё остался.
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(a[i][right] + " ");
                }
                right--;
            }

            // 4. Влево по верхней строке, если она ещё осталась.
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    System.out.print(a[top][j] + " ");
                }
                top++;
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int n = scanner.nextInt();
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = scanner.nextInt();
//        }
//        task1(a);

//        int[] a = {1,3,5,2,8};
//        task2(a);

//        int[] a = {1, 2, 3, 4};
//        int[] b = task3(a);
//        System.out.println("A: " + Arrays.toString(a));
//        System.out.println("B: " + Arrays.toString(b));
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        task4(a);


    }
}