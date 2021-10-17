package matrix;

public class Matrix5 {
    public static void main(String[] args) {
        int [][] mat =  { {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50},
        };
//        sortArray(mat);
        printing(sortArray(mat));
    }

    public static int[][] sortArray(int[][] mat) {
        int currentMinimum;
        int minRow = 0;
        int minCol = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                    currentMinimum=mat[i][j];
                    minRow=i;
                    minCol=j;
                for (int k = i+1; k < mat.length; k++) {
                    for (int l = 0; l < mat[k].length; l++) {
                        if(mat[k][l]<currentMinimum){
                            currentMinimum=mat[k][l];
                            minRow=k;
                            minCol=l;
                        }
                    }
                }
                if(!(i==minRow&&j==minCol))
                swap(mat,i,j,minRow,minCol);
            }
        }
        return mat;
    }

    private static void swap(int [][] mat,int row1,int col1,int row2,int col2){
            int temp;
            temp=mat[row1][col1];
            mat[row1][col1]=mat[row2][col2];
            mat[row2][col2]=temp;
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
