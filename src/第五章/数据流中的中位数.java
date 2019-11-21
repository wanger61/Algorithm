package 第五章;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 数据流中的中位数 {
    public static void main(String[] args) {
        DynamicArray array = new DynamicArray();
        array.insert(4);
        System.out.println(array.getMedian());
        array.insert(7);
        System.out.println(array.getMedian());
        array.insert(9);
        System.out.println(array.getMedian());
        array.insert(10);
        System.out.println(array.getMedian());
    }
    public static class DynamicArray{

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        public DynamicArray(){

        }
        public void insert(int num){
            if (((maxHeap.size()+minHeap.size())&1) == 0){
                if (minHeap.size()>0 && num > minHeap.peek()){
                    Integer temp = minHeap.poll();
                    minHeap.add(num);
                    num = temp;
                }
                maxHeap.add(num);
            }else {
                if (maxHeap.size()>0 && num < maxHeap.peek()){
                    Integer temp = maxHeap.poll();
                    maxHeap.add(num);
                    num = temp;
                }
                minHeap.add(num);
            }
        }
        public int getMedian(){
            if ( maxHeap.size()+minHeap.size() == 0 )  throw new RuntimeException("没有值");
            if (((maxHeap.size()+minHeap.size())&1) == 1){
                return maxHeap.peek();
            }else {
                return (maxHeap.peek() + minHeap.peek())/2;
            }
        }
     }
}
