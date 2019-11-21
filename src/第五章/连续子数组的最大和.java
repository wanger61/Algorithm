package 第五章;

public class 连续子数组的最大和 {
    public static void main(String[] args) {
        int[] array = new int[]{1,-2,3,10,-4,7,2,-5};
        int maxSum = findGreatestSumOfArray(array);
        System.out.println(maxSum);
    }

    private static int findGreatestSumOfArray(int[] array) {
        if (array == null || array.length <= 0 ) return 0;
        int index = 0;
        int sum = 0;
        int max = 0;
        for (;index<array.length; index++){
            if (array[index] >= 0){
                sum = sum + array[index];
            }
            else {
                if (sum > max){
                    max = sum;
                }
                sum = sum + array[index];
                if (sum < 0) sum = 0;
            }
        }
        return max;
    }
}
