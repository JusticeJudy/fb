/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.

Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5
*/
/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {

    ListNode dummy = new ListNode(0);
    ListNode front = dummy;
    public ListNode reverseKGroup(ListNode head, int k) {
        // write your code here
        if (head == null || k <= 1) {
            return head;
        }
        while (true) {
            head = reverse(head, k);
            if (head == null) {
                break;
            }
        }
        return dummy.next;
    }
    
    private ListNode reverse(ListNode head, int k) {
        ListNode ptr = head;
        int k_ = k;
        while (k_ > 0) {
            if (ptr == null) {
                front.next = head;
                head = ptr;
                return head;
            }
            ptr = ptr.next;
            k_--;
        }
        ListNode curr = head;
        ListNode pre = null;
        ListNode temp = curr.next;
        
        while (k > 0) {
            curr.next = pre;
            pre = curr;
            curr = temp;
            if (curr != null) {
                temp = curr.next;
            }
            k--;
        }
        
        front.next = pre;
        front = head;
        return curr;
    }
}
