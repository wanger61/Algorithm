package 第四章;

import java.util.Stack;

public class 栈的压入弹出序列 {
    public static void main(String[] args) {
        int[] in = new int[]{1};
        int[] out = new int[]{2,8};
        boolean res = isPopOrder(null, null);
        System.out.println(res);
    }

    private static boolean isPopOrder(int[] in, int[] out) {
        if (in == null || in.length == 0 || out == null || out.length == 0) return false;
        if (in.length != out.length) return false;
        Stack<Integer> stack = new Stack<>();
        int inIndex = 0;
        int outIndex = 0;
        stack.push(in[inIndex]);
        while (true) {
            if (stack.size()==0 || stack.peek() != out[outIndex]) {
                inIndex++;
                if (inIndex < in.length) {
                    stack.push(in[inIndex]);
                } else {
                    return false;
                }
            } else {
                stack.pop();
                outIndex++;
                if (outIndex == out.length) return true;
            }
        }

    }
}
