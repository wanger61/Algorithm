package 第四章;

public class 对称的二叉树 {
    public static void main(String[] args) {
        Node head = new Node(8);
        head.left = new Node(6);
        head.right = new Node(6);
        head.left.left = new Node(5);
        head.left.right = new Node(7);
        head.right.left = new Node(7);
        head.right.right = new Node(3);
        boolean res = isSymmetrical(head);
        System.out.println(res);
    }

    private static boolean isSymmetrical(Node head) {
        return isSymmetrical(head,head);
    }

    private static boolean isSymmetrical(Node root1,Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 ==null || root2==null ) return false;
        if (root1.data != root2.data) return false;
        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
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
