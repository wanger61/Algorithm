package 第五章;

public class 最长不含重复字符的子字符串 {
    public static void main(String[] args) {
        String str = "arabcacfr";
        int res = longestUnduplicatedStr(str);
        System.out.print(res);
    }

    private static int longestUnduplicatedStr(String str) {
        if (str == null) throw new RuntimeException("Invalid input");
        char[] chars = str.toCharArray();
        if (chars.length<= 0) return 0;
        int[] preIndex = new int[26];
        for (int i=0; i<=25; i++){
            preIndex[i] = -1;
        }
        int[] longest = new int[chars.length];
        longest[0] = 1;
        preIndex[chars[0]-'a'] = 0;
        for (int i=1; i<chars.length; i++){
            if (preIndex[chars[i]-'a'] == -1){
                longest[i] = longest[i-1]+1;
            }else {
                if (i-preIndex[chars[i]-'a'] <= longest[i-1]){
                    longest[i] = i-preIndex[chars[i]-'a'];
                }else {
                    longest[i] = longest[i-1] + 1;
                }
            }
            preIndex[chars[i]-'a'] = i;
        }
        int max = 0;
        for (int i=0; i<chars.length; i++){
            if (longest[i] > max) max = longest[i];
        }
        return max;
    }

    //可以有更节省空间的方法
}
