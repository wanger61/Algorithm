package 第二章;

public class 剪绳子 {
    public static void main(String[] args) {
        int i = maxProductAfterCutting_solution1(8);
        System.out.println(i);
    }
    public static int maxProductAfterCutting_solution1(int length){
        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;
        int[] products = new int[length+1];
        products[0] = 0;
        products[1] = 0;
        products[2] = 1;
        products[3] = 2;
        for (int i=4; i<=length; i++){
            int max = 0;
            for (int j =1; j<i; j++){
                if(j*products[i-j]>max) max = j*products[i-j];
                if (j*(i-j)>max) max = j*(i-j);
            }
            products[i] = max;
        }
        return products[length];
    }
}
