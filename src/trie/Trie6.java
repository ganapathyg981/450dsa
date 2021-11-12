package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Trie6 {
    public static void main(String[] args) {
        int mat[][] = {{1, 1 ,0, 1},{1 ,0 ,0, 1},{1 ,1 ,0 ,1}};
        System.out.println(findUnique(mat));

    }
    static ArrayList<ArrayList<Integer>> findUnique(int mat[][]){
        HashMap<String,ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            String arranged="";
            for (int j = 0; j < mat[i].length; j++) {
                    arranged+=mat[i][j];
            }
            if(map.get(arranged)==null){
                map.put(arranged,new ArrayList<Integer>(mat[i].length));
                for (int k : mat[i])
                {
                    map.get(arranged).add(k);
                }
            }
        }
        return new ArrayList<>(map.values());
    }
}
