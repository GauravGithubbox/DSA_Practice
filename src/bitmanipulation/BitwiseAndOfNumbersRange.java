package bitmanipulation;

public class BitwiseAndOfNumbersRange {
    public static void main(String[] args) {
        int result = rangeBitwiseAnd(5,7);
        System.out.println("result="+result);
    }

    private static int rangeBitwiseAnd(int left, int right) {
        int result =left;
        for(int i=left;i<=right;i++){
            result = result & i;
        }
        return result;
    }
}
