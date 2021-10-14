package matrix;

public class Matrix1 {
    public static void main(String[] args) {
        int[][] mat={{  1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiral(mat);
    }
    public static void spiral(int[][] mat){
        int top=0;
        int down=mat.length-1;
        int left=0;
        int right=mat[0].length-1;
        int direction=0;
        while(top<=down&&left<=right){
            if(direction==0){
                for(int i=left;i<=right;i++){
                    System.out.print(mat[top][i]);
                }
                System.out.println();
                top++;
            }
            else if(direction==1){
                for(int i=top;i<=down;i++){
                    System.out.print(mat[i][right]);
                }
                System.out.println();
                right--;
            }
            else if(direction==2){
                for(int i=right;i>=left;i--){
                    System.out.print(mat[down][i]);
                }
                System.out.println();
                down--;
            }
            else{
                for(int i=down;i>=top;i--){
                    System.out.print(mat[i][left]);
                }
                System.out.println();
                left++;
            }
            direction=(direction+1)%4;
        }
    }


}
