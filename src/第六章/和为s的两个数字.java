package 第六章;

public class 和为s的两个数字 {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,4,7,11,15};
        int s = 15;
        int[] res = sumOfs(array,s);
        for (int i=0; i<=1; i++){
            System.out.println(res[i]);
        }
    }

    private static int[] sumOfs(int[] array, int s) {
        if (array == null || array.length <= 0) return null;
        int head = 0;
        int[] res = new int[2];
        int tail = array.length-1;
        while (head < tail){
            if (array[head]+array[tail] == s){
                res[0] = array[head];
                res[1] = array[tail];
                return res;
            }else if (array[head]+array[tail] < s){
                head++;
            }else {
                tail--;
            }
        }
        return res;
    }
}
