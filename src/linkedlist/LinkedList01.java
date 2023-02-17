package linkedlist;

// 단방향 linkedList 구현
// 간단하게 int로만 데이터를 받음
// 각 노드들은 다음 노드의 주소값을 가지고 있음
class Node {
    int data;
    Node next = null;

    // 노드의 생성자, 데이터를 파라미터로 받음
    Node(int data) {
        this.data = data;
    }

    // 추가 메소드
    void append(int data) {
        // 마지막 노드가 추가되는 것이므로 마지막노드로 생성
        Node end = new Node(data);
        // 할당된 노드를 불러옴
        Node n = this;
        // 처음부터 마지막까지 while문을 돌림
        // 노드의 next가 null값이면 마지막 노드이므로 마지막 노드가 될때까지 찾음
        while (n.next != null) {
            n = n.next;
        }
        // n에 할당된 마지막 노드에 다음 노드값을 추가
        n.next = end;
    }

    // 삭제 메소드
    // 지금 구현한 linkedList는 헤더값을 지우지 못함
    void delete(int data) {
        // 할당된 노드를 불러옴
        Node n = this;
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

    // linkedList 확인 메서드
    void retrieve() {
        // 할당된 노드를 불러옴
        Node n = this;
        // while문을 돌며 프린트
        while (n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        // 마지막 노드는 while문에서 프린트 하지 않으므로 마지막 노드 프린트
        System.out.println(n.data);
    }
}

public class LinkedList01 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.retrieve();
        head.delete(3);
        head.retrieve();
        head.delete(2);
        head.retrieve();
    }
}
