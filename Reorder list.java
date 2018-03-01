public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode mid = reverseList(slow.next);
        slow.next = null;
        ListNode curr = head;
        while (curr != null && mid != null) {
            ListNode temp = curr.next;
            curr.next = mid;
            mid = mid.next;
            curr.next.next = temp;
            curr = temp;
        }
        return;
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
