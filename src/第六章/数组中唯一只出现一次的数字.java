package 第六章;

public class 数组中唯一只出现一次的数字 {
    public static void main(String[] args) {
        int[] array = new int[]{-2,-3,-5,-2,-3,-3,-2};
        int res = onceNum(array);
        System.out.print(res);
    }

    private static Integer onceNum(int[] array) {
        if (array == null || array.length <= 0) return null;
        int[] bitarray = new int[32];
        for (int i=0 ; i<array.length; i++) {
            int bitindex = 0;
            while (bitindex <= 31){
                if ((array[i]&1)!=0){
                    bitarray[bitindex]++;
                }
                bitindex++;
                array[i] = array[i]>>1;
            }
        }
        int res = 0;
        for (int i=31; i>=0; i--){
            res = res << 1;
            res = res + bitarray[i]%3;
        }
        return res;
    }
}
