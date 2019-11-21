package 第六章;

public class n个骰子的点数 {
    public static void main(String[] args) {
        int n = 2;
        double[] res = probility(n);
        for (int i = n; i <= res.length - 1; i++) {
            System.out.println(i + ":" + res[i]);
        }
    }

    private static double[] probility(int n) {
        if (n < 0) return null;
        int maxSum = 6 * n;
        int[] temp1 = new int[maxSum + 1];
        int[] temp2 = new int[maxSum + 1];
        for (int i = 1; i <= 6; i++) {
            temp1[i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= maxSum; j++) {
                if (i % 2 == 0) {
                    temp2[j] = 0;
                    for (int k = j - 1; k >= j - 6 && k > 0; k--) {
                        temp2[j] = temp1[k] + temp2[j];
                    }
                } else {
                    temp1[j] = 0;
                    for (int k = j - 1; k >= j - 6 && k > 0; k--) {
                        temp1[j] = temp2[k] + temp1[j];
                    }
                }
            }
        }

        int[] temp3;
        double[] ratio = new double[maxSum];
        if (n % 2 == 0) temp3 = temp2;
        else temp3 = temp1;

        int total = (int) Math.pow(6,n);
        for (int i=0; i<maxSum; i++){
            ratio[i] = (double)temp3[i]/total;
        }
        return ratio;
    }
}
