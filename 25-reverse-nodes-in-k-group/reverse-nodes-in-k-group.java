class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            if (node == null) return head;
            node = node.next;
        }
        // node is now the head of the next group
        ListNode prev = reverseKGroup(node, k);
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}