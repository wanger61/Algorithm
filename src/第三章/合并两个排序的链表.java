package 第三章;

public class 合并两个排序的链表 {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        //head1.next = new Node(3);
        //head1.next.next = new Node(5);
        Node head2 = new Node(2);
        //head2.next = new Node(4);
        //head2.next.next = new Node(6);
        Node newhead = merge(head1,head2);
        while (newhead!=null){
            System.out.println(newhead.data);
            newhead = newhead.next;
        }
    }

    private static Node merge(Node head1, Node head2) {
        if (head1 == null && head2 == null) return null;
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        Node p1 = head1;
        Node p2 = head2;
        Node newhead;
        Node tail;
        if (p1.data <= p2.data) { newhead = p1; tail = p1; p1 = p1.next; }
        else { newhead = head2; tail = p2; p2 = p2.next;}
        while (p1!=null && p2!=null){
            if (p1.data <= p2.data){
                tail.next = p1;
                tail = p1;
                p1 = p1.next;
            }else {
                tail.next = p2;
                tail = p2;
                p2 = p2.next;
            }
        }
        if (p1 != null){
            tail.next = p1;
        }
        if (p2 != null){
            tail.next = p2;
        }
        return newhead;

    }

    private static class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }

        public Node() {

        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
