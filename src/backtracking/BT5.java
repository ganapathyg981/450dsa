package backtracking;

public class BT5 {
    public static void main(String[] args) {
        int[][] grid = { {3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0} };
        solveSudoku(grid,0,0);
    }

    private static void solveSudoku(int[][] grid, int i, int i1) {
        if(i==8 && i1==9){
            printing(grid);
            return;
        }
        if(i1==9){
            i++;
            i1=0;
        }
        if(grid[i][i1]==0){
            for (int val = 1; val < 10; val++) {
                    if(isValid(grid,val,i,i1)){
                        grid[i][i1]=val;
                        solveSudoku(grid,i,i1+1);
                        grid[i][i1]=0;
                    }
            }
        }
        else{
            solveSudoku(grid,i,i1+1);
        }
    }

    private static boolean isValid(int[][] grid, int value, int row, int col) {
        for (int k = 0; k < grid[row].length; k++) {
            if(value==grid[k][col] || value==grid[row][k])
                return false;
        }
        int startRow = row - row % 3, startCol
                = col - col % 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (grid[i + startRow][j + startCol] == value)
                    return false;
        return true;
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
