package 第二章;

import java.util.Stack;

public class 从尾到头打印链表 {
    public static void turnOverPrint(Node p){
        Stack<Integer> stack = new Stack<>();
        while (p!=null){
            stack.push(p.data);
            p = p.next;
        }
        while (!stack.isEmpty()){
            Integer a = stack.pop();
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        Node p = new Node();
        Node p2 = new Node();
        Node p3 = new Node();
        p.data = 1;
        p2.data = 2;
        p3.data = 3;
        p.next = p2;
        p2.next = p3;
        turnOverPrint(p);
    }

    static class Node{
        int data;
        Node next;
    }
}
