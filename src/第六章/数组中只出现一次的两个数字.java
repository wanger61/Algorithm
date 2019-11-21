package 第六章;

public class 数组中只出现一次的两个数字 {
    public static void main(String[] args) {
        int[] array = new int[]{2,3};
        int[] res = new int[2];
        res = onceNum(array);
        for (int i=0; i<2; i++){
            System.out.println(res[i]);
        }
    }

    private static int[] onceNum(int[] array) {
        if (array == null || array.length<=0) return null;
        int bit = array[0];
        for (int i=1; i<array.length; i++){
            bit = bit^array[1];
        }
        int indexOf1 = indexOf1(bit);
        int num1 = 0;
        int num2 = 0;
        for (int i=0 ; i<array.length; i++){
            if (isIndex1(array[i],indexOf1)) num1 = num1^array[i];
            else  num2 = num2^array[i];
        }
        return new int[]{num1,num2};
    }

    private static boolean isIndex1(int k, int index) {
        k = k >> index;
        return ((k&1) == 0);
    }

    private static int indexOf1(int bit) {
        if (bit == 0) throw new RuntimeException("Invalid input");
        int index = 0;
        while (((bit&1) == 0) && index < 8*4){
            bit = bit >> 1;
            index++;
        }
        return index;
    }

}
