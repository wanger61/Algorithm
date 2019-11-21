package 第四章;

public class 复杂链表的复制 {
    public static void main(String[] args) {
        Node A = new Node(1);
        Node B = new Node(2);
        Node C = new Node(3);
        Node D = new Node(4);
        Node E = new Node(5);
        A.next = B;
        A.pSibling = C;
        B.next = C;
        B.pSibling = E;
        C.next = D;
        D.next = E;
        D.pSibling = B;

        Node newhead = cloneList(A);
        while (newhead!=null){
            System.out.println(newhead.data);
            newhead = newhead.next;
        }
    }

    private static Node cloneList(Node head) {
        if (head == null) return null;
        Node current = head;
        while (current.next != null){
            Node newNode = new Node(current.data);
            newNode.next = current.next;
            current.next = newNode;
            current = current.next.next;
        }
        Node newNode = new Node(current.data);
        current.next = newNode;

        Node current2 = head;
        while (current2 != null){
            if (current2.pSibling != null){
                current2.next.pSibling = current2.pSibling.next;
            }
            current2 = current2.next.next;
        }

        Node newhead = head.next;
        Node current3 = newhead;
        while (current3 != null && current3.next!=null){
            current3.next = current3.next.next;
            current3 = current3.next;
        }
        return newhead;
    }

    private static class Node{
        int data;
        Node next;
        Node pSibling;

        public Node(int data) {
            this.data = data;
        }
    }
}

