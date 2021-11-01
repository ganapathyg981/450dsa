package backtracking;

public class BT17 {
    public static void main(String[] args) {
        int maze[][]={ { 1, 2},
                { 3,4 } };
        boolean[][] visited= new boolean[maze.length][maze[0].length];
        solveMaze(maze,0,0,String.valueOf(maze[0][0]),visited);
    }

    private static void solveMaze(int[][] maze, int row, int col, String path,boolean[][] visited) {
        int r[]={1,0};
        int c[]={0,1};
        if(row==maze.length-1&&col==maze[0].length-1){
            System.out.println(path);
            return;
        }
        for (int i = 0; i < r.length; i++) {
            if(isValid(maze,row+r[i],col+c[i],visited)){
                visited[row+r[i]][col+c[i]]=true;
                path=path+String.valueOf(maze[row+r[i]][col+c[i]]);
                solveMaze(maze,row+r[i],col+c[i],path,visited);
                path = path.substring(0, path.length() - 1);
                visited[row+r[i]][col+c[i]]=false;
            }
        }

        return;
    }

    private static boolean isValid(int[][] maze, int row, int col,boolean [][] visited) {
        if(row>=0&&row<maze.length&&col>=0&&col<maze[row].length&&!visited[row][col])
            return true;
        else
            return false;
    }
}
