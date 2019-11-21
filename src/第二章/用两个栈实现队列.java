package 第二章;

import java.util.Stack;

public class 用两个栈实现队列 {
    public static void main(String[] args) throws Exception {
        Cqueue cqueue = new Cqueue();
        //System.out.println(cqueue.pull());
        cqueue.add(1);
        cqueue.add(2);
        System.out.println(cqueue.pull());
        System.out.println(cqueue.pull());
        System.out.println(cqueue.pull());

    }
    public static class Cqueue{
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        public Cqueue(){
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }
        public void add(int a){
            stack1.push(a);
        }
        public int pull() throws Exception {
            if (stack1.size()==0 && stack2.size()==0) throw new Exception("队列里没有数了");
            if (stack2.size()!=0){
                int res = stack2.pop();
                return res;
            }else {
                while (stack1.size()!=0){
                    int temp = stack1.pop();
                    stack2.push(temp);
                }
                return stack2.pop();
            }
        }
    }
}
