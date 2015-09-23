package q001to020;

public class Q7ReverseInt {
    public int reverse(int x) {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result){ 
            	return 0; 
            } // avoid overflow because it's not equal when overflow happens.
            result = newResult;
            x = x / 10;
        }

        return result;
    }
	
	// the coming solution is way too stupid, and can easily come to the wrong answer
	/**
    public int reverse(int x) {
    	if (x ==-2147483648 ) return 0;
        int sign = x < 0 ? -1: 1;
        int xRev = 0, checkx;
        int xPo = sign * x;
        if ( xPo > 1000000000 ){
        	checkx = xPo/10000%10 + xPo/1000%10*10 + xPo/100%10*100 + xPo/10%10*1000 +xPo%10*10000;
            if ( checkx > 21474 ) return 0;
        }
        if (xPo < 10) return sign * xPo;
        while (xPo > 9){
        	xRev = xRev * 10 + xPo % 10;
        	xPo = xPo / 10;
        }
        if ( xRev > 214748364 || (xRev == 214744741 &&  xPo == 9))
        	return 0;
        else
        	xRev = xRev * 10 + xPo;
        return sign * xRev;
    }
    **/
    
    public static void main(String[] args) {
    	Q7ReverseInt ri = new Q7ReverseInt();
    	System.out.println(ri.reverse(-123));
    	System.out.println(ri.reverse(123));
    	System.out.println(ri.reverse(13));
    	System.out.println(ri.reverse(2147447412));
    	System.out.println(ri.reverse(-1563847412));
    	System.out.println(ri.reverse(-2147483648));
	}
}
