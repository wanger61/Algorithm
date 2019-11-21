package 第五章;

public class 数字序列中某一位的数字 {
    public static void main(String[] args) {
        //int k = 1001;
        int k = 0;
        int res = findTheValueInSeries(k);
        System.out.println(res);
    }
    public static int findTheValueInSeries(int k){
        if (k<0) throw new RuntimeException("Invalid Input");
        int temp = k;
        int dight = 1;
        while (temp - dightSize(dight) > 0){
            temp = temp - dightSize(dight);
            dight++;
        }
        int dightNum = findDightNum(temp/dight,dight);
        int dightIndex = temp % dight;
        int res = findRightNum(dightNum,dightIndex);
        return res;
    }

    private static int findRightNum(int dightNum, int dightIndex) {
        String dighiNum = dightNum + "";
        char[] chars = dighiNum.toCharArray();
        char res = chars[dightIndex];
        return Integer.parseInt(String.valueOf(res));
    }

    private static int findDightNum(int i, int dight) {
        if (dight == 1) return 0+i;
        int start = (int) Math.pow(10,dight-1);
        return start+i;
    }

    private static int dightSize(int dight) {
        if (dight == 1) return 10;
        return (int) (9*Math.pow(10,dight-1))*dight;
    }
}
