package zuochengyun.chapter02.practice15;

import java.util.LinkedList;
import java.util.Queue;

public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int data) {
        this.value = data;
    }

    public void inOrderToQueue(Node head, Queue<Node> queue) {
        if (head == null) {
            return;
        }
        inOrderToQueue(head.left, queue);
        queue.offer(head);
        inOrderToQueue(head.right, queue);
    }

    public Node convert1(Node head) {
        Queue<Node> queue = new LinkedList<>();
        inOrderToQueue(head, queue);
        if (queue.isEmpty()) {
            return head;
        }
        head = queue.poll();
        Node pre = head;
        pre.left = null;
        Node cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return head;
    }

    public Node process(Node head) {
        if (head == null) {
            return null;
        }
        Node leftE = process(head.left); // 左边结束
        Node rightE = process(head.right); // 右边结束
        Node leftS = leftE != null ? leftE.right : null; // 左边开始
        Node rightS = rightE != null ? rightE.right : null;// 右边开始
        if (leftE != null && rightE != null) {
            leftE.right = head;
            head.left = leftE;
            head.right = rightS;
            rightS.left = head;
            rightE.right = leftS;
            return rightE;
        } else if (leftE != null) {
            leftE.right = head;
            head.left = leftE;
            head.right = leftS;
            return head;
        } else if (rightE != null) {
            head.right = rightS;
            rightS.left = head;
            rightE.right = head;
            return rightE;
        } else {
            head.right = head;
            return head;
        }
    }

    public Node convert2(Node head) {
        if (head == null) {
            return null;
        }
        Node last = process(head);
        head = last.right;
        last.right = null;
        return head;
    }
}
