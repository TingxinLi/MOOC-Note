package q121to140;

/**
 * The below solution is really impressing
 * https://leetcode.com/discuss/18330/is-it-best-solution-with-o-n-o-1
 * Check the second answer of the upper link, that explanation is really specific
 */
public class Q123BuyAndSellStock3 {
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = max(hold1,    -i);          // The maximum if we've just buy  1st stock so far. 
            //System.out.println(hold1 + ", " + release1 + ", " + hold2 + ", " + release2);
        }
        return release2;
    }
    
    private int max(int a, int b) {
    	return a > b ? a : b;
    }
    
    public static void main(String[] args) {
    	Q123BuyAndSellStock3 bs3 = new Q123BuyAndSellStock3();
    	int[] a = {1, 2, 3, 7, 5, 6};
    	System.out.println(bs3.maxProfit(a));
    	int[] b = {6, 5, 8, 3, 2, 1, 4};
    	System.out.println(bs3.maxProfit(b));
	}
}
