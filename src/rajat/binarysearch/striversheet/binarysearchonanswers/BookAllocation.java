package rajat.binarysearch.striversheet.binarysearchonanswers;

import java.util.Arrays;
//https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
public class BookAllocation {

    /**
     * Helper method to check if it's possible to allocate books such that no student
     * reads more than 'maxPages'.
     *
     * Time Complexity: O(n), where n is the number of books.
     * Space Complexity: O(1), no additional space is used other than variables.
     *
     * @param books Array representing the number of pages in each book.
     * @param students The number of students to allocate books to.
     * @param maxPages The maximum number of pages any student should read.
     * @return true if allocation is possible, otherwise false.
     */
    public static boolean isAllocationPossible(int[] books, int students, int maxPages) {
        long pagesSum = 0; // Sum of pages for the current student
        int requiredStudents = 1; // Start with the first student

        for (int pages : books) {
            pagesSum += pages;
            if (pagesSum > maxPages) {
                // Allocate the next book to a new student
                requiredStudents++;
                pagesSum = pages;
            }
        }
        // Check if the required number of students exceeds the available students
        return requiredStudents <= students;
    }

    /**
     * Brute-force method to find the minimum possible maximum number of pages any student has to read.
     *
     * Time Complexity: O(n * sum), where n is the number of books and sum is the total pages in the books.
     * Space Complexity: O(1), no additional space is used other than variables.
     *
     * @param books Array representing the number of pages in each book.
     * @param students The number of students to allocate books to.
     * @return The minimum possible maximum number of pages any student has to read, or -1 if not possible.
     */
    public static long findPagesBruteForce(int[] books, int students) {
        // If there are more students than books, allocation is not possible
        if (students > books.length) return -1;

        int start = Arrays.stream(books).max().orElseThrow(); // Minimum possible pages (largest book)
        int end = Arrays.stream(books).sum(); // Maximum possible pages (all books to one student)

        // Iterate through all possible page counts to find the minimum possible maximum
        for (int maxPages = start; maxPages <= end; maxPages++) {
            if (isAllocationPossible(books, students, maxPages)) {
                return maxPages; // Return the first feasible maximum pages
            }
        }
        return -1;
    }

    /**
     * Optimized method to find the minimum possible maximum number of pages any student has to read using binary search.
     *
     * Time Complexity: O(n log m), where n is the number of books and m is the total pages in the books.
     * Space Complexity: O(1), no additional space is used other than variables.
     *
     * @param books Array representing the number of pages in each book.
     * @param students The number of students to allocate books to.
     * @return The minimum possible maximum number of pages any student has to read, or -1 if not possible.
     */
    public static long findPages(int[] books, int students) {
        // If there are more students than books, allocation is not possible
        if (students > books.length) return -1;

        int low = Arrays.stream(books).max().orElseThrow(); // Minimum possible pages (largest book)
        int high = Arrays.stream(books).sum(); // Maximum possible pages (all books to one student)

        int result = high; // Initialize result with the upper bound

        // Binary search to find the optimal allocation
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isAllocationPossible(books, students, mid)) {
                result = mid; // Update result to the current midpoint
                high = mid - 1; // Try for a smaller maximum by reducing the search range
            } else {
                low = mid + 1; // Increase the search range
            }
        }
        return result; // Return the best possible allocation
    }

    public static void main(String[] args) {
        // Example usage:
        int[] books1 = {12, 34, 67, 90};
        int students1 = 2;
        System.out.println("Test Case 1 (Expected 113): " + findPagesBruteForce(books1, students1));
        System.out.println("Test Case 1 (Expected 113): " + findPages(books1, students1) + "\n");

        int[] books2 = {100};
        int students2 = 1;
        System.out.println("Test Case 2 (Expected 100): " + findPagesBruteForce(books2, students2));
        System.out.println("Test Case 2 (Expected 100): " + findPages(books2, students2) + "\n");

        int[] books3 = {10, 20};
        int students3 = 3;
        System.out.println("Test Case 3 (Expected -1): " + findPagesBruteForce(books3, students3));
        System.out.println("Test Case 3 (Expected -1): " + findPages(books3, students3) + "\n");

        int[] books4 = {10, 20, 30, 40};
        int students4 = 4;
        System.out.println("Test Case 4 (Expected 40): " + findPagesBruteForce(books4, students4));
        System.out.println("Test Case 4 (Expected 40): " + findPages(books4, students4) + "\n");

        int[] books5 = {10, 20, 30, 40, 50, 60};
        int students5 = 3;
        System.out.println("Test Case 5 (Expected 90): " + findPagesBruteForce(books5, students5));
        System.out.println("Test Case 5 (Expected 90): " + findPages(books5, students5) + "\n");

        int[] books6 = {1000000, 2000000, 3000000, 4000000};
        int students6 = 2;
        System.out.println("Test Case 6 (Expected 7000000): " + findPagesBruteForce(books6, students6));
        System.out.println("Test Case 6 (Expected 7000000): " + findPages(books6, students6) + "\n");

        int[] books7 = {50, 50, 50, 50, 50};
        int students7 = 2;
        System.out.println("Test Case 7 (Expected 150): " + findPagesBruteForce(books7, students7));
        System.out.println("Test Case 7 (Expected 150): " + findPages(books7, students7) + "\n");

        int[] books8 = {0, 0, 0, 10};
        int students8 = 2;
        System.out.println("Test Case 8 (Expected 10): " + findPagesBruteForce(books8, students8));
        System.out.println("Test Case 8 (Expected 10): " + findPages(books8, students8) + "\n");

        int[] books9 = {10, 20, 30, 40};
        int students9 = 2;
        System.out.println("Test Case 9 (Expected 60): " + findPagesBruteForce(books9, students9));
        System.out.println("Test Case 9 (Expected 60): " + findPages(books9, students9) + "\n");
    }
}
