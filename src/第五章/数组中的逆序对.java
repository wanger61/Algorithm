package 第五章;

public class 数组中的逆序对 {
    public static void main(String[] args) {
        int[] array = new int[]{7,5};
        int res = InversePair(array);
        System.out.print(res);
    }

    private static int InversePair(int[] array) {
        if (array == null || array.length<=0) return 0;
        int[] copy = new int[array.length];
        return InversePairCore(array,copy,0,array.length-1);
    }

    private static int InversePairCore(int[] array, int[] copy, int start, int end) {
        if (start == end){
            copy[start] = array[start];
            return 0;
        }

        int length = (end-start)/2;
        int left = InversePairCore(copy,array,start,start+length);
        int right = InversePairCore(copy,array,start+length+1,end);

        int count = 0;
        int i = start + length;
        int j = end;
        int copyindex = end;
        while (i>=start && j>=start+length+1){
            if (array[i] > array[j]){
                copy[copyindex--] = array[i--];
                count = count + j - start - length;
            }else {
                copy[copyindex--] = array[j--];
            }
        }
        while (i>=start){
            copy[copyindex--] = array[i--];
        }
        while (j>=start+length+1){
            copy[copyindex--] = array[j--];
        }
        return count + left + right;
    }
}
