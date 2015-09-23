package q061to080;

public class Q70ClimbingStairs {
    public int climbStairs(int n) {
        if ( n <= 3 ) return n;
        /**int a = 1, b = 2, c;      
        while ( n > 2 ) {
        	c = a + b;
        	a = b;
        	b = c;
        	n--;
        }
        return b;**/
        return climbStairs(n/2)*climbStairs(n - n/2) + climbStairs(n/2 - 1) * climbStairs(n - n/2 - 1);
    }
    public static void main(String[] args) {
    	Q70ClimbingStairs cs= new Q70ClimbingStairs();
    	System.out.println(cs.climbStairs(10));
    	System.out.println(cs.climbStairs(44));
	}
}
