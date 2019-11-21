package 第三章;

import java.util.Objects;

public class 删除链表中重复的节点 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(5);
        deleteDuplicated(head);
        printList(head);
        System.out.print('\n');
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(3);
        head2.next.next.next.next = new Node(4);
        deleteDuplicated(head);
        printList(head2);
    }

    private static void printList(Node head) {
        while (head!=null){
            System.out.print(head.data);
            head = head.next;
        }
    }

    private static void deleteDuplicated(Node head) {
        if (head==null) return;
        Node preNode = head;
        Node current = head;
        while (current!=null){
            if (current.next==null||!current.next.equals(current)){
                preNode = current;
                current = current.next;
            }else {
                while (current.next.equals(current)){
                    current = current.next;
                }
                current = current.next;
                if(preNode!=head) preNode.next = current;
                else {head = current;}; //不能解决问题，需要再加一个头节点

            }
        }

    }

    private static class Node{
        int data;
        Node next;

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
