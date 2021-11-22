package zuochengyun.chapter02.practice04;

public class Node {
    public int value;
    public Node next;

    public Node(int data) {
        this.value = data;
    }

    public Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
