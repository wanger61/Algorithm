package 第四章;

public class 二叉树镜像 {
    public static void main(String[] args) {
        Node head = new Node(8);
        head.left = new Node(6);
        head.right = new Node(10);
        head.left.left = new Node(5);
        head.left.right = new Node(7);
        head.right.left = new Node(9);
        head.right.right = new Node(11);
        Mirror(head);
    }

    private static void Mirror(Node head) {
        if (head == null) return;
        exchange(head);
    }

    private static void exchange(Node current) {
        if (current == null) return;
        Node temp = current.left;
        current.left = current.right;
        current.right = temp;
        exchange(current.left);
        exchange(current.right);
    }

    private static void exchange(Node left, Node right) {
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
