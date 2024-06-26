package rajat.recursion.basic;

public class SumOfNaturalNumbers {
    public static int sumOfNaturalNumber(int n){
        if(n == 0){
            return 0;
        }
        int output  = sumOfNaturalNumber(n -1);
        output += n;
        return output;
    }
    public static void main(String[] args) {
        System.out.println(sumOfNaturalNumber(5));
    }
}
