package stack;

import java.util.Stack;

//https://leetcode.com/problems/asteroid-collision/description/
public class AsteroidCollision {
    public static void main(String[] args) {
        int [] asteroids = {5,10,-5};
        int [] result = asteroidCollision(asteroids);
        System.out.println("result --->"+result);
    }

    private static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            // Check if collision will happen
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (Math.abs(asteroid) > stack.peek()) {
                    stack.pop(); // Top asteroid explodes, keep checking
                } else if (Math.abs(asteroid) == stack.peek()) {
                    stack.pop(); // Both asteroids explode
                    asteroid = 0; // Current asteroid also destroyed
                } else {
                    asteroid = 0; // Current asteroid destroyed
                }
            }
            if (asteroid != 0) {
                stack.push(asteroid);
            }
        }

        // Prepare result array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

}
