package 第三章;

public class 数值的整数次方 {
    public static void main(String[] args) {
        double power = Power(-2, -2);
        System.out.println(power);
    }
    public static double Power(double base, int exponent){
        if (base == 0 && exponent < 0){
            throw new RuntimeException("Invalid input");
        }
        int absExponent = Math.abs(exponent);
        double res = PowerWithUnsighedExponnet(base,absExponent);
        if (exponent < 0) res = 1/res;
        return res;
    }

    private static double PowerWithUnsighedExponnet(double base, int absExponent) {
        if (absExponent == 0) return 1;
        if (absExponent == 1) return base;
        double res = PowerWithUnsighedExponnet(base,absExponent>>1);
        if ((absExponent&0x1)==0) res = res*res;
        else {
            res = res*res*base;
        }
        return res;
    }
}
