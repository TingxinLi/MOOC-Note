package q081to100;

public class Q86PartitionList {
	public ListNode partition(ListNode head, int x) {
        if (head == null){
        	return null;
        }
        ListNode dummy1 = new ListNode(0);
		ListNode dummy2 = new ListNode(0);
		ListNode cir1 = dummy1, cir2 = dummy2;
        while (head != null){
        	if (head.val < x){
        		cir1.next = head;
        		cir1 = cir1.next;
        		
        	}  
        	else{
        		cir2.next = head;
        		cir2 = cir2.next;
        	}
        	head = head.next;
        }
        cir1.next = dummy2.next;
        cir2.next = null;
        return dummy1.next;
    }
}
