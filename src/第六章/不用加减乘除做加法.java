package 第六章;

public class 不用加减乘除做加法 {
    public static void main(String[] args) {
        int num1 = -5;
        int num2 = 17;
        int sum = sumS(num1,num2);
        System.out.println(sum);
    }

    private static int sumS(int num1, int num2) {
        int sum;
        int carry;
        do {
            sum = num1^num2;
            carry = (num1&num2)<<1;
            num1 = sum;
            num2 = carry;
        }while (carry != 0);
        return sum;
    }
}
