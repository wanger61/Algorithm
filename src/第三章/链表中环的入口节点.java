package 第三章;

public class 链表中环的入口节点 {
    public static void main(String[] args) {
        Node head = new Node();
        head.next = new Node(1);
        head.next.next = new Node(2);
        Node tar = new Node(3);
        head.next.next.next = tar;
        tar.next = new Node(4);
        tar.next.next = new Node(5);
        tar.next.next.next = new Node(6);
        tar.next.next.next.next = tar;
        Node loopNode = findLoopNode(head);
        System.out.print(loopNode);
    }

    private static Node findLoopNode(Node head) {
        Node node = findLoop(head);
        if (node == null) return null;
        else {
            int loopSize = 1;
            Node pre = node;
            node = node.next;
            while ( node!=pre){
                node = node.next;
                loopSize++;
            }
            Node first = head;
            Node last = head;
            for (int i=0 ; i<loopSize; i++){
                first = first.next;
            }
            while (first!=last){
                first = first.next;
                last = last.next;
            }
            return first;
        }
    }

    private static Node findLoop(Node head) {
        if (head == null) return null;
        if (head.next == null ) return null;
        Node plow = head.next;
        Node pfast = head.next.next;
        while ( plow!=null && pfast!=null){
            if(plow == pfast) return plow;
            plow = plow.next;
            pfast = pfast.next;
            if (pfast!=null) pfast = pfast.next;
        }
        return null;
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
