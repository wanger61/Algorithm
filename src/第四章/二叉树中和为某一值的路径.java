package 第四章;

import java.util.ArrayList;
import java.util.LinkedList;

public class 二叉树中和为某一值的路径 {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(12);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        int expectSum = 22;
        PathofSum(root,expectSum);
    }

    private static void PathofSum(Node root, int expectSum) {
        if (root == null) return;
        Integer currentSum = 0;
        LinkedList<Integer> path = new LinkedList<>();
        isPathOfSum(root,expectSum,path,currentSum);
    }

    private static void isPathOfSum(Node root, int expectSum, LinkedList<Integer> path, int currentSum) {
        path.add(root.data);
        currentSum = currentSum + root.data;
        if (root.left == null && root.right == null){
            if (currentSum == expectSum){
                System.out.println("this is a path:");
                for (int i : path){
                    System.out.println(i);
                }
            }
        }else {
            isPathOfSum(root.left, expectSum, path, currentSum);
            isPathOfSum(root.right, expectSum, path, currentSum);
        }
        currentSum = currentSum - root.data;
        path.removeLast();
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
