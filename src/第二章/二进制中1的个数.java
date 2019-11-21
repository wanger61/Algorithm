package 第二章;

public class 二进制中1的个数 {
    public static void main(String[] args) {
        System.out.println(numberOf1(9));
        System.out.println(numberOf1best(9));
    }
    public static int numberOf1(int n){
        int flag = 1;
        int count = 0;
        while (flag<Integer.MAX_VALUE/2){
            if ((n&flag)!=0) count++;
            flag = flag << 1 ;
        }
        return count;
    }
    public static int numberOf1best(int n){
        int count = 0;
        while (n!=0){
            ++count;
            n = (n-1)&n;
        }
        return count;
    }
}
