package 第六章;

public class 左旋转字符串 {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        String res = leftRotate(s,k);
        System.out.println(res);
    }

    private static String leftRotate(String s, int k) {
        if (s == null) return null;
        char[] chars = s.toCharArray();
        if (chars.length <= 0 || k<=0) return null;
        reverseCore(chars,0,chars.length-1);
        int startIndex1 = 0;
        int endIndex1 = chars.length-1-k;
        int startIndex2 = chars.length-k;
        int endIndex2 = chars.length-1;
        if (endIndex1 >=0 && startIndex2>=0){
            reverseCore(chars,startIndex1,endIndex1);
            reverseCore(chars,startIndex2,endIndex2);
        }else {
            throw new RuntimeException("Invalid k");
        }
        return new String(chars);
    }
    private static void reverseCore(char[] chars, int start, int end) {
        while (start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
