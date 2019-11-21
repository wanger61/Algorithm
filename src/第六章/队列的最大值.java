package 第六章;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 队列的最大值 {
    private Queue<speData> queue;
    private Deque<speData> maxQueue;
    int currentIndex;

    public 队列的最大值() {
        maxQueue = new LinkedList<speData>();
        queue = new LinkedList<speData>();
        currentIndex = 0;
    }

    public void push(int i) {
        speData data = new speData(currentIndex, i);
        while (!maxQueue.isEmpty() && maxQueue.getLast().data < i) {
            maxQueue.removeLast();
        }
        currentIndex++;
        maxQueue.addLast(data);
        queue.add(data);
    }

    public int pop() {
        if (queue.isEmpty()) throw new RuntimeException("Queue is empty");
        if (!maxQueue.isEmpty() && queue.peek().index == maxQueue.peek().index) {
            maxQueue.pop();
        }
        return queue.poll().data;
    }

    public int max() {
        if (maxQueue.isEmpty()) throw new RuntimeException("queue is empty");
        return maxQueue.getFirst().data;
    }

    private class speData {
        int index;
        int data;

        public speData(int index, int data) {
            this.index = index;
            this.data = data;
        }
    }


    @Test
    public void test1() {
        队列的最大值 queue = new 队列的最大值();
        queue.push(5);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(2);
        queue.push(2);
        System.out.println(queue.max());
        queue.pop();
        System.out.println(queue.max());
    }
}

