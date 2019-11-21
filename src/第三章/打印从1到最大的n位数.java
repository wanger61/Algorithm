package 第三章;

public class 打印从1到最大的n位数 {
    public static void main(String[] args) {
        int n = 4;
        //printToMax(n);
        printToMax_2(n);
    }

    private static void printToMax_2(int n) {
        if (n<=0) throw new RuntimeException("Invalid input");
        char[] ch = new char[n];
        for(int i=0; i<=9; i++){
            ch[0] = (char) (i+'0');
            printToMaxWithIre(ch,n,0);
        }
    }

    private static void printToMaxWithIre(char[] ch, int n, int index) {
        if (index == n-1){
            printNumber(ch);
            return;
        }
        for (int i=0; i<10; i++){
            ch[index+1] = (char) (i + '0');
            printToMaxWithIre(ch,n,index+1);
        }
    }

    private static void printToMax(int n) {
        if (n<=0) throw new RuntimeException("Invalid input");
        char[] ch = new char[n];
        for (int i=0; i<=n-1; i++){
            ch[i] = '0';
        }
        while (!Increment(ch)){
            printNumber(ch);
        }
    }

    private static boolean Increment(char[] ch) {
        boolean isOverflow = false;
        int nTakeOver = 0;
        int n = ch.length;
        for(int i=n-1; i>=0; i--){
            int nSum = ch[i] - '0' + nTakeOver;
            if(i == n-1) nSum++;
            if(nSum == 10){
                if(i == 0){
                    isOverflow = true;
                }
                nSum = nSum - 10;
                nTakeOver = 1;
                ch[i] = (char) (nSum+'0');
            }
            else {
                ch[i] = (char) (nSum+'0');
                break;
            }
        }
        return isOverflow;
    }

    private static void printNumber(char[] ch) {
        boolean begin = false;
        for (int i=0 ;i<ch.length;i++){
            if (ch[i]!='0') begin = true;
            if (begin){
                System.out.print(ch[i]);
            }
        }
        System.out.print('\n');
    }
}
