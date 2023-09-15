//https://leetcode.com/problems/merge-two-sorted-lists/description/

public class mergeTwoSortedLists {

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public void solve(ListNode list1, ListNode list2) {
        ListNode curr1 = list1;
        ListNode next1 = curr1.next;
        if(next1 == null) {
            curr1.next = list2;
            return;
        }
        ListNode curr2 = list2;
        ListNode next2 = null;

        while(next1 != null && curr2 != null) {
            if(curr2.val >= curr1.val && curr2.val <= next1.val) {
                next2 = curr2.next;
                curr1.next = curr2;
                curr2.next = next1;
                curr1 = curr2;
                curr2 = next2;
            }
            else {
                curr1 = next1;
                next1 = next1.next;
                if(next1 == null) {
                    curr1.next = curr2;
                    break;
                }
            }
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }

        if(list2 == null) {
            return list1;
        }

        if(list1.val <= list2.val) {
            solve(list1, list2);
            return list1;
        }
        else {
            solve(list2, list1);
            return list2;
        }

        //return list1;
    }
}
