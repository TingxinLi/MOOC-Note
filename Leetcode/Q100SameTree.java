package q081to100;

public class Q100SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == null & q == null;
        return q.val == p.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
	
	public static void main(String[] args) {
		
	}
}
