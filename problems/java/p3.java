package problems.java;

/* https://leetcode.com/problems/reverse-nodes-in-k-group/
    Reverse Nodes in k-Group

    Given the head of a linked list, reverse the nodes of the list k
    at a time, and return the modified list.

    k is a positive integer and is less than or equal to the length
    of the linked list. If the number of nodes is not a multiple of k
    then left-out nodes, in the end, should remain as it is.

    You may not alter the values in the list's nodes,
    only nodes themselves may be changed.

    Example 1:
    Input: head = [1,2,3,4,5], k = 2
    Output: [2,1,4,3,5]
    1->2->3->4->5 => 2->1->4->3->5

    Example 2:
    Input: head = [1,2,3,4,5], k = 3
    Output: [3,2,1,4,5]
    1->2->3->4->5 => 3->2->1->4->5
*/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

public class p3 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }

    public ListNode generateList(int n, int size) {
        if(n < size) {
            return new ListNode(n, generateList(n+1, size));
        } else {
            return new ListNode(n);
        }
    }

    public String showList(ListNode head) {
        String s = "";
        s+=("[" + head.val);
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            s+=(" " + current.val);
        }
        s+=("]");
        return s.toString();
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k > 0) {
            int size = 1;
            ListNode current = head;
            while(current.next != null) {
                size++;
                current = current.next;
            }

            current = head;
            ArrayList<ListNode> reversedList = new ArrayList<>();
            ArrayList<ListNode> reversedGroup = new ArrayList<>();
            int groups = size / k;
            for(int i = 0; i < groups; i++) {
                for (int j = 0; j < k; j++) {
                    reversedGroup.add(current);
                    if(current.next != null) {
                        current = current.next;
                    }
                }
                Collections.reverse(reversedGroup);
                reversedList.addAll(reversedGroup);
                reversedGroup.clear();
            }

            if(reversedList.size() != size) {
                reversedList.add(current);
                while (current.next != null) {
                    current = current.next;
                    reversedList.add(current);
                }
            }

            current = reversedList.getFirst();
            for(int i = 1; i < reversedList.size(); i++) {
                current.next = reversedList.get(i);
                current = current.next;
            }
            reversedList.getLast().next = null;

            return reversedList.getFirst();
        }
        return null;
    }

    @Test
    public void test() {
        ListNode head;
        head = generateList(1,5);
        head = reverseKGroup(head, 2);
        Assertions.assertEquals("[2 1 4 3 5]", showList(head), "[1 2 3 4 5]; k=2");

        head = generateList(1,5);
        head = reverseKGroup(head, 3);
        Assertions.assertEquals("[3 2 1 4 5]", showList(head), "[1 2 3 4 5]; k=3");

        head = generateList(1,5);
        head = reverseKGroup(head, 1);
        Assertions.assertEquals("[1 2 3 4 5]", showList(head), "[1 2 3 4 5]; k=1");

        head = generateList(1,2);
        head = reverseKGroup(head, 2);
        Assertions.assertEquals("[2 1]", showList(head), "[1 2]; k=2");
    }
}
