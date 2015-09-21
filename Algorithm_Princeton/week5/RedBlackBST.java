package week5;



public class RedBlackBST {
	private static final boolean RED   = true;
    private static final boolean BLACK = false;

    private Node root;     // root of the BST

    // BST helper node data type
    private class Node implements Comparable<Node> {
        private int key;           // key
        private Node left, right;  // links to left and right subtrees
        private boolean color;     // color of parent link
        private int N;             // subtree count

        public Node(int key, boolean color) {
            this.key = key;
            this.color = color;
            this.left = null;
            this.right = null;
        }

		@Override
		public int compareTo(Node o) {
			if (this.key > o.key) return 1;
			else if (this.key < o.key) return -1;
			return 0;
		}
    }
	
	public RedBlackBST(int val){
	    root = new Node(val, BLACK);
	}
	
	public void insert(int val){
		
	}
	
	public static void main(String[] args) {
		
	}
}
