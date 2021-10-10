package matrix;

public class Matrix8 {
    public static void main(String[] args) {
        int[][] mat={{1,2,3},{5,6,7},{8,9,0}};
        tranpose(mat);
        reverse(mat);
        printing(mat);
    }
    public static void tranpose(int[][] mat){
        int temp;
        int r= mat.length;
        for(int i=0;i<r;i++){
            for(int j=i;j<r;j++){
                if(i!=j) {
                    temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }
        }
    }
    public static void reverse(int[][] mat){
        int store;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<(mat.length)/2;j++){
                store=mat[i][j];
                mat[i][j]=mat[i][mat.length-1-j];
                mat[i][mat.length-1-j]=store;
            }
        }
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
