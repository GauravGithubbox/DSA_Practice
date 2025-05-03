package binarysearch;

import java.util.Arrays;

public class CapacityToShipPackagesWithinDDays {

    public static void main(String[] args) {
        int [] weights = {1,2,3,4,5,6,7,8,9,10};
        int days= 5;
        int result = shipWithinDays(weights,days);
        System.out.println("result ="+result);
    }

    public static int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt(); // minimum capacity
        int high = Arrays.stream(weights).sum(); // maximum capacity
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canShip(weights, days, mid)) {
                result = mid; // try smaller capacity
                high = mid - 1;
            } else {
                low = mid + 1; // need bigger capacity
            }
        }

        return result;
    }

    private static boolean canShip(int[] weights, int days, int capacity) {
        int currentWeight = 0;
        int requiredDays = 1;

        for (int weight : weights) {
            if (currentWeight + weight > capacity) {
                requiredDays++;
                currentWeight = 0;
            }
            currentWeight += weight;
        }

        return requiredDays <= days;
    }
}
