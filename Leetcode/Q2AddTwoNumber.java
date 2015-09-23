package q001to020;

public class Q2AddTwoNumber {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;
		ListNode head = new ListNode(0);
		ListNode result = head;
		while (l1 != null || l2 != null){
			temp /= 10;
			if (l1 != null){
				temp += l1.val;
				l1 = l1.next;
			}
			if (l2 != null){
				temp += l2.val;
				l2 = l2.next;
			}
			result.next = new ListNode(temp % 10);
			result = result.next;
		}
		if (temp / 10 == 1) result.next = new ListNode(1);
		return head.next;
	}
	public static void main(String[] args) {
		Q2AddTwoNumber add2 = new Q2AddTwoNumber();
		ListNode a = new ListNode(0);
		ListNode b = new ListNode(0);
		ListNode c = add2.addTwoNumbers(a, b);
		while (c != null){
			System.out.println(" val = " + c.val);
			c = c.next;
		}
		System.out.println("-----------------------");
		ListNode d = new ListNode(0);
		ListNode e = new ListNode(1);
		ListNode f = add2.addTwoNumbers(e, d);
		while (f != null){
			System.out.println(" val = " + f.val);
			f = f.next;
		}
	}
}
