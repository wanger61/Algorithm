package 第四章;

import java.util.Stack;

public class 包含min函数的栈 {
    public static void main(String[] args) {
        StackWithMin s = new StackWithMin();
        s.push(3);
        System.out.println(s.min());
        s.push(4);
        System.out.println(s.min());
        s.push(2);
        System.out.println(s.min());
        s.push(1);
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.push(0);
        System.out.println(s.min());

    }
    public static class StackWithMin{
        Stack<Integer> stack_main;
        Stack<Integer> stack_min;
        public StackWithMin(){
            stack_main = new Stack<>();
            stack_min = new Stack<>();
        }
        public void push(int data){
            stack_main.push(data);
            if (stack_min.size()==0 || stack_min.peek()>data){
                stack_min.push(data);
            }else {
                stack_min.push(stack_min.peek());
            }
        }
        public Integer pop(){
            if (stack_min.size()>0 && stack_main.size()>0) {
                stack_min.pop();
                return stack_main.pop();
            }
            return null;
        }
        public Integer min(){
            if (stack_min.size()>0) return stack_min.peek();
            else return null;
        }
    }
}
