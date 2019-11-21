package 第三章;

public class 删除链表中的节点 {
    public static void main(String[] args) {
        Node head = new Node();
        Node target  =new Node();
        deleteNode(head,target);

    }

    private static void deleteNode(Node head, Node target) {
        if (head==null || target == null) return;
        if (target.next!=null){
            Node next = target.next;
            target.data = next.data;
            target.next = next.next;
        }else {
            if (target.equals(head)){
                target = null;
                head = null;
            }
            else {
                Node current = head;
                while (!current.next.equals(target)){
                    current = current.next;
                }
                current.next = null;
            }
        }
    }

    private static class Node{
        int data;
        Node next;
    }
}
