class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p1 = dummy;
        ListNode p2 = dummy;

        // Move p2 n steps ahead
        for(int i = 0; i < n; i++) {
            p2 = p2.next;
        }

        // Move both until p2 reaches the last node
        while(p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        // Remove nth node from end
        p1.next = p1.next.next;

        return dummy.next;
    }
}