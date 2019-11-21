package 第五章;

public class 整数中1出现的次数 {
    public static void main(String[] args) {
        int k = 10000;
        int res = numberOf1Between1AndN(k);
        System.out.println(res);
    }

    private static int numberOf1Between1AndN(int k) {
        String newk = k + "";
        char[] chars = newk.toCharArray();
        int DightNum = chars.length;
        return numberOf1Between1AndN(chars,DightNum);
    }

    private static int numberOf1Between1AndN(char[] chars, int dightNum){
        if (chars == null || chars.length<=0) return 0;
        if (dightNum == 0) return 0;
        int firstDight = chars[chars.length - dightNum] - '0';
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        if (firstDight == 0){
            return numberOf1Between1AndN(chars,dightNum-1);
        }
        if (firstDight > 1){
            num1 = (int) Math.pow(10,dightNum-1);
        }else if (firstDight == 1){
            for(int i = chars.length - dightNum +1; i<=dightNum-1; i++){
                num1 = num1*10;
                num1 = num1 + chars[i] -'0';
            }
            num1++;
        }
        num2 = (int) (firstDight*(dightNum-1)*Math.pow(10,dightNum-2));
        num3 = numberOf1Between1AndN(chars,dightNum-1);
        return num1 + num2 + num3;
    }
}
