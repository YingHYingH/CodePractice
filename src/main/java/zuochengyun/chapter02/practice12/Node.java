package zuochengyun.chapter02.practice12;

import java.util.Stack;

public class Node {
    public int value;
    public Node next;

    public Node(int data) {
        this.value = data;
    }

    public Node reverseKNodes1(Node head, int K) {
        if (K < 2) {
            return head;
        }
        Stack<Node> stack = new Stack<>();
        Node newHead = head;
        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            stack.push(cur);
            if (stack.size() == K) {
                // 当剩下的个数小于K时不满足这个条件就不会进行反转
                newHead = newHead == head ? cur : newHead;
                pre = resign1(stack, pre, next);
            }
            cur = next;
        }
        return newHead;
    }

    public Node resign1(Stack<Node> stack, Node left, Node right) {
        // 反转的时候注意连接链表 包括前半段连接反转后的头 和反转后的尾连接后半段
        Node cur = stack.pop();
        if (left != null) {
            // 前半段连接反转后的头 根据left!=null判断是不是第一段
            left.next = cur;
        }
        Node next = null;
        while (!stack.isEmpty()) {
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
//        转后的尾连接后半段
        cur.next = right;
        return cur;
    }

    public Node reverseKNodes2(Node head, int K) {
        if (K < 2) {
            return head;
        }
        Node cur = head;
        Node start = null;
        Node pre = null;
        Node next = null;
        int count = 1;
        while (cur != null) {
            next = cur.next;
            if (count == K) {
                // 需要反转的子链表的开头
                start = pre == null ? head : pre.next;
                // 不像上面用newHead是省一个变量？
                head = pre == null ? cur : head;
                resign2(pre, start, cur, next);
                // start已经变成了子链表最后一个
                pre = start;
                count = 0;
            }
            count++;
            cur = next;
        }
        return head;
    }

    public void resign2(Node left, Node start, Node end, Node right) {
        Node pre = start;
        Node cur = start.next;
        Node next = null;
        while (cur != right) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (left != null) {
            left.next = end;
        }
        start.next = right;
    }
}
