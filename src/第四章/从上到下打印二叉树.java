package 第四章;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 从上到下打印二叉树 {
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.right = new Node(10);
        root.left.left = new Node(5);
        root.left.right = new Node(7);
        root.right.left = new Node(9);
        root.right.right = new Node(11);
        //printFromToptoBottom(root);
        //printFromToptoBottomAsRow(root);
        printFromToptoBottomAsZ(root);

    }

    private static void printFromToptoBottom(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.println(node.data);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
    }

    private static void printFromToptoBottomAsRow(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int nextlevel = 0;
        int toBePrint = 1;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            toBePrint--;
            System.out.print(node.data);
            System.out.print(' ');
            if (node.left != null){
                queue.add(node.left);
                nextlevel++;
            }
            if (node.right != null){
                queue.add(node.right);
                nextlevel++;
            }
            if (toBePrint == 0){
                System.out.println();
                toBePrint = nextlevel;
            }
        }
    }

    private static void printFromToptoBottomAsZ(Node root) {
        if (root == null) return;
        Stack<Node>[] stack = new Stack[2];
        stack[0] = new Stack<>();
        stack[1] = new Stack<>();
        stack[0].push(root);
        while (!stack[0].isEmpty() || !stack[1].isEmpty()){
            if (!stack[0].isEmpty()){
                while (!stack[0].isEmpty()) {
                    Node node = stack[0].pop();
                    System.out.print(node.data);
                    System.out.print(' ');
                    if (node.left != null) {
                        stack[1].push(node.left);
                    }
                    if (node.right != null){
                        stack[1].push(node.right);
                    }
                }
                System.out.println();
            }
            else{
                while (!stack[1].isEmpty()) {
                    Node node = stack[1].pop();
                    System.out.print(node.data);
                    System.out.print(' ');
                    if (node.right != null) {
                        stack[0].push(node.right);
                    }
                    if (node.left != null){
                        stack[0].push(node.left);
                    }
                }
                System.out.println();
            }
        }

    }

    private static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
