package 第三章;

import java.util.Objects;

public class 树的子结构 {
    public static void main(String[] args) {
        Node head1 = new Node(8);
        head1.left = new Node(8);
        head1.right = new Node(7);
        head1.left.left = new Node(9);
        head1.left.right = new Node(2);
        head1.left.right.left = new Node(4);
        head1.left.right.right = new Node(7);
        Node head2 = new Node(8);
        head2.left = new Node(9);
        head2.right = new Node(2);
        boolean res = isInTree(head1,null);
        System.out.println(res);
    }

    private static boolean isInTree(Node head1, Node head2) {
        if (head1 == null || head2 == null) return false;
        boolean isInTree = check(head1,head2);
        if(isInTree) return true;
        else return check(head1.left,head2)||check(head1.right,head2);
    }

    private static boolean check(Node head1, Node head2) {
        if (head2 == null) return true;
        if (head1 == null) return false;
        if(head1.data == head2.data){
            return check(head1.left, head2.left) && check(head1.right, head2.right);
        }
        return false;
    }

    private static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return data == node.data;
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }
    }
}
