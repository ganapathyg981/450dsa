package backtracking;

public class BT16 {
    public static void main(String[] args) {
         int maze[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
        boolean[][] visited= new boolean[maze.length][maze[0].length];
        int longest[]={-99};
        solveMaze(maze,0,0,"",visited, 1, 7 ,longest);
        System.out.println(longest[0]);

    }

    private static void solveMaze(int[][] maze, int row, int col, String path, boolean[][] visited, int destr, int destc,int[] longest) {
        int r[]={1,0,0,-1};
        int c[]={0,-1,1,0};
        String d[]={"D","L","R","U"};
//        if (row == -1 || row == maze.length|| col == -1 ||
//                col == maze.length || visited[row][col] ||
//                maze[row][col] == 0)
//            return;
        if(row==destr&&col==destc){
            if(path.length()>longest[0])
                longest[0]=path.length();
            return;
        }
        for (int i = 0; i < r.length; i++) {
            if(isValid(maze,row+r[i],col+c[i],visited)){
                visited[row+r[i]][col+c[i]]=true;
                path+=d[i];
                solveMaze(maze,row+r[i],col+c[i],path,visited, 1, 7,longest);
                path = path.substring(0, path.length() - 1);
                visited[row+r[i]][col+c[i]]=false;
            }
        }

        return;



    }

    private static boolean isValid(int[][] maze, int row, int col,boolean [][] visited) {
        if(row>=0&&row<maze.length&&col>=0&&col<maze[row].length&&!visited[row][col]&&maze[row][col]==1)
            return true;
        else
            return false;
    }

}
