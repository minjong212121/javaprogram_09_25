import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("몇 개의 수를 입력할 예정인가요? ");
        int n = sc.nextInt();  // 배열의 크기


        int[] numbers = new int[n];


        System.out.print("수를 입력하세요: ");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        int min = numbers[0];
        int max = numbers[0];

        for (int i = 1; i < n; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        System.out.println("최대값: " + max);
        System.out.println("최소값: " + min);

        sc.close();
    }
}
