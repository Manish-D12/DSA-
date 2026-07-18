class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists)
            if (node != null) pq.offer(node);

        ListNode dummy = new ListNode(0), cur = dummy;
        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            cur.next = min;
            cur = min;
            if (min.next != null) pq.offer(min.next);
        }
        return dummy.next;
    }
}