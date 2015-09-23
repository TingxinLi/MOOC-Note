package q061to080;

public class Q66PlusOne {
    public int[] plusOne(int[] digits) {
        int  tempPo = digits.length - 1;
        boolean plus = true;
        while (plus && tempPo >= 0){
        	if ( ++digits[tempPo] == 10 ){
        		digits[tempPo] = 0;
        		tempPo--;
        	}
        	else plus = false;
        }
        if (plus){
        	int[] newDig = new int[digits.length + 1];
        	newDig[0] = 1;
        	for ( int i = 1; i < newDig.length; i++) newDig[i] = digits[i - 1];
        	return newDig;
        }
        else return digits;
    }
    public static void main(String[] args) {
    	Q66PlusOne po = new Q66PlusOne();
    	int[] a = {1, 9, 9};
		for (int a1: po.plusOne(a)) System.out.println(a1);
		int[] b = {9, 9, 9};
		for (int a1: po.plusOne(b)) System.out.println(a1);
	}
}
