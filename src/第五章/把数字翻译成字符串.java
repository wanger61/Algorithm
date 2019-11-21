package 第五章;

public class 把数字翻译成字符串 {
    public static void main(String[] args) {
        //int k = 12258;
        int k = 9;
        int res = TranslationCount(k);
        System.out.print(res);
    }

    private static int TranslationCount(int k) {
        if (k < 0) throw new RuntimeException("Invalid input");
        String sk = k + "";
        char[] chars = sk.toCharArray();
        if (chars.length == 1) return 1;
        int count = 0;
        int[] f = new int[chars.length];
        f[chars.length - 1] = 1;
        int temp = (chars[chars.length - 2] - '0') * 10 + (chars[chars.length - 1] - '0');
        if (temp > 0 && temp <= 25) f[chars.length - 2] = 2;
        else f[chars.length - 2] = 1;
        for (int i = chars.length - 3; i >= 0; i--) {
            int temp2 = (chars[i] - '0') * 10 + (chars[i + 1] - '0');
            if (temp2 >=10 && temp2 <= 25) f[i] = f[i + 1] + f[i + 2];
            else f[i] = f[i + 1];
        }
        return f[0];
    }
}
