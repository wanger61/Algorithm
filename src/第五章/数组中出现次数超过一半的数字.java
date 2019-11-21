package 第五章;

import java.util.HashMap;

public class 数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,2,2,2,5,4,2};
        int[] array2 = new int[]{1,2,3,4,5};
        int res = moreThanHalf2(array);
        System.out.print(res);
        int res2 = moreThanHalf2(array2);
        System.out.print(res2);
    }

    private static int moreThanHalf(int[] array) {
        if (array == null || array.length ==0) throw new RuntimeException("Invalid input");
        int result = array[0];
        int times = 1;
        for (int i=1; i<array.length; i++){
            if (times == 0){
                result = array[i];
                times = 1;
            }
            else if (array[i] == result){
                times++;
            }else {
                times--;
            }
        }
        checkTheResMoreThanHalf(array,result);
        return result;
    }

    private static int moreThanHalf2(int[] array){
        int start = 0;
        int end = array.length-1;
        int index = Partition(array,start,end);
        while (index != array.length/2){
            if (index > array.length/2){
                end = index-1;
                index = Partition(array,start,end);
            }else {
                start = index+1;
                index = Partition(array,start,end);
            }
        }
        int result = array[index];
        checkTheResMoreThanHalf(array,result);
        return result;
    }

    private static int Partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start-1;
        int j = end;
        while (i < j){
            while (array[++i] < pivot){}
            while (array[--j] > pivot){}
            if (i < j){
                Swap(array,i,j);
            }
        }
        Swap(array,i,end);
        return i;
    }

    private static void Swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }



    private static void checkTheResMoreThanHalf(int[] array, int result) {
        int sum = 0;
        for (int i=0; i<array.length; i++){
            if (array[i] == result){
                sum++;
            }
        }
        if (sum < array.length/2){
            throw new RuntimeException("Invalid input");
        }
    }
}
