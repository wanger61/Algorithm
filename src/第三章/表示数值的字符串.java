package 第三章;

public class 表示数值的字符串 {
    public static void main(String[] args) {
        char[] str = new char[]{'+','3','.','1','4','1','6','E','-','6','\0'};
        boolean isnumerical = isNumerical(str);
        System.out.print(isnumerical);
        char[] str2 = new char[]{'1','2','+','5','.','4','\0'};
        boolean isnumerical2 = isNumerical(str2);
        System.out.print(isnumerical2);
    }

    private static boolean isNumerical(char[] str) {
        int[] index = new int[1];
        index[0] = 0;
        boolean res = ScanInteger(str,index);
        if (str[index[0]]=='.'){
            index[0] = index[0]+1;
            res = ScanUnsighedInteger(str,index)||res;
        }
        if (str[index[0]]=='e' || str[index[0]]=='E'){
            index[0] = index[0]+1;
            res = res && ScanInteger(str,index);
        }
        return res && str[index[0]]=='\0';
    }

    private static boolean ScanInteger(char[] str, int[] index) {
        if(str[index[0]] == '-' || str[index[0]] == '+'){
            index[0] = index[0]+1;
        }
        return ScanUnsighedInteger(str, index);
    }

    private static boolean ScanUnsighedInteger(char[] str, int[] index) {
        int pre = index[0];
        while (str[index[0]] >= '0' && str[index[0]] <= '9'){
            index[0] = index[0]+1;
        }
        if (index[0]>pre) return true;
        return false;
    }
}
