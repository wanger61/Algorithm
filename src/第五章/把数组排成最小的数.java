package 第五章;

import java.util.Arrays;
import java.util.Comparator;

public class 把数组排成最小的数 {
    public static void main(String[] args) {
        //Integer[] array = new Integer[]{3,32,321,9};
        Integer[] array = new Integer[]{123,789,456,9};
        PrintMinNum(array);
    }

    private static void PrintMinNum(Integer[] array) {
        if (array == null || array.length<=0) return;
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String so1 = o1 + "";
                String so2 = o2 + "";
                int i = (so1 + so2).compareTo(so2 + so1);
                if (i >0) return 1;
                else if (i <0) return -1;
                else return 0;
            }
        });
        for (int i=0; i<=array.length-1; i++){
            System.out.print(array[i]);
        }
    }
}
