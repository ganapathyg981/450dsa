package recursion;

public class KnapSack01 {
    public static void main(String[] args) {
        int N = 3;
        int W = 4;
        int values[] = {1,2,3,4,5,6};
        int weight[] = {4,5,1,3,2,7};

        int[][] mem=new  int[W+1][values.length];
        for(int i=0;i<mem.length;i++){
            for (int j = 0; j < mem[i].length; j++) {
                mem[i][j]=-1;

            }
        }
        System.out.println(knapSack(values,weight,W,values.length,mem));
    }




    public static int knapSack(int[] values, int[] weight, int space, int item, int[][] mem){

        if(space==0||item==0){
            return 0;
        }
        if(mem[space][item]!=-1)
           return mem[space][item];
        int result;
        if(space<weight[item]){
            result= knapSack(values,weight,space,item-1, mem);
        }
        else{
            result= Math.max(
                    knapSack(values,weight,space,item-1, mem),
                    values[item-1]+knapSack(values,weight,space-weight[item],item-1, mem)
            );
        }
        return result;

    }
}
