package zuochengyun.chapter02.practice05;

public class Node {
    public int value;
    public Node next;

    public Node(int data) {
        this.value = data;
    }

    public Node reversePart(Node head, int from, int to) {

        int len = 0;
        Node node1 = head;
        Node fPre = null;
        Node tPos = null;
        // 一次遍历求出len和翻转前后两个位置
        while (node1 != null) {
            len++;
            fPre = len == from - 1 ? node1 : fPre;
            tPos = len == to + 1 ? node1 : tPos;
            node1 = node1.next;
        }
        if (from > to || from < 1 || to > len) {
            return head;
        }
        // 开始翻转的第一个节点
        node1 = fPre == null ? head : fPre.next;
        Node node2 = node1.next;
        node1.next = tPos;
        Node next = null;
        while (node2 != tPos) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if (fPre != null) {
            fPre.next = node1;
            return head;
        }
        return node1;
    }
}
