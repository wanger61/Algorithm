package 第五章;

public class 两个链表的第一个公共节点 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        Node node3 = new Node(6);
        Node node4 = new Node(7);
        node3.next = node4;
        node1.next.next.next = node3;
        Node node2 = new Node(4);
        node2.next = new Node(5);
        node2.next.next = node3;
        Node res = commonNode(node1,node2);
        System.out.print(res);
    }

    private static Node commonNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) return null;
        int length1 = 0;
        int length2 = 0;
        Node current1 = node1;
        Node current2 = node2;
        while (current1!=null){
            length1++;
            current1 = current1.next;
        }
        while (current2!=null){
            length2++;
            current2 = current2.next;
        }
        int dif = length1 - length2;
        if (dif > 0){
            for (int i=0; i<dif; i++){
                node1 = node1.next;
            }
        }else if (dif < 0){
            for (int i=0; i<dif; i++){
                node2 = node2.next;
            }
        }
        Node res = commonNodeCore(node1,node2);
        return res;
    }

    private static Node commonNodeCore(Node node1, Node node2) {
        while (node1!=node2 && node1!=null && node2!=null){
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

    private static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
}
