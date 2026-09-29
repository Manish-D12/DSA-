class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode cur = head;

        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                int dup = cur.val;
                while (cur != null && cur.val == dup) cur = cur.next; // skip all dupes
                prev.next = cur;                 // unlink the whole run
            } else {
                prev = cur;                      // keep this node
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}