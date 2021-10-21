package matrix;

public class Matrix4 {
    public static void main(String[] args) {
        int mat[][] = { { 0, 0, 0, 1 },
                { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 0, 0, 0 } };
        int row=mat.length-1;
        int col=(mat[0].length)-1;

        while(mat[0][col]==1&&col>=0){
            col--;
        }
        int rowval=0;
        for(int i=1;i<=row;i++){
            while(mat[i][col]==1&&col>0){
                col--;
                rowval++;
            }
        }
        System.out.print(rowval);

    }
}
