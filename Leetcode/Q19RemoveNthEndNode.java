package q001to020;

public class Q19RemoveNthEndNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        ListNode lo = temp, hi = head;
    	lo.next = head;
        int count = 1;
    	while ( hi.next != null){
    		hi = hi.next;
    		if (count < n) count++;
    		else lo = lo.next;
    	}
    	lo.next = lo.next.next;
    	return temp.next;
    }
    public static void main(String[] args) {
		
	}
}
