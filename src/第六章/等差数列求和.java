package 第六章;

public class 等差数列求和 {
    public static void main(String[] args) {
        int n = 5;
        int res = Sum_Solution(n);
        System.out.println(res);
    }

    public static int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (n > 0) && ((sum += Sum_Solution(n-1)) > 0);//第一个条件（n > 0）相当于终止条件
        return sum;
    }
}
