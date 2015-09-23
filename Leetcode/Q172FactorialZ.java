package q161to180;

public class Q172FactorialZ {
    public int trailingZeroes(int n) {
        int sum = 0;
        while ( n > 0 ){
        	sum += n / 5;
        	n /=5;
        }
        return sum;
    }
    public static void main(String[] args) {
		Q172FactorialZ fz = new Q172FactorialZ();
		System.out.println(fz.trailingZeroes(9));
		System.out.println(fz.trailingZeroes(1));
		System.out.println(fz.trailingZeroes(145));
	}
}
