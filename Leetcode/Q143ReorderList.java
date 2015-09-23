package q141to160;

/**
 * if put the merge method in the reoderList method, the code will run MUCH faster.
 * but it's not suitable for capsulating.
 */
public class Q143ReorderList {

    public void reorderList(ListNode head) {
    	if (head == null || head.next == null || head.next.next == null) {
    		return;
    	}
    	
        ListNode headCopy = head;
        ListNode middle = findMiddle(headCopy);
        
        //System.out.println("Middle Node: " + middle.val);
        ListNode newMiddle = reverse(middle.next);
        middle.next = null;
        
        //printNode(newMiddle);
        merge(head, newMiddle);
    }
    
    private void merge(ListNode left, ListNode right) {
    	ListNode dummy = new ListNode(0);
    	
    	while (left != null && right != null) {
    		dummy.next = left;
    		left = left.next;
    		dummy = dummy.next;
    		dummy.next = right;
    		right = right.next;
    		dummy = dummy.next;
    	}
    	
    	dummy.next = left;
    }
    
    private ListNode findMiddle(ListNode head) {
    	ListNode slow = head;
    	ListNode fast = head;
    	
    	while (fast != null && fast.next != null) {
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	
    	return slow;
    }
    
    private ListNode reverse(ListNode head) {
    	if (head.next == null) {
    		return head;
    	}
    	
    	ListNode prev = null;
    	ListNode cir = head.next;
    	
    	while (cir != null) {
    		ListNode temp = cir;
    		cir = cir.next;
    		temp.next = prev;
    		prev = temp;
    	}
    	
    	head.next.next = head;
    	head.next = null;
    			
    	return prev;
    }
    
    private void printNode(ListNode sentHead) {
    	ListNode head = sentHead;
    	while (head != null) {
    		String output = head.next == null ? String.valueOf(head.val) : String.valueOf(head.val) + " ->";
    		System.out.print(output);
    		head = head.next;
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	Q143ReorderList rl = new Q143ReorderList();
    	int i = 0;
    	ListNode head = new ListNode(0);
    	ListNode dummy = new ListNode(0);
    	head.val = 0;
    	ListNode cirHead = head;
    	dummy.next = head;
    	
    	while (i < 5) {
    		ListNode newNode = new ListNode(0);
    		newNode.val = ++i;
    		cirHead.next = newNode;
    		cirHead = cirHead.next;
    	}
    	
    	cirHead = head;
        rl.printNode(cirHead);
    	System.out.println(" After reorder: ");
    	
    	rl.reorderList(head);
    	
    	cirHead = head;
    	rl.printNode(cirHead);
    	System.out.println();
    	
    	i = 0;
    	head = new ListNode(0);
    	dummy = new ListNode(0);
    	head.val = 0;
    	cirHead = head;
    	dummy.next = head;
    	
    	while (i < 6) {
    		ListNode newNode = new ListNode(0);
    		newNode.val = ++i;
    		cirHead.next = newNode;
    		cirHead = cirHead.next;
    	}
    	
    	cirHead = head;
        rl.printNode(cirHead);
    	System.out.println(" After reorder: ");
    	
    	rl.reorderList(head);
    	
    	cirHead = head;
    	rl.printNode(cirHead);
    	System.out.println();
    	
    	i = 0;
    	head = new ListNode(0);
    	dummy = new ListNode(0);
    	head.val = 0;
    	cirHead = head;
    	dummy.next = head;
    	
    	while (i < 3) {
    		ListNode newNode = new ListNode(0);
    		newNode.val = ++i;
    		cirHead.next = newNode;
    		cirHead = cirHead.next;
    	}
    	
    	cirHead = head;
        rl.printNode(cirHead);
    	System.out.println(" After reorder: ");
    	
    	rl.reorderList(head);
    	
    	cirHead = head;
    	rl.printNode(cirHead);
    	System.out.println();
	}
}
