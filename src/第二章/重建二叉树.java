package 第二章;

import java.util.Arrays;

public class 重建二叉树 {
    public static void main(String[] args) throws Exception {
        int[] preOrder = new int[]{1,2,4,7,3,5,6,8};
        int[] inOrder = new int[]{4,7,2,1,5,3,8,6};
        Node node = constructTree(preOrder, inOrder,0);
    }
    public static Node constructTree(int[] preOrder, int[] inOrder, int j) throws Exception {
        if (preOrder == null || preOrder.length <= 0 || inOrder == null || inOrder.length <= 0) return null;
        if (j>=preOrder.length) return null;
        int rootValue = preOrder[j];
        Node root = new Node();
        root.data = rootValue;
        int i = 0;
        for (; i<inOrder.length; i++){
            if (inOrder[i] == rootValue) break;
        }
        if (i >=inOrder.length) throw new Exception("invalid input");
        int[] newLeft = null;
        int[] newRight = null;
        if (i>0) {
            newLeft = Arrays.copyOf(inOrder,i);
            root.left = constructTree(preOrder,newLeft,j+1);
        }
        if (i+1<inOrder.length){
            newRight = Arrays.copyOfRange(inOrder,i+1,inOrder.length);
            if(newLeft!=null)root.right = constructTree(preOrder,newRight,j+newLeft.length+1);
            else root.right = constructTree(preOrder,newRight,j+1);
        }
        return root;
    }
    private static class Node{
        int data;
        Node left;
        Node right;
    }
}
