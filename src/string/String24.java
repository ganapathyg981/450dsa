package string;

public class String24 {
    public static boolean found=false;
    public static void main(String[] args) {
        char [][] grid = {
                {'c','l','a','s','s','e','s','m','o','p'},
                {'h','t','i','d','m','i','y','u','i','e'},
                {'h','e','b','z','b','e','p','t','t','l'},
                {'e','s','r','l','m','m','p','a','e','b'},
                {'a','a','a','e','o','d','a','b','r','i'},
                {'r','f','c','h','d','c','h','l','a','x'},
                {'r','u','o','h','u','o','k','e','t','e'},
                {'a','e','b','h','l','a','c','s','o','l'},
                {'y','p','p','y','e','i','n','s','r','f'},
                {'e','s','s','t','c','e','j','b','o','s'}};
        String search="xelfs";

        String result=null;
        for(int i = 0; i<grid.length&&result==null; i++){
            for(int j=0;j<grid[i].length&&result==null;j++){
                if(search.charAt(0)==grid[i][j]){
                    result=(findSolution(grid,i,j,1,search,-99));
                    if(result!=null){
                        result=String.valueOf(i)+String.valueOf(j)+"----"+result;
                        }}}
        }

        System.out.println(result);




    }
    public static boolean isValidMove(char[][] grid,int row,int col){
        if(row<0||row>= grid.length||col<0||col>=grid[0].length)
            return false;
        return true;
    }

    public static String findSolution(char[][] grid,int row,int col, int pos, String search,int direction){
        if(pos==search.length()) {
            found=true;
            return String.valueOf(row)+String.valueOf(col);
        }
        int rows[] ={0,0,1,1,-1,-1,1,-1};
        int cols[]= {1,-1,1,-1,1,-1,0,0};

        if(direction==-99){
            for(int i=0;i<rows.length;i++){
                if(isValidMove(grid,rows[i]+row,cols[i]+col))
                    if(grid[rows[i]+row][cols[i]+col]==search.charAt(pos))
                        return findSolution(grid,rows[i]+row,cols[i]+col,pos+1,search,i);
            }
        }

        else{
            if(isValidMove(grid,rows[direction]+row,cols[direction]+col))
                if(grid[rows[direction]+row][cols[direction]+col]==search.charAt(pos)&&!found)
                    return findSolution(grid,rows[direction]+row,cols[direction]+col,pos+1,search,direction);
        }
        return null;
    }

}
