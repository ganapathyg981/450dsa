package matrix;

public class Matrix2 {
    public static void main(String[] args) {
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        int target=3;
        System.out.println();
        System.out.println(searchMatrix(matrix,target));
    }
    public static boolean searchMatrix(int[][] matrix,int target){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;i<matrix[0].length;j++){
                if(matrix[i][j]==target)
                    return true;
            }

        }
        return false;

    }

}
