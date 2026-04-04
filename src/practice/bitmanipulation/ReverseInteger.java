package practice.bitmanipulation;

public class ReverseInteger {
    public static void main(String[] args) {
        int x = 123;
        int result = reverseInteger(x);
        System.out.println("result ="+result);
    }

    private static int reverseInteger(int x) {
       int rev =0;
        while(x!=0){
           int pickLastDigit = x %10; // extract the last digit
           x = x/10; // remove the last value

           rev= rev*10+pickLastDigit;

       }
        return rev;
    }
}
