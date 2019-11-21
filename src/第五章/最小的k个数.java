package 第五章;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 最小的k个数 {
    public static void main(String[] args) {
        int k = 4;
        int[] array = new int[]{4,5,1,6,2,7,3,8};
        ArrayList<Integer> result = theMinkOfArray(array,k);
        System.out.println(result);
    }

    private static ArrayList<Integer> theMinkOfArray(int[] array, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length <= 0) throw new RuntimeException("Invalid input");
        if (k == 0) return null;
        if (array.length < k) throw new RuntimeException("Invalid input");
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i=0; i < array.length; i++){
            if (queue.size()<k){
                queue.add(array[i]);
            }
            else {
                if (queue.peek() > array[i]){
                    queue.poll();
                    queue.add(array[i]);
                }
            }
        }
        for (int i=1; i<=k; i++){
            Integer min = queue.poll();
            result.add(min);
        }
        return result;
    }
}
