package stack;

import java.util.EmptyStackException;

// 스택 구현하기
// stack? 마지막에 들어온것이 먼저 나가는 일직선 데이터 구조
// Last In First Out 줄여서 LIFO라고도 하며 한국어로 하면 후입선출
class Stack<T> {

    // 노드
    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    // 스택은 나중에 들어온 값인 top을 가지고있음
    private Node<T> top;

    // pop 구현
    // pop는 마지막 값을 삭제하고 출력
    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }

        T temp = top.data;
        top = top.next;
        return temp;
    }

    // push 구현
    // push는 마지막 값 추가
    public void push(T item) {
        Node<T> t = new Node<T>(item);
        t.next = top;
        top = t;
    }

    // peek 구현
    // peek는 top값을 출력만 함
    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    // isEmpty구현
    // top가 null 인지 아닌지
    public boolean isEmpty() {
        return top == null;
    }
}

public class Stack01 {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
    }
}
