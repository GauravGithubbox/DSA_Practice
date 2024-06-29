package rajat.recursion.striver.subsequence;

public class GenerateBinaryString {
    public static void generateBinaryString(int n, String currentString) {
        if(n == 0) {
            System.out.println(currentString);
            return;
        }
        generateBinaryString(n - 1, currentString + "0");
        if(currentString.length() == 0 || currentString.charAt(currentString.length() - 1) != '1')
            generateBinaryString(n - 1, currentString + "1");
    }
    public static void main(String[] args) {
        generateBinaryString(4, "");
    }
}
