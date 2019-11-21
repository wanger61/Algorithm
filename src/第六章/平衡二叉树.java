package 第六章;

public class 平衡二叉树 {
    public static void main(String[] args) {
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.left.right.left = new Node(7);
//        root.left.right.left.left = new Node(7);
//        root.right = new Node(3);
//        root.right.right = new Node(6);
        Node root = new Node(1);
        int res = isBalance(root);
        if (res == -1) System.out.print("Not balance");
        else System.out.print("Is balance");
    }

    private static int isBalance(Node root) {
        if (root == null) return 0;
        int left = isBalance(root.left);
        if (left == -1) return -1;
        int right = isBalance(root.right);
        if (right == -1) return -1;
        int diff = left - right;
        if (diff >1 || diff<-1) return -1;
        return Math.max(left,right)+1;
    }

    private static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
