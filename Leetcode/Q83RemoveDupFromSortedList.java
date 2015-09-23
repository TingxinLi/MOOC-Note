package q081to100;

public class Q83RemoveDupFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if ( head == null) return head;
		ListNode temp = head, nex;
		while ( temp.next != null){
			nex = temp.next;
			if (temp.val == temp.next.val ){
				temp.next = nex.next;	
			}	
			else temp = temp.next;
		}
		return head;
    }
	public static void main(String[] args) {
		//Q83RemoveDupFromSortedList rd = new Q83RemoveDupFromSortedList();
	}
}
