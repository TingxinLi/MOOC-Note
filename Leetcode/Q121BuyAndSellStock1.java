package q121to140;

public class Q121BuyAndSellStock1 {
    public int maxProfit(int[] prices) {
        int result, len = prices.length;
        if (len < 2) return 0;
        int[] minBefore = new int[len];
        
        int curMin = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
        	if (prices[i - 1] < curMin) {
        		curMin = prices[i - 1];
        	}
        	minBefore[i] = curMin;
        }
        
        result = 0;
        for (int i = 1; i < len; i++) {
        	minBefore[i] = prices[i] - minBefore[i];
        	if (result < minBefore[i]) {
        		result = minBefore[i];
        	}
        }
        
    	return result;
    }
    
    public static void main(String[] args) {
    	Q121BuyAndSellStock1 bs1 = new Q121BuyAndSellStock1();
    	int[] a = {1, 2, 3, 4, 5, 6};
    	System.out.println(bs1.maxProfit(a));
    	int[] b = {6, 5, 4, 3, 2, 1};
    	System.out.println(bs1.maxProfit(b));
	}
}
