package linkedlist;

// 중복 메서드 추가
// 시간 복잡도는 O(n), 공간 O(1)
class LinkedListV2 {
    // 헤더를 가지고 있음
    Node header;

    static class Node {
        int data;
        Node next = null;
    }

    // LinkedList의 생성자, 헤더를 가지고 생성
    // 헤더는 데이터를 가지고 있지 않음
    LinkedListV2() {
        header = new Node();
    }

    // 추가 메소드
    void append(int data) {
        // 마지막 노드가 추가되는 것이므로 마지막노드로 생성
        Node end = new Node();
        // 마지막 노드의 데이터 할당
        end.data = data;
        // 노드의 헤더값을 가지고 옴(첫번째)
        Node n = header;
        // 처음부터 마지막까지 while문을 돌림
        // 노드의 next가 null값이면 마지막 노드이므로 마지막 노드가 될때까지 찾음
        while (n.next != null) {
            n = n.next;
        }
        // n에 할당된 마지막 노드에 다음 노드값을 추가
        n.next = end;
    }

    // 삭제 메소드
    // 이전에는 헤더값을 지우지 못했지만 헤더값을 따로 할당했으므로 첫번째 값도 지울수 있음
    void delete(int data) {
        // 노드의 헤더값을 가지고 옴(첫번째)
        Node n = header;
        // 처음부터 마지막까지 while문을 돌림
        // 노드의 next가 null값이면 마지막 노드이므로 마지막 노드가 될때까지 찾음
        while (n.next != null) {
            // 지금노드의 다음 데이터가 삭제할 데이터와 같은지 확인
            if (n.next.data == data) {
                // 맞다면 그 데이터를 지우는 것이므로 지금 노드의 다음값을 다음다음 노드의 값으로 바꿔줌
                n.next = n.next.next;
            } else {
                // 틀리다면 다음노드값으로 넘어감
                n = n.next;
            }
        }
    }

    // 확인 메서드
    void retrieve() {
        // 헤더는 데이터가 없으므로 헤더의 다음 데이터를 n에 할당
        Node n = header.next;
        // append가 없었다면 header의 다음값이 없으므로 empty출력
        if (n == null) {
            System.out.println("empty");
        } else {
            // while문을 돌며 프린트
            while (n.next != null) {
                System.out.print(n.data + " -> ");
                n = n.next;
            }
            // 마지막 노드는 while문에서 프린트 하지 않으므로 마지막 노드 프린트
            System.out.println(n.data);
        }
    }

    // 중복제거 메서드
    void removeDups() {
        // 노드의 헤더값을 가지고 옴
        Node n = header;
        // 처음부터 마지막까지 while문을 돌림
        // 노드의 next가 null값이면 마지막 노드이므로 마지막 노드가 될때까지 찾음
        // 마지막 노드가 중복값이어서 제거될 경우도 있으므로 n != null 조건값 추가
        while (n != null && n.next != null) {
            // 중복되는 값을 찾기위한 노드를 하나 더 생성
            Node r = n;
            // 마지막 까지 while문을 돌림
            while (r.next != null) {
                // 비교할 원래의 값인 n의 data값과 비교할 대상값인 r의 다음 노드의 data값을 비교
                // 맞다면 중복이므로 중복값을 삭제
                // r의 다음값을 다음다음값으로 교체
                if (n.data == r.next.data) {
                    r.next = r.next.next;
                // 틀리다면 다음 노드로 넘어감
                } else {
                    r = r.next;
                }
            }
            // 다음 노드로 넘어감
            n = n.next;
        }
    }
}

public class LinkedList03 {
    public static void main(String[] args) {
        LinkedListV2 ll = new LinkedListV2();
        ll.append(2);
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(4);
        ll.append(2);
        ll.retrieve();
        ll.removeDups();
        ll.retrieve();
        LinkedListV2 ll2 = new LinkedListV2();
        ll2.append(2);
        ll2.append(2);
        ll2.retrieve();
        ll2.removeDups();
        ll2.retrieve();
    }
}
