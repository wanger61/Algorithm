package 第四章;

public class 二叉搜索树与双向链表 {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(6);
        root.right = new Node(14);
        root.left.left = new Node(4);
        root.left.right = new Node(8);
        root.right.left = new Node(12);
        root.right.right = new Node(16);
        Node head = convertTreeToList(root);
        System.out.println(head);
    }

    private static Node convertTreeToList(Node root) {
        if (root == null) return null;
        vec lastNodeinList = new vec();
        convert(root,lastNodeinList);
        Node listHead = lastNodeinList.value;
        while (listHead != null && listHead.left != null){
            listHead = listHead.left;
        }
        return listHead;
    }

    private static void convert(Node root, vec lastNodeinList) {
        Node current = root;
        if (current.left != null){
            convert(current.left,lastNodeinList);
        }
        current.left = lastNodeinList.value;
        if(lastNodeinList.value != null){
            lastNodeinList.value.right = current;
        }
        lastNodeinList.value = current;
        if (lastNodeinList.value.right != null){
            convert(lastNodeinList.value.right,lastNodeinList);
        }

    }

    private static class vec{
        Node value;
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
