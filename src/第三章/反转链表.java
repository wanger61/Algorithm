package 第三章;

public class 反转链表 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Node current = head;
        while (current!=null){
            System.out.print(current.data);
            current = current.next;
        }
        System.out.println(' ');
        Node newhead = reverse(head);
        Node current2 = newhead;
        while (current2!=null){
            System.out.print(current2.data);
            current2 = current2.next;
        }
        Node newhead2 = reverse(null);
        System.out.println(newhead2);
        Node head3 = new Node(1);
        Node newhead3 = reverse(head3);
        System.out.println(newhead3);

    }

    private static Node reverse(Node head) {
        if (head == null) return null;
        Node first = head;
        Node mid = head.next;
        if (mid == null) return head;
        Node last = mid.next;
        first.next = null;
        while (last!=null){
            mid.next = first;
            first = mid;
            mid = last;
            last = last.next;
        }
        mid.next = first;
        head = mid;
        return mid;
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
