package 第三章;

public class 链表中倒数第k个节点 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        int k = 0;
        Node res = findKthToTail(head,k);
        System.out.print(res);
    }

    private static Node findKthToTail(Node head, int k) {
        if (head == null) throw new RuntimeException("Invalid input");
        if (k<=0) throw new RuntimeException("Invalid input");
        int first = 0;
        Node current = head;
        Node last = head;
        for(; first<k-1; first++){
            current = current.next;
            if (current == null) throw new RuntimeException("Invalid input");
        }
        while (current.next!=null){
            current = current.next;
            last = last.next;
        }
        return last;
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
                    '}';
        }
    }
}
