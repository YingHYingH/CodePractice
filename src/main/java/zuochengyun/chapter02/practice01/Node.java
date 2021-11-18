package zuochengyun.chapter02.practice01;

public class Node {
    public int value;
    public Node next;

    public Node(int data) {
        this.value = data;
    }

    public void printCommonPart(Node head1, Node head2) {
        System.out.print("Common Part: ");
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head2.value < head1.value) {
                head2 = head2.next;
            } else {
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
}
