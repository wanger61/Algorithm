package 第二章;

public class 二维数组的查找 {
    public static boolean find(int[][] a, int target) {
        if (a!=null && a.length>0 && a[0].length>0){
            int i = 0;
            int j = a[0].length-1;
            while (i<a.length && j>=0){
                if (a[i][j]==target) return true;
                else {
                    if (a[i][j]>target) j--;
                    else i++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean b = find(a, 7);
        System.out.println(b);
        boolean c = find(a, 5);
        System.out.println(c);
    }
}
