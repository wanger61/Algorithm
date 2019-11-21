package 第四章;

import java.util.Arrays;

public class 二叉搜索树的后序遍历数列 {
    public static void main(String[] args) {
        int[] array = new int[]{5,7,6,9,11,10,8};
        int[] array1 = new int[]{7,4,6,5};
        int[] array2 = new int[]{1,2,3,4,5};
        boolean res = isAfterorder(array2);
        System.out.println(res);
    }

    private static boolean isAfterorder(int[] array) {
        if (array == null || array.length == 0 ) return false;
        if (array.length == 1) return true;
        return isAfterorder(array,0,array.length-1);
    }

    private static boolean isAfterorder(int[] array, int start, int end) {
        if (start == end) return true;
        int root = array[end];
        int index = start;
        for (; index<=end-1; index++){
            if (array[index] > root) break;
        }
        boolean leftIsAfterOrder = true;
        if (index > 0) leftIsAfterOrder = isAfterorder(array,start,index-1);
        boolean rightIsAfterOrder = true;
        if (index < end){
            for (int i=index; i<end; i++){
                if (array[i] < root) return false;
            }
            rightIsAfterOrder = isAfterorder(array,index,end-1);
        }
        return leftIsAfterOrder && rightIsAfterOrder;

    }
}
