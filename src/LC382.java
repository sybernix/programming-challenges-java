import java.util.List;
import java.util.Random;

public class LC382 {
    static int length;
    static ListNode head;
    static Random rand = new Random();
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public static void main(String args[]) {
        head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode node = head;
        length = 1;
        while (node.next != null) {
            length += 1;
            node = node.next;
        }

        int ans = getRandom();
        System.out.println("hi");
    }

    public static int getRandom() {
        System.out.println(length);
        ListNode randNode = head;
        int idx = rand.nextInt(length);
        for (int i=0; i< idx; i++) {
            randNode = randNode.next;
        }
        return randNode.val;
    }
}
