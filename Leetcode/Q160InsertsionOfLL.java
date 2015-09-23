package q141to160;

public class Q160InsertsionOfLL {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //ListNode cirA, cirB;
		if (headA == null || headB == null) return null;
		int lenA = len(headA), lenB = len(headB);
        while (lenA > lenB){
        	headA = headA.next;
        	lenA--;
        }
        while (lenB > lenA){
        	headB = headB.next;
        	lenB--;
        }
        while (headA != headB){
        	headA = headA.next;
        	headB = headB.next;
        }
        return headA;
    }
	private int len(ListNode a){
		int len = 0;
		while (a != null){
			a = a.next;
			len++;
		}
		return len;
	}
}
