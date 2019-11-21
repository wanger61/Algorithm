package 第五章;

public class 礼物的最大价值 {
    public static void main(String[] args) {
        int[][] array = new int[][]{{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        int maxValue = findMaxValue2(array);
        System.out.print(maxValue);
    }

    private static int findMaxValue(int[][] array) {
        if (array == null || array.length<=0) throw new RuntimeException("Invalid input!");
        int m = array.length; int n = array[0].length;
        int[][] temp = new int[m][n];
        temp[0][0] = array[0][0];
        for (int i=0; i<m ;i++){
            for (int j=0; j<n; j++){
                if (i==0 && j==0){temp[i][j] = array[i][j];}
                else if (i==0){
                    temp[i][j] = temp[i][j-1] + array[i][j];
                }else if (j==0){
                    temp[i][j] = temp[i-1][j] + array[i][j];
                }else {
                    temp[i][j] = Math.max(temp[i-1][j],temp[i][j-1]) + array[i][j];
                }
            }
        }
        return temp[m-1][n-1];
    }

    //更节省空间
    private static int findMaxValue2(int[][] array){
        if (array == null || array.length<=0) throw new RuntimeException("Invalid input!");
        int m = array.length; int n = array[0].length;
        int[] temp = new int[n];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (i==0 && j==0){ temp[j] = array[0][0]; }
                else if (i==0){ temp[j] = array[i][j-1] + array[i][j];}
                else if (j==0){ temp[j] = temp[j] + array[i][j];}
                else { temp[j] = Math.max(temp[j-1],temp[j]) + array[i][j];}
            }
        }
        return temp[n-1];
    }
}
