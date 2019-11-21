package 第六章;

public class 数字在排序数组中出现的次数 {
    public static void main(String[] args) {
        //int[] array = new int[]{1,2,3,3,3,3,4,6}
        int[] array = new int[]{1};
        int k = 1;
        int res = timesOfkInArray(k,array);
        System.out.print(res);
    }

    private static int timesOfkInArray(int k, int[] array) {
        if (array==null || array.length<=0) return -1;
        if (k<array[0] || k>array[array.length-1]) return -1;
        int left = FirstIndexOfk(k,array,0,array.length-1);
        int right = LastIndexOfk(k,array,0,array.length-1);
        if (right!= -1 && left!=-1) return right - left + 1;
        else return -1;
    }

    private static int LastIndexOfk(int k, int[] array, int start, int end) {
        if (start == end) {
            if (array[start] == k) return start;
            else return -1;
        }
        int mid = (start+end)/2;
        if (k > array[mid]){
            start = mid + 1;
        }else if (k < array[mid]){
            end = mid - 1;
        }else {
            if (array[mid+1] != k) return mid;
            else start = mid+1;
        }
        return LastIndexOfk(k,array,start,end);
    }

    private static int FirstIndexOfk(int k, int[] array, int start, int end) {
        if (start == end) {
            if (array[start] == k) return start;
            else return -1;
        }
        int mid = (start+end)/2;
        if (k > array[mid]){
            start = mid + 1;
        }else if (k < array[mid]){
            end = mid - 1;
        }else {
            if (array[mid-1] != k) return mid;
            else end = mid-1;
        }
        return FirstIndexOfk(k,array,start,end);
    }


}
