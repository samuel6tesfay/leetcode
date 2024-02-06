package leetcode.linkedlist;

import java.util.HashMap;

public class CopyListwithRandomPointer {

    public ListNode copyRandomList(ListNode head) {
        ListNode current = head;
        HashMap<ListNode, ListNode> map = new HashMap<>();

        while (current != null){
            map.put(current, new ListNode(current.val));
            current = current.next;
        }

        current = head;
        while (current != null) {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }
        return map.get(head);
    }

}
