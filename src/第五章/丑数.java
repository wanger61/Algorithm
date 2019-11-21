package 第五章;

public class 丑数 {
    public static void main(String[] args) {
        int k = 1;
        int res = findUglyNumber(k);
        System.out.print(res);
    }

    private static int findUglyNumber(int k) {
        if (k<=0) throw new RuntimeException("Invalid Input");
        int[] uglyArray = new int[k];
        uglyArray[0] = 1;
        int indexOf2 = 0; int indexOf3 = 0; int indexOf5 = 0;
        for (int i=1; i<k; i++){
            int minOf2 = uglyArray[indexOf2]*2;
            int minOf3 = uglyArray[indexOf3]*3;
            int minOf5 = uglyArray[indexOf5]*5;
            if (minOf2 <= minOf3 && minOf2 <= minOf5){
                uglyArray[i] = minOf2;
            }else if (minOf3 < minOf2 && minOf3 <= minOf5){
                uglyArray[i] = minOf3;
            }else {
                uglyArray[i] = minOf5;
            }
            while (uglyArray[indexOf2]*2 <= uglyArray[i]){
                indexOf2++;
            }
            while (uglyArray[indexOf3]*3 <= uglyArray[i]){
                indexOf3++;
            }
            while (uglyArray[indexOf5]*5 <= uglyArray[i]){
                indexOf5++;
            }
        }
        return uglyArray[k-1];
    }
}
