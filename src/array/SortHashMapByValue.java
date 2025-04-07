package array;

import java.util.*;

public class SortHashMapByValue {
    public static void main(String[] args) {
        // Initialize the HashMap
        Map<String, Integer> student = new HashMap<>();
        student.put("ram", 12);
        student.put("shyam", 10);
        student.put("mohan", 15);

        // Sort the HashMap by values
        Map<String, Integer> sortedStudent = sortByValue(student);

        // Print the sorted map
        sortedStudent.forEach((key, value) ->
                System.out.println("Name: " + key + ", Roll Number: " + value)
        );
    }

    private static Map<String, Integer> sortByValue(Map<String, Integer> map) {
        // Convert map entries into a list
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

        // Sort the list by values (roll numbers)
        entryList.sort(Map.Entry.comparingByValue());

        // Create a LinkedHashMap to maintain the sorted order
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}

