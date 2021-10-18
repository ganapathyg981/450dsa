package string;

public class String23 {
    public static int count=0;
    public static void main(String[] args) {
        char [][] grid1 = {
                {'S','N','B','S','N'},
                {'B','A','K','E','A'},
                {'B','K','B','B','K'},
                {'S','E','B','S','E'}};
        String search1="SNAKES";
        char [][] grid = {{'c','a','t'},
                {'a','t','c'},
                {'c','t','a'}};
        String search="cat";

        for(int i = 0; i<grid.length; i++){
            for(int j=0;j<grid[i].length;j++){
                if(search.charAt(0)==grid[i][j]){
                    findSolution(grid,i,j,1,search);
                   }}
        }

        System.out.println(count);




    }
    public static boolean isValidMove(char[][] grid,int row,int col){
        if(row<0||row>= grid.length||col<0||col>=grid[0].length)
            return false;
        return true;
    }

    public static String findSolution(char[][] grid,int row,int col, int pos, String search){
        if(pos==search.length()) {
            count++;
            return String.valueOf(row)+String.valueOf(col);
        }
        int rows[] ={0,0,1,-1};
        int cols[]= {1,-1,0,0};


            for(int i=0;i<rows.length;i++){
                if(isValidMove(grid,rows[i]+row,cols[i]+col))
                    if(grid[rows[i]+row][cols[i]+col]==search.charAt(pos))
                         findSolution(grid,rows[i]+row,cols[i]+col,pos+1,search);
            }
        return null;
    }

}
