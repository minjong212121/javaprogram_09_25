import java.util.Scanner;

public class Homework4 {

    // 절댓값
    public static int abs(int x) {
        if (x < 0) {
            return -x;
        } else {
            return x;
        }
    }

    // 최소값
    public static int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    // 최대값
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // 1) 재귀 gcd 구현
    public static int gcd(int m, int n) {
        m = abs(m);
        n = abs(n);

        if (m == 0 && n == 0) return 0;
        if (n == 0) return m;

        int small = min(m, n);
        int big   = max(m, n);

        return gcd(small, big % small);
    }

    // 2)반복문
    public static int gcdwhile(int m, int n) {
        m = abs(m);
        n = abs(n);

        if (m == 0 && n == 0) return 0;

        int small = min(m, n);
        int big   = max(m, n);

        while (small != 0) {
            int r = big % small;
            big = small;
            small = r;
        }
        return big;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("두 수를 입력하세요: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        int result = gcd(a, b);
        System.out.println("두 수의 최대공약수는 " + result + "입니다.");

        sc.close();
    }
}
