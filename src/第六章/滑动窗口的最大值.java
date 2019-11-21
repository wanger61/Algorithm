package 第六章;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class 滑动窗口的最大值 {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        int windowSize = 3;
        ArrayList<Integer> res = maxInWindow(array, windowSize);
        System.out.println(res);
    }

    private static ArrayList<Integer> maxInWindow(int[] array, int size) {
        if (array == null || size <= 0) return null;
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            while (!queue.isEmpty() && array[i] > array[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }
        for (int i = size; i < array.length; i++) {
            list.add(array[queue.peek()]);
            while (!queue.isEmpty() && array[i] > array[queue.getLast()]) {
                queue.removeLast();
            }
            if (!queue.isEmpty() && i - queue.peek() >= size) {
                queue.removeFirst();
            }
            queue.addLast(i);
        }
        list.add(array[queue.peek()]);
        return list;
    }
}
