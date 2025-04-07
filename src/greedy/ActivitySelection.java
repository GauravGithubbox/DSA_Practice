package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static void main(String[] args) { // T.C. nlog(n)
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};
        // suppose if the 2nd array is not sorted
        // how we can sort this array
        int activities[][] = new int[start.length][3]; // why 3 because we need to create 3 columns index , startTime , endTime that's why nX3 array
        for(int i =0;i<start.length;i++){
            activities[i][0] = i;                        // this means at first columns we store index
            activities[i][1] = start[i];                 // this means at second columns we store start time
            activities[i][2] = end[i];                   // this means at the 3rd columns we store end time
        }
        // this is used as sorting using lambda expression
        Arrays.sort(activities , Comparator.comparingDouble(o -> o[2]));    // here o[2] end time remember we store at 0 index at 1 startTime and at 2 endTime

        // here is the remaining code
        int maxAct =0;
        ArrayList<Integer> ans = new ArrayList<>();
        maxAct =1;
        ans.add(activities[0][0]); // why we are adding first index because array is sorted according to end date
        int lastEnd = activities[0][2];
        for(int i =1;i<end.length;i++){
            if(activities[i][1]>= lastEnd){
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }
        System.out.println("maximum activity ="+maxAct);
        for(int i =0;i<ans.size();i++){
            System.out.println("A"+ans.get(i));
        }
        System.out.println();
    }
}
