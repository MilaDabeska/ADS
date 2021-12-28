package lists;

public class SingleLinkedList {

    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private static class SLList<E> {
        Node<E> first; //head

        public SLList() {
            this.first = null;
        }

        public void insertNodeAtHead(E data) {
            Node<E> newNode = new Node<E>(data);
            newNode.next = first;
            first = newNode;
        }

        public void insertNodeAtTail(E data) { //dodava na posledno
            if (first == null) { //ako e prazna listata
                first = new Node<E>(data);
                return;
            }

            Node<E> newNode = new Node<>(data);
            Node<E> tmp = first;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = newNode;
        }

        public void deleteAtHead() {
            first = first.next;
        }

        public void deleteAtTail() {
            if (first.next != null) {
                first = null;
                return;
            }
            Node<E> tmp = first;
            while (tmp.next.next != null) { //edno pred kraj
                tmp = tmp.next;
            }
            tmp.next = null;
        }

        public void deleteAt(int position) {
            if (position == 0) {
                deleteAtHead();
                return;
            }
            Node<E> tmp = first;
            int i = 0;
            while (i < position - 1) { //edno prethodno
                tmp = tmp.next;
                i++;
            }
//            System.out.println(tmp.data);
            tmp.next = tmp.next.next;
        }

        public void printInReverse() {
            printRecursive(first);
        }

        private void printRecursive(Node<E> node) {
            if (node == null) return;
            printRecursive(node.next);
            System.out.println(node);
        }

        private void reverseList() {
            Node<E> tmp = first;
            Node<E> prev = null;
            Node<E> next;

            while (tmp != null) {
                next = tmp.next;
                tmp.next = prev;
                prev = tmp;
                tmp = next;
            }
            first = prev;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (first == null) return "Empty list";
            else {
                Node<E> tmp = first;
                while (tmp.next != null) {
                    sb.append(tmp.data + "->");
                    tmp = tmp.next;
                }
                sb.append(tmp.data + "->null"); //za posledniot
                return sb.toString();
            }
        }
    }


    public static void main(String[] args) {
        SLList<Integer> list = new SLList<>();
        list.insertNodeAtTail(0);
        list.insertNodeAtHead(1);
        list.insertNodeAtHead(2);
        list.insertNodeAtHead(3);
        list.insertNodeAtTail(4);
        System.out.println(list);

//        list.deleteAtHead();
//        System.out.println(list);
//
//        list.deleteAtTail();
//        System.out.println(list);

//        list.deleteAt(2);
//        System.out.println(list);

        list.reverseList();
        System.out.println(list);

//        list.printInReverse();

    }
}
