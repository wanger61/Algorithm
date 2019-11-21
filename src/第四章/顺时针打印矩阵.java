package 第四章;

public class 顺时针打印矩阵 {
    public static void main(String[] args) {
        //int[][] array = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        //int[][] array = new int[][]{{1,2,3,4}};
        //int[][] array = new int[][]{{1},{2},{3},{4}};
        int[][] array = new int[][]{{1}};
        int rows = array.length;
        int columns = array[0].length;
        int start = 0;
        while(rows > 2*start && columns > 2*start){
            PrintClockWisely(array,rows,columns,start);
            start++;
    }
}
    private static void PrintClockWisely(int[][] array, int rows, int columns, int start) {
        int endY = rows-1-start;
        int endX = columns-1-start;
        for (int i=start ; i<=endX; i++){
            System.out.println(array[start][i]);
        }
        if (start < endY){
            for (int i=start+1; i<=endY; i++){
                System.out.println(array[i][endX]);
            }
        }
        if (start < endY && start < endX){
            for (int i=endX-1; i>=start; i--){
                System.out.println(array[endY][i]);
            }
        }
        if (start < endY-1 && start < endX){
            for (int i=endY-1; i>start; i--){
                System.out.println(array[i][start]);
            }
        }
    }
}




