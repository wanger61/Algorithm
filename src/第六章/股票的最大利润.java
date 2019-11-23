package 第六章;

public class 股票的最大利润 {
    public static void main(String[] args) {
        int[] array = new int[]{9, 11, 8, 5, 7, 12, 16, 14};
        int res = theMaxProfit(array);
        System.out.println(res);
    }

    private static Integer theMaxProfit(int[] array) {
        if (array == null || array.length <= 0) return null;
        int buy = array[0];
        int sell = array[0];
        int max = 0;
        for (int i = 1; i <= array.length - 1; i++) {
            if (array[i] < buy) {
                if (sell - buy > max) max = sell - buy;
                buy = array[i];
                sell = array[i];
            } else if (array[i] > sell) sell = array[i];
        }
        if (sell - buy > max) max = sell - buy;
        return max;
    }
}
