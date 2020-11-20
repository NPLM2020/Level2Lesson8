package structure.impl;

import structure.customlist.GBIterator;
import structure.customlist.GBList;

//Реализовать двусвязный список.
// Двусвязный список - это такое список, который хранит специальном внутреннем контейнере значение и
// ссылки на предыдущий и следующий элементы. Важно отметить, что ссылка первого элемента на
// предыдущий всегда пустая, а для последнего - на следующий, поскольку в таких случая данным узлам
// не на что ссылаться
public class DoubleLinkedList implements GBList {

    private Node first;
    private int size = 0;

    @Override
    public String toString() {
        Node current = first;
        StringBuilder sb = new StringBuilder("DoubleLinkedList:\n");
        while (current != null) {
            sb.append(current);
            current = current.next;
        }
        return sb.toString();
    }

    @Override
    public void add(String val) {
        if (first == null) {
            first = new Node(val);
        } else {
            add(first, val);
        }
        size++;
    }

    private void add(Node current, String val) {
        if (current.next == null) {
            current.setNext(new Node(val, null, current));
            return;
        }
        add(current.next, val);
    }

    @Override
    public boolean remove(String val) {
        if (first.val.equals(val)) {
            first = first.next;
            first.setPrev(null);
            size--;
            return true;
        }

        Node current = first.next;
        while (current != null) {
            if (current.val.equals(val)) {
                if (current.next != null) {
                    current.next.setPrev(current.prev);
                    current.prev.setNext(current.next);
                } else current.prev.setNext(null);
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }


    // Реализовать метод GBList#get(int index): String. Метод получает на вход значение N >= 0,
    // где N - это индекс элемента и если N находится в диапазоне фактической длины списка,
    // то находит соответствующи возращает NULL
    @Override
    public String get(int index) {
        if (index >= 0) {
            int i = 0;
            Node current = first;
            while (index != i) {
                if (current.next != null) {
                    current = current.next;
                    i++;
                } else return null;
            }
            return current.val;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public GBIterator iterator() {
        return new ListIterator(first);
    }

    private static class Node {
        private String val;
        private Node next;

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        private Node prev;

        public Node(String val) {
            this(val, null, null);
        }

        public Node(String val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Node{" + "prev=\'" + (prev != null ? prev.val : null) + "\'" +
                    ", val=\'" + val + '\'' +
                    ", next=\'" + (next != null ? next.val : null) +
                    "\'}\n";
        }
    }

    public static class ListIterator implements GBIterator {
        private Node current;

        public ListIterator(Node current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public boolean hasPrev() {
            return false;
        }

        @Override
        public String prev() {
            return null;
        }

        @Override
        public String next() {
            String val = current.val;
            current = current.next;
            return val;
        }
    }


}
