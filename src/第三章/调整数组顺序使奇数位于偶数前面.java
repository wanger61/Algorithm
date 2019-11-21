package 第三章;

import java.util.Arrays;

public class 调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5};
        reoreder(array);
        System.out.print(Arrays.toString(array));
    }

    private static void reoreder(int[] array) {
        if (array == null || array.length == 0 || array.length ==1) return;
        int pre = 0;
        int last = array.length-1;
        while (pre < last){
            while ( pre<last && (array[pre]&0x1)!=0 ){
                pre++;
            }
            while ( pre<last && (array[last]&0x1)==0){
                last--;
            }
            if (pre < last){
                int temp = array[pre];
                array[pre] = array[last];
                array[last] = temp;
            }
        }

    }
}
