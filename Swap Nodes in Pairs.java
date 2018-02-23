public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while(head != null && head.next != null) {
            prev.next = head.next; 
            ListNode temp = head.next.next;
            head.next.next = head;
            head.next = temp;
            prev = head;
            head = head.next;
        }
        return dummy.next;
    }
