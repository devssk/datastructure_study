package linkedlist;

// Node로만 하게되면 헤더의 문제, 헤더를 참조하는 다른 클래스들이 있을경우나 헤더값을 지우지못하는 문제 등을 해결하기위함
// LinkedList로 header를 담당하는 노드를 따로 할당하여 사용함
class LinkedListV1 {
    // 헤더를 가지고 있음
    Node header;

    static class Node {
        int data;
        Node next = null;
    }

    // LinkedList의 생성자, 헤더를 가지고 생성
    // 헤더는 데이터를 가지고 있지 않음
    LinkedListV1() {
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
}

public class LinkedList02 {
    public static void main(String[] args) {
        LinkedListV1 ll = new LinkedListV1();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();
        ll.delete(1);
        ll.retrieve();

        LinkedListV1 ll2 = new LinkedListV1();
        ll2.retrieve();
    }
}
