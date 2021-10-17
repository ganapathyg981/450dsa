package matrix;

public class Matrix3 {
    public static void main(String[] args) {
        int m[][]= { {1,3,5}, {2,6,9}, {3,6,9} };

        System.out.println(findMedian(m));

    }
    public static int findMedian(int[][] matrix){
        int low=Integer.MIN_VALUE;
        int high=Integer.MAX_VALUE;
        int mid;
        int cnt=0;
        while(low<=high){
            mid=(low+high)/2;
            cnt=0;
            for (int i = 0; i < matrix.length; i++) {
                cnt+=countPerRow(matrix[i],mid);
            }
            if(cnt>(matrix.length+matrix[0].length)/2){
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
