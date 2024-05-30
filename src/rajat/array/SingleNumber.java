package rajat.array;


public class SingleNumber {
    public static int singleNumber(int arr[], int n){
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans ^= arr[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 1, 2, 4};
        int n = arr.length;
        System.out.println(singleNumber(arr, n));
    }
}

