package week1;

public class CalculateRunTimePower {
	public static void main(String[] args) {
		double i[] = {2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152};
		double j[] = {0.002, 0.007, 0.026, 0.098, 0.379, 1.428, 5.494, 20.93, 80.075, 305.688, 1167.062};
	    double count[] = new double[10];
		double sumcount = 0;
	    for (int k = 0; k < 10; k++){
	    	count[k] = Math.log(j[k + 1] / j[k]) / Math.log(i[k + 1] / i[k]);
	    	System.out.println("count of this round: " + count[k]);
	    	sumcount += count[k];
	    }
	    System.out.println("Average count: " + sumcount/10);
	}
}

