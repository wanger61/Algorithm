package 第二章;

public class 旋转数组的最小数字 {
    public static void main(String[] args) throws Exception {
        int[] array = new int[]{3,4,5,1,2};
        int res = Min(array);
        System.out.println(res);
        int[] array2 = new int[]{1};
        int res2 = Min(array);
        System.out.println(res);
    }

    private static int Min(int[] array) throws Exception {
        if(array==null || array.length ==0) throw new Exception("这不是个数组！");
        int low = 0;
        int high = array.length-1;
        if(array[low]<array[high]) return array[low];
        while (true){
            if (high-low == 1) return array[high];
            int mid = (low + high)/2 ;
            if (array[mid] >= array[low]){ low = mid;}
            if (array[mid] < array[low]){ high = mid; }
            if (array[mid] == array[low] && array[high] == array[low]){
                return MininOrder(array,low,high);}
    }
}

    private static int MininOrder(int[] array, int low, int high) {
        int res = array[low];
        for (int i=low+1; i<=high; i++){
            if(res > array[i]){res = array[i];}
        }
        return res;
    }


    }
