package 第二章;

public class 矩阵中的路径 {
    public static void main(String[] args) throws Exception {
        char[][] array = new char[][]{{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'}, {'j', 'd', 'e', 'h'}};
        char[] target = new char[]{'a', 'b', 'f', 'b','0'};
        if (array == null || array.length == 0 || target == null || target.length == 0)
            throw new Exception("invalid input");
        int m = array.length;
        int n = array[0].length;
        int[][] visited = new int[m][n];
        boolean existPath = false;
        lable:
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                    existPath = existPath(array, target, i, j, visited, 0);
                    if (existPath) { System.out.println("存在路径！"); break lable;}
            }
        }
        if (!existPath) System.out.println("不存在路径！");
    }

    private static boolean existPath(char[][] array, char[] target, int i, int j, int[][] visited, int step) {
        if (target[step]=='0') return true;
        if(i<0 || i>=array.length || j<0 || j>=array[0].length) return false;
        if (array[i][j] == target[step] && visited[i][j]==0){
            step++;
            visited[i][j] = 1;
            boolean hasPath = (existPath(array,target,i-1,j,visited,step)||
                    existPath(array,target,i+1,j,visited,step)||
                    existPath(array,target,i,j-1,visited,step)||
                    existPath(array,target,i,j+1,visited,step));
            if (!hasPath){
                visited[i][j] = 0;
            }
            return hasPath;
        }
        return false;
    }
}

