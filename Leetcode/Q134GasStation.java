package q121to140;

public class Q134GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumTotal = 0, sum = 0, index = 0;
        int len = gas.length;
        int temp = 0;
        
        for (int i = 0; i < len; i++) {
        	temp = gas[i] - cost[i];
        	sum += temp;
        	sumTotal += temp;
        	if (sum < 0) {
        		sum = 0;
        		index = i + 1;
        	}
        }
        
        if (sumTotal < 0) {
        	return -1;
        }
        
    	return index;
    }
    
    
	public static void main(String[] args) {
		
	}
}
