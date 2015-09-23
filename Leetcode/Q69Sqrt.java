package q061to080;

public class Q69Sqrt {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int lo = 1, hi = x / 2;
        while (hi - lo > 1){
        	int temp = (lo + hi) / 2;
        	if (temp  > x / temp) hi = temp;
        	else if (temp  < x / temp) lo = temp;
        	else return temp;
        }
        System.out.println(lo + "  " + hi);
        if (hi <= x / hi) return hi;
        return lo;
    }
    public static void main(String[] args) {
    	Q69Sqrt sqr = new Q69Sqrt();
    	System.out.println(sqr.mySqrt(16));
    	System.out.println(sqr.mySqrt(15));
    	System.out.println(sqr.mySqrt(17));
    	System.out.println(sqr.mySqrt(2147483647)); 
	}
}
