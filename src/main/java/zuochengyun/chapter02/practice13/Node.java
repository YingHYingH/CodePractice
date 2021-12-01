package zuochengyun.chapter02.practice13;

import java.util.HashSet;

public class Node {
    public int value;
    public Node next;

    public Node(int data) {
        this.value = data;
    }

    public void removeRep1(Node head) {
        if (head == null) {
            return;
        }
        Node pre = head;
        Node cur = head.next;
        HashSet<Integer> set = new HashSet<>();
        set.add(head.value);
        while (cur != null) {
            if (set.contains(cur.value)) {
                pre.next = cur.next;
            } else {
                set.add(cur.value);
                pre = cur;
            }
            cur = cur.next;
        }
    }

    public void removeRep2(Node head) {
        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur != null) {
            pre = cur;
            next = cur.next;
            while (next != null) {
                if (next.value == cur.value) {
                    pre.next = next.next;
                } else {
                    pre = next;
                }
                next = next.next;
            }
            cur = cur.next;
        }
    }
}
