package 第二章;

import java.util.Objects;

public class 二叉树的下一个节点 {
    public static void main(String[] args) {
        Node target = new Node('e');
        Node res = getNext(target);
    }

    private static Node getNext(Node e) {
        if (e == null)return null;
        if (e.right!=null){
            Node current = e.right;
            while (current.left!=null){
                current = current.left;
            }
            return current;
        }else {
            if (e.parent == null) return null;
            Node current = e.parent;
            while (current != null && current.parent.right == current) {
                    current = current.parent;
            }
            if (current == null) return null;
            return current.parent;
        }
    }

    private static class Node{
        char data;
        Node left;
        Node right;
        Node parent;

        public Node(char data) {
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
