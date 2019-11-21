package 第六章;

public class 数组中数值和下标相等的元素 {
    public static void main(String[] args) {
        int[] array = new int[]{-3,-1,1,3,5};
        int res = indexEqualsNum(array,0,array.length-1);
        System.out.print(res);
    }

    private static Integer indexEqualsNum(int[] array, int start, int end) {
        if (array == null || array.length <=0) return null;
        while (start < end){
            int mid = (start + end)/2;
            if (array[mid] == mid) return array[mid];
            else if (array[mid] > mid){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return -1;
    }
}
