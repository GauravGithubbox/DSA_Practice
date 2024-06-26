package rajat.recursion.basic;

import java.util.ArrayList;

//  1 to N Without Loop
public class PrintArrayElement {
    public static void printElement(ArrayList<Integer> arr, int n){
        if(n > 0){
            printElement(arr, n - 1);
            arr.add(n);
        }
        return;
    }
    public static void main(String[] args) {
        int n = 10;
        ArrayList<Integer> smallOutput = new ArrayList<Integer>(n);
        printElement(smallOutput, n);
        for(int ele : smallOutput){
            System.out.print(ele + " ");
        }
        int arr[] = new int[2];

    }
}
