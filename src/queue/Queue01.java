package queue;

import java.util.NoSuchElementException;

// 큐 구현하기
// queue? 먼저 들어온것이 먼저 나가는 일직선 데이터 구조
// First In First Out 줄여서 FIFO라고도 하며 한국어로 하면 선입선출
class Queue<T> {
    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    // 큐는 처음값과 마지막 값을 가지고 있음
    private Node<T> first;
    private Node<T> last;

    // add 구현
    // 마지막 값에 추가
    // 처음값이 없다면 처음값과 마지막 값을 같게 넣어줌
    public void add(T item) {
        Node<T> t = new Node<T>(item);

        if (last != null) {
            last.next = t;
        }
        last = t;
        if (first == null) {
            first = last;
        }
    }

    // remove 구현
    // remove는 처음값을 삭제하고 출력
    public T remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        T temp = first.data;
        first = first.next;

        if (first == null) {
            last = null;
        }
        return temp;
    }

    // peek 구현
    // peek는 처음값을 출력
    public T peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    // isEmpty 구현
    // first가 null 인지 아닌지
    public boolean isEmpty() {
        return first == null;
    }
}

public class Queue01 {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
    }
}
