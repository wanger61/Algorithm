package 第六章;

public class 和为s的连续正数序列 {
    public static void main(String[] args) {
        int k = 9;
        CountinuousSequence(k);
    }

    private static void CountinuousSequence(int k) {
        if (k<=1) return;
        int small = 1;
        int big = 2;
        while (big <= (k+1)/2){
            if ((big+small)*(big-small+1)/2 == k){
                for (int i=small; i<=big; i++){
                    System.out.print(i+",");
                }
                System.out.println();
                big++;
            }else if ((big+small)*(big-small+1)/2 < k){
                big++;
            }else {
                small++;
            }
        }
    }
}
