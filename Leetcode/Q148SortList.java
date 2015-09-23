package q141to160;


public class Q148SortList {
	private ListNode findMid(ListNode head){
		ListNode fast = head.next, slow = head;
		while (fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	private ListNode merge(ListNode head1, ListNode head2){
		ListNode dummy = new ListNode(0);
		ListNode cir = dummy;
		
		while (head1 != null && head2 != null){
			if (head1.val < head2.val){
				cir.next = head1;
				head1 = head1.next;
			}
			else{
				cir.next = head2;
				head2 = head2.next;
			}
			cir = cir.next;
		}
		
		if (head1 != null){
			cir.next = head1;
		}
		else {
			cir.next = head2;
		}
		
		return dummy.next;
	}
	
	public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
        	return head;
        }
        
        ListNode mid = findMid(head);
        
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        
        return merge(left, right);
    }
	
	ListNode genList(int[] sourse){
		ListNode dummy = new ListNode(0);
		ListNode cir = dummy;
		for (int i = 0; i < sourse.length; i++){
		    ListNode temp = new ListNode(0);
		    temp.val = sourse[i];
		    cir.next = temp;
		    cir = cir.next;
		}
		/**
		while (dummy.next != null){
			System.out.println(dummy.next.val);
			dummy.next = dummy.next.next;
		}
		**/
		return dummy.next;
	}
	
	public static void main(String[] args) {
		Q148SortList sll = new Q148SortList();
		int[] a = {2, 1};
		ListNode aNode = sll.genList(a);
		ListNode aSort = sll.sortList(aNode);
		while (aSort != null){
			System.out.println(aSort.val);
			aSort = aSort.next;
		}
	}
}
