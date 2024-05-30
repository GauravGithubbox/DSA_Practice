package rajat.array;

public class Sort012 {
    public static void swap (int[] a, int i, int j) {
        a[i] = a[i] + a[j];
        a[j] = a[i] - a[j];
        a[i] = a[i] - a[j];
    }
    public static void sort012(int arr[]){
        int n = arr.length;
        // we will consider below
        // 0 to low - 1 ----> 0
        // low to mid - 1 -----> 1
        // mid to high ------->> unsorted array
        // high + 1 to n -----> 2

        int mid = 0, low = 0, high = n - 1;
        while(mid <= high){

            if(arr[mid] == 0){
                swap(arr, arr[low], arr[mid]);
                low++;
                mid++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else if(arr[mid] == 2){
                swap(arr, mid, high);
                high--;

            }


        }

    }
    public static void main(String[] args) {
        int arr [] = {2};
        sort012(arr);
        for(int ele : arr){
            System.out.print(ele + " ");
        }
    }
}
