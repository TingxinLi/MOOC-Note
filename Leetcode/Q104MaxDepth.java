package q101to120;

public class Q104MaxDepth {
    public int maxDepth(TreeNode root) {
       if (root == null) return 0;
       int L = maxDepth(root.left), R = maxDepth(root.right);    
       return 1 + Math.max(L, R);
    }
}
