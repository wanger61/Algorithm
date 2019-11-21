package 第四章;

public class 字符串的排列 {
    public static void main(String[] args) {
        String str = "aabc";
        char[] chars = str.toCharArray();
        permutation(chars,0);
    }

    private static void permutation(char[] chars, int index) {
        if (chars == null || chars.length <=0) return;
        if (index == chars.length-1) {
            System.out.println(new String(chars));
        }else {
            for (int i = index; i < chars.length; i++) {
                if (chars[i] == chars[index] && i!=index) { continue;}
                swap(chars, index, i);
                permutation(chars, index + 1);
                swap(chars, index, i);
            }
        }
    }

    private static void swap(char[] chars, int index, int i) {
        char temp = chars[i];
        chars[i] = chars[index];
        chars[index] = temp;
    }

}
