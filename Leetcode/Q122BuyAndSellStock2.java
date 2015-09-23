package q121to140;

public class Q122BuyAndSellStock2 {
	public int maxProfit(int[] prices) {
        int result, len = prices.length;
        if (len < 2) return 0;

        result = 0;
        for (int i = 1; i < len; i++) {
            if ( prices[i] - prices[i - 1] > 0) {
            	result += prices[i] - prices[i - 1];
            }
        }
        
    	return result;
    }
    
    public static void main(String[] args) {
    	Q122BuyAndSellStock2 bs2 = new Q122BuyAndSellStock2();
    	int[] a = {1, 2, 3, 4, 5, 6};
    	System.out.println(bs2.maxProfit(a));
    	int[] b = {6, 5, 4, 3, 2, 1};
    	System.out.println(bs2.maxProfit(b));
	}
}
