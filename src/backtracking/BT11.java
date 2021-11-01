package backtracking;

import java.util.Objects;

public class BT11 {
    public static void main(String[] args) {
        int maze[][]={
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 } };
        boolean[][] visited= new boolean[maze.length][maze[0].length];
        int min[]={Integer.MAX_VALUE};
        for (int i = 0; i < maze.length; i++) {
            solveMaze(maze,i,0,"",visited,min);
        }
        System.out.println(min[0]);


    }

    private static void solveMaze(int[][] maze, int row, int col, String path, boolean[][] visited,int[] min) {
        int r[]={1,0,0,-1};
        int c[]={0,-1,1,0};
        String d[]={"D","L","R","U"};
        if(col==maze[0].length-1){
            if(min[0]>path.length())
                min[0]=path.length();
            return;
        }
        for (int i = 0; i < r.length; i++) {
            if(isValid(maze,row+r[i],col+c[i],visited)){
                visited[row+r[i]][col+c[i]]=true;
                path+=d[i];
                solveMaze(maze,row+r[i],col+c[i],path,visited,min);
                path = path.substring(0, path.length()-1);
                visited[row+r[i]][col+c[i]]=false;
            }
        }

        return;



    }

    private static boolean isValid(int[][] maze, int row, int col,boolean [][] visited) {
        int rows[]={1,0,0,-1};
        int cols[]={0,-1,1,0};
        if(row>=0&&row<maze.length&&col>=0&&col<maze[row].length&&!visited[row][col]&&maze[row][col]==1)
        {
            for (int i = 0; i < rows.length; i++) {
                if(row+rows[i]>=0&&row+rows[i]<maze.length&&col+cols[i]>=0&&col+cols[i]<maze[row].length&&!visited[row][col])
                if(maze[row+rows[i]][col+cols[i]]==0){
                    return false;
                }
            }
            return true;
        }
        else
            return false;
    }

}
