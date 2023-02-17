package linkedlist;

// 단방향 LinkedList의 끝에서 k번째 노드를 찾는 알고리즘 구현하기
public class LinkedList04 {
    public static void main(String[] args) {
        LinkedListV2 ll = new LinkedListV2();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();

        int k = 2;
        LinkedListV2.Node kth = KthToLast(ll.header.next, k);
        System.out.println("끝에서 " + k + "번째 노드는 " + kth.data + "입니다.");

        int k2 = 3;
        Reference r = new Reference();
        LinkedListV2.Node found = KthToLast2(ll.header.next, k2, r);
        System.out.println("끝에서 " + k2 + "번째 노드는 " + found.data + "입니다.");
    }

    // 방법 1
    // 전체 길이를 구한 후 k만큼 빼고 +1의 위치의 노드 반환
    private static LinkedListV2.Node KthToLast(LinkedListV2.Node first, int k) {
        LinkedListV2.Node n = first;
        int total = 1;
        // LinkedList의 길이 구하기
        while (n.next != null) {
            total++;
            n = n.next;
        }
        n = first;
        // 반복문으로 해당 노드위치까지 가기
        // 전체길이 - k + 1
        // +1을 하는 이유는 0번째가 아닌 1번째부터 시작하기때문
        for (int i = 1; i < total - k + 1; i++) {
            n = n.next;
        }
        return n;
    }

    // 방법 2
    // 재귀호출하기??
    // 아직 잘 이해되지는 않음...
    static class Reference {
        public int count = 0;
    }
    // 자기 자신을 호출하는 재귀함수 만들기
    private static LinkedListV2.Node KthToLast2(LinkedListV2.Node n, int k, Reference r) {
        //
        if (n == null) {
            return null;
        }
        // 재귀호출 후 r의 카운트 증가
        LinkedListV2.Node found = KthToLast2(n.next, k, r);
        r.count++;
        // k와 카운트가 같다면 n을 리턴
        if (r.count == k) {
            return n;
        }
        // 그렇지 않다면 현재 찾은값을 리턴
        return found;
    }

    // 방법 3
    // 포인터
    private static LinkedListV2.Node KthToLast3(LinkedListV2.Node first, int k) {
        LinkedListV2.Node p1 = first;
        LinkedListV2.Node p2 = first;

        // k만큼 p1을 이동
        for (int i = 0; i < k; i++) {
            if (p1 == null) {
                return null;
            }
            p1 = p1.next;
        }

        // p1이 마지막 값이 될때까지 이동
        // p1이 마지막 값이면 p2는 뒤에서 k번째 노드가 됨
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        // p2를 리턴
        return p2;
    }

}
