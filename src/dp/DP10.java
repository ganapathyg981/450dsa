package dp;

public class DP10 {
    public static void main(String[] args) {
        int mat[][] ={{10, 33, 13, 15},
                {22, 21, 04, 1},
                {5, 0, 2, 3},
                {0, 6, 14, 2}};
        System.out.println(solve(mat));

    }

    static  int solve(int [][] mine){
        int [][] solution=new int[mine.length][mine[0].length];
        for(int i=mine[0].length-1;i>=0;i--){
            for (int j = 0; j < mine.length; j++) {
                if(i== mine[j].length-1)
                    solution[j][i]=mine[j][i];
                else
                solution[j][i]=getNextMax(solution,j,i)+mine[j][i];
            }
        }
        int max=solution[0][0];
        for (int i = 1; i < mine.length; i++) {
            if(solution[i][0]>max)
                max=solution[i][0];
        }
       return max;
    }

    static int getNextMax(int [][]mine,int row,int col){
        int[] rows={-1,0,1};
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < rows.length; i++) {
            if(isValid(mine,row+rows[i],col+1))
            if(mine[row+rows[i]][col+1]>max)
                max=mine[row+rows[i]][col+1];
        }
        return max;
    }
    static boolean isValid(int [][]mine,int row,int col){
        if(row>=0&&col>=0&&row<mine.length&&col<mine[row].length)
            return true;
        else
            return false;
    }

    public static void printing(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
