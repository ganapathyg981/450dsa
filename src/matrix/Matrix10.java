package matrix;
import java.util.*;

public class Matrix10 {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 1, 4, 8},
                {3, 7, 8, 5, 1},
                {8, 7, 7, 3, 1},
                {8, 1, 2, 7, 9},
        };
        Map<Integer,Integer> firstrow=new HashMap<>();
        for(int i=0;i<mat[0].length;i++){
            firstrow.put(mat[0][i],1);
        }
        for(int i=1;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(firstrow.get(mat[i][j])!=null&&firstrow.get(mat[i][j])==i){
                    firstrow.put(mat[i][j],i+1);
                    if(i==mat.length-1){
                        System.out.println(mat[i][j]+" ");
                    }
                }
            }
        }

    }
}
