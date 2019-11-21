package 第二章;

import java.util.Scanner;

public class 斐波那契数列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入项数：");
        int n = scanner.nextInt();
        System.out.println(Fibonacii(n));
    }

    private static long Fibonacii(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        long one = 0;
        long two = 1;
        int i = 2;
        long fibo = 0;
        while (i<=n){
            fibo = one + two;
            one = two;
            two = fibo;
            i++;
        }
        return fibo;
    }
}
