package rajat.recursion.basic;

public class NaturalNumberSum {
    public static int getSum(int n){
        if(n == 0){
            return 0;
        }
        return n + getSum(n - 1);
    }
    public static void main(String[] args) {
        int n = 5;

        int ans =  getSum(n);
        System.out.println(ans);
    }
}
