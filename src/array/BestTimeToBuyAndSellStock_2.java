package array;

public class BestTimeToBuyAndSellStock_2 {
    public static void main(String[] args) {
        int[] price = {7, 1, 5, 3, 6, 4};
        int result = bestTimeToBuyAndSell(price);
        System.out.println("result="+result);
    }

    private static int bestTimeToBuyAndSell(int[] price) {
        int maxProfit = 0;
        for(int i =0;i<price.length-1;i++){
            if(price[i]<price[i+1]) {
                maxProfit += price[i + 1] - price[i];
            }
        }

        return maxProfit;
    }
}

// Dry Run
/*
[7 , 1 ,5,3,6,4]

mP = 0
i=0 --> 7 < 1 --> false   --> no action
i=1 --> 1 < 5 --> true --> mP = 5-1 --> 4
mP = 4
i =2 --> 5<3 false --> No Action
i=3 --> 3 < 6 true --> mP = 6-3 --> 3 + 4 (because mp previous value is 4) --> 7
i=4 --> 6 < 4 false --> no action

i = 5 --> Loop terminate

output is --> 7


* */



