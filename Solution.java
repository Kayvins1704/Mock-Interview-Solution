public class Solution {
    public static int getMaxPathSum(int[] A, int[] B){
        int i = 0;
        int j = 0;

        int m = A.length;
        int n = B.length;

        int sum = 0;
        int sum1 = 0;
        int sum2 = 0;

        while(i<m && j<n){
            if(A[i] < B[j]){
                sum1 += A[i++];
            }else if(A[i] > B[j]){
                sum2 += B[j++];
            }else{
                sum += Math.max(sum1, sum2);
                sum += A[i];
                i++;
                j++;
                sum1 = 0;
                sum2 = 0;
            }
        }

        while(i<m){
            sum1 += A[i++];
        }

        while(j<n){
            sum2 += B[j++];
        }

        sum += Math.max(sum1, sum2);

        return sum;
    }
    public static void main(String[] args) {
        int[] A = {1,4,5,8,9,11,19};
        int[] B = {2,3,4,11,12};
        System.out.println(getMaxPathSum(A, B));
    }
}
