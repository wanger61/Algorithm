package 第六章;

public class 二叉搜索树的第k大节点 {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right = new Node(7);
        root.right.left = new Node(6);
        root.right.right = new Node(8);
        Node res = kthNode(root,3);
        System.out.print(res);
    }

    private static Node kthNode(Node root, int k) {
        if(root == null || k==0) return null;
        int[] deck = new int[]{k};
        return kthNodeCore(root,deck);
    }

    private static Node kthNodeCore(Node root, int[] deck) {
        Node target = null;
        if (root.left != null){
            target = kthNodeCore(root.left,deck);
        }
        if (target == null){
            if (deck[0] == 1) return root;
            deck[0]--;
        }
        if (target == null && root.right!=null){
            target = kthNodeCore(root.right,deck);
        }
        return target;
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
