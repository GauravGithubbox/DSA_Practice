package two_d_arrays;




public class DiagonalSum {

    public static int calculateDiagonalSum(int matrix[][]){ // T.C = O(n)
        int sum =0;
        for(int i=0;i<matrix.length;i++){
            sum +=matrix[i][i];
            if(i!=matrix.length-1-i) {
                sum += matrix[i][matrix.length - 1 - i];
            }
        }
        return sum;
    }
        // for primary diagonal formula is => [i==j]
        // for secondary diagonal formula => i+j == n-1  // j = n-1-i
    public static int calculateDiagonalSumBruteForce(int matrix[][]) {  // T.C = o(n^2)
        int sum =0;
        for(int i =0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                if(i==j){
                    sum += matrix[i][j];
                }else if(i+j == matrix.length-1){
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        System.out.println(calculateDiagonalSumBruteForce(matrix));
        System.out.println(calculateDiagonalSum(matrix));
    }
}
