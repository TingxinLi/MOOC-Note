package week2;

public class StackJudge {
	public boolean stackJ(int[] pushG, int[] judgeG){
		
		return true;
	}
    public static void main(String[] args) {
    	StackJudge sj = new StackJudge();
    	int [] push = {1, 2, 3, 4, 5};
    	int [] test1 = {1, 2, 3, 4, 5};
    	int [] test2 = {5, 4, 3, 2, 1};
    	System.out.println(sj.stackJ(push, test1));
    	System.out.println(sj.stackJ(push, test2));
    }
}
