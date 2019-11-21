package 第四章;

public class 序列化二叉树2 {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        String s = Serialize(root);
        System.out.println(s);
        Node node = DeSerialize(s,new int[]{0});
        System.out.println(node);
    }

    //用Interge类型传递仍然是按值传递，需要选择数组类型传递整数
    private static Node DeSerialize(String s, int[] index) {
        if (s == null || s.length() == 0) return null;
        Node node = null;
        int start = index[0];
        while (s.charAt(index[0]) != ','){
           index[0]++;
        }
        if(!s.substring(start,index[0]).equals("$")){
            node = new Node(Integer.parseInt(s.substring(start,index[0])));
            index[0]++;
            node.left = DeSerialize(s,index);
            node.right = DeSerialize(s,index);
        }else {
            index[0]++;
            return null;
        }
        return node;
    }

    private static String Serialize(Node root) {
        if (root == null) return null;
        StringBuilder sb = new StringBuilder();
        Serialize(root, sb);
        return sb.toString();
    }
    private static void Serialize(Node root, StringBuilder sb){
        if (root != null){
            sb.append(root.data + ",");
            Serialize(root.left,sb);
            Serialize(root.right,sb);
        }else {
            sb.append('$'+",");
            return;
        }
    }
    private static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
