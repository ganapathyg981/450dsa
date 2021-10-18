package matrix;

public class Matrix9 {
    public static void main(String[] args) {
        int mat[][] = {{10, 20, 30, 40},
            {15, 25, 35, 45},
            {24, 29, 37, 48},
            {32, 33, 39, 50}};

        System.out.println(findMedian(mat,7));

    }
    public static int findMedian(int[][] matrix,int k){
        int low=matrix[0][0];
        int high=matrix[matrix.length-1][matrix[0].length-1];
        int mid;
        int cnt=0;
        while(low<=high){
            mid=(low+high)/2;
            cnt=0;
            for (int i = 0; i < matrix.length; i++) {
                cnt+=countPerRow(matrix[i],mid);
            }
            if(cnt>(k-1)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }

        }
        return low;
    }

    private static int countPerRow(int[] matrix, int mid) {
        int low=0;
        int high=matrix.length-1;
        int innerMid;
        while(low<=high){
            innerMid=(low+high)/2;
            if(mid<matrix[innerMid]){
                high=innerMid-1;
            }
            else{
                low=innerMid+1;
            }
        }
        return low;
    }


}
