package revision.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// need to practice
// Boyer-Moore Voting Algorithm

public class MajorityElement_II {
    public static void main(String[] args) {
        int[] number = {1, 2, 1, 1, 3, 2};
        List<Integer> result = findMajorityElements(number);
        System.out.println(result);
    }

    private static List<Integer> findMajorityElements(int[] number) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : number){
            count.put(num , count.getOrDefault(num,0)+1);
        }
        int n = number.length;
        for(Map.Entry<Integer,Integer> entry : count.entrySet()){
            if(entry.getValue()> n/3){
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
