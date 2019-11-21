package 第六章;

public class 翻转单词顺序 {
    public static void main(String[] args) {
        String s = "I am a student.";
        String s2 = "am.";
        String res = reverse(s2);
        System.out.println(res);
    }

    private static String reverse(String s) {
        if (s == null) return null;
        char[] chars = s.toCharArray();
        if (chars.length <=0) return null;
        reverseCore(chars,0,chars.length-1);
        int startIndex = 0;
        int endIndex = 0;
        while (endIndex <= chars.length-1){
            if (chars[endIndex] == ' '){
                reverseCore(chars,startIndex,endIndex-1);
                endIndex++;
                startIndex = endIndex;
            }
            endIndex++;
        }
        reverseCore(chars,startIndex,endIndex-1);
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
