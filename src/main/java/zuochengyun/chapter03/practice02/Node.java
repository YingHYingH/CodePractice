package zuochengyun.chapter03.practice02;

public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int data) {
        this.value = data;
    }

    public void printEdge1(Node head) {
        if (head == null) {
            return;
        }
        int height = getHeight(head, 0);
        Node[][] edgeMap = new Node[height][2];
        setEdgeMap(head, 0, edgeMap);
        // 打印左边界
        for (int i = 0; i < edgeMap.length; i++) {
            System.out.print(edgeMap[i][0].value + " ");
        }
        // 打印不是左边界 也不是右边界的叶子结点
        printLeafNotInMap(head, 0, edgeMap);
        // 打印右边界 但不是左边界的节点
        for (int i = edgeMap.length - 1; i >= 0; i--) {
            if (edgeMap[i][0] != edgeMap[i][1]) {
                System.out.print(edgeMap[i][0].value + " ");
            }
        }
        System.out.println();
    }

    public int getHeight(Node head, int l) {
        if (head == null) {
            return l;
        }
        return Math.max(getHeight(head.left, l + 1), getHeight(head.right, l + 1));
    }

    public void setEdgeMap(Node head, int l, Node[][] edgeMap) {
        if (head == null) {
            return;
        }
        // 保证每一层第一个添加进来的就是最左边节点且不会被修改
        edgeMap[l][0] = edgeMap[l][0] == null ? head : edgeMap[l][0];
        // 保证每一层最后一个添加进来的就是最右边节点
        edgeMap[l][1] = head;
        setEdgeMap(head.left, l + 1, edgeMap);
        setEdgeMap(head.right, l + 1, edgeMap);
    }

    public void printLeafNotInMap(Node head, int l, Node[][] m) {
        if (head == null) {
            return;
        }
        if (head.left == null && head.right == null && head != m[l][0] && head != m[l][1]) {
            System.out.print(head.value + " ");
        }
        printLeafNotInMap(head.left, l + 1, m);
        printLeafNotInMap(head.right, l + 1, m);
    }

    public String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "V", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public void printTree(Node head) {
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }
}
