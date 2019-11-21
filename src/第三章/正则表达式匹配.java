package 第三章;

public class 正则表达式匹配 {
    public static void main(String[] args) {
        char[] str = new char[]{'a','a','a','\0'};
        char[] pattern = new char[]{'a','b','*','a','c','*','a','\0'};
        char[] pattern2 = new char[]{'a','a','.','a','\0'};
        boolean res = match(str,pattern,0,0);
        System.out.print(res);
        boolean res2 = match(str,pattern2,0,0);
        System.out.print(res2);

    }

    private static boolean match(char[] str, char[] pattern, int i, int j) {
        if (str == null || pattern == null) return false;
        if (str[i] == '\0' && pattern[j] == '\0')return true;
        if (str[i]!= '\0' && pattern[j] == '\0') return false;
        if (pattern[j+1]=='*'){
            if (str[i]==pattern[j] || (pattern[j]=='.'&& str[i]!='\0')){
                return match(str,pattern,i+1,j+2)||match(str,pattern,i+1,j)||match(str,pattern,i,j+2);
            }
            else {
                return match(str,pattern,i,j+2);
            }
        }

        if (str[i]==pattern[j] || (pattern[j]=='.'&& str[i]!='\0')) {
            return match(str, pattern, i + 1, j + 1);
        }
        return false;
    }
}
