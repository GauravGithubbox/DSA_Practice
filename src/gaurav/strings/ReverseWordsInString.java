package gaurav.strings;
//https://leetcode.com/problems/reverse-words-in-a-string/description/
public class ReverseWordsInString {
    public String reverseWords(String s) {
        // Split the string into words using whitespace as the delimiter
        String[] words = s.split("\\s+");
        String res = "";

        // Loop through the words array in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            // Append each word to the result string followed by a space
            res = res + words[i] + " ";
        }

        // Trim any leading or trailing whitespace from the result string
        return res.trim();
    }

    // Main method to test the reverseWords method
    public static void main(String[] args) {
        // Create an instance of the class
        ReverseWordsInString example = new ReverseWordsInString();

        // Define a test string
        String testString = "the sky is blue";

        // Call the reverseWords method and print the result
        String result = example.reverseWords(testString);
        System.out.println("Original String: " + testString);
        System.out.println("Reversed Words String: " + result);
    }
}
