package 第六章;

public class 缺失的数字 {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3};
        int res = MissingNum(array,0,array.length-1);
        System.out.print(res);
    }

    private static Integer MissingNum(int[] array, int start, int end) {
        if(array == null || array.length <= 0) return null;
        if (start > end) return null;
        int mid = (start + end)/2;
        if (array[mid] == mid){
            start = mid+1;
            if (start == array.length) return array.length;
        }else {
            if (mid>0 && array[mid-1] == mid-1) return mid;
            else {
                end = mid - 1;
                if (end < 0) return 0;
            }
        }
        //不应该这么写，应该用while循环
        return MissingNum(array,start,end);
    }


}
