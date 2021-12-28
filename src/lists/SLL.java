//package lists;
//
//import java.util.Iterator;
//import java.util.NoSuchElementException;
//
//public class SLL<E extends Comparable<E>> {
//    private SLLNode<E> first;
//
//    public SLL() {
//        // Construct an empty SLL
//        this.first = null;
//    }
//
//    public void deleteList() {
//        first = null;
//    }
//
//    public int length() {
//        int ret;
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            ret = 1;
//            while (tmp.succ != null) {
//                tmp = tmp.succ;
//                ret++;
//            }
//            return ret;
//        } else
//            return 0;
//
//    }
//
//    @Override
//    public String toString() {
//        String ret = new String();
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            ret += tmp + "->";
//            while (tmp.succ != null) {
//                tmp = tmp.succ;
//                ret += tmp + "->";
//            }
//        } else
//            ret = "Prazna lista!!!";
//        return ret;
//    }
//
//    public void insertFirst(E o) {
//        SLLNode<E> ins = new SLLNode<E>(o, first);
//        first = ins;
//    }
//
//    public void insertAfter(E o, SLLNode<E> node) {
//        if (node != null) {
//            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
//            node.succ = ins;
//        } else {
//            System.out.println("Dadenot jazol e null");
//        }
//    }
//
//    public void insertBefore(E o, SLLNode<E> before) {
//
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            if (first == before) {
//                this.insertFirst(o);
//                return;
//            }
//            //ako first!=before
//            while (tmp.succ != before)
//                tmp = tmp.succ;
//            if (tmp.succ == before) {
//                SLLNode<E> ins = new SLLNode<E>(o, before);
//                tmp.succ = ins;
//            } else {
//                System.out.println("Elementot ne postoi vo listata");
//            }
//        } else {
//            System.out.println("Listata e prazna");
//        }
//    }
//
//    public void insertLast(E o) {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            while (tmp.succ != null)
//                tmp = tmp.succ;
//            SLLNode<E> ins = new SLLNode<E>(o, null);
//            tmp.succ = ins;
//        } else {
//            insertFirst(o);
//        }
//    }
//
//    public E deleteFirst() {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            first = first.succ;
//            return tmp.element;
//        } else {
//            System.out.println("Listata e prazna");
//            return null;
//        }
//    }
//
//    public E delete(SLLNode<E> node) {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            if (first == node) {
//                return this.deleteFirst();
//            }
//            while (tmp.succ != node && tmp.succ.succ != null)
//                tmp = tmp.succ;
//            if (tmp.succ == node) {
//                tmp.succ = tmp.succ.succ;
//                return node.element;
//            } else {
//                System.out.println("Elementot ne postoi vo listata");
//                return null;
//            }
//        } else {
//            System.out.println("Listata e prazna");
//            return null;
//        }
//
//    }
//
//    public SLLNode<E> getFirst() {
//        return first;
//    }
//
//    public SLLNode<E> find(E o) {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            while (tmp.element != o && tmp.succ != null)
//                tmp = tmp.succ;
//            if (tmp.element == o) {
//                return tmp;
//            } else {
//                System.out.println("Elementot ne postoi vo listata");
//            }
//        } else {
//            System.out.println("Listata e prazna");
//        }
//        return first;
//    }
//
//    public Iterator<E> iterator() {
//        // Return an iterator that visits all elements of this list, in left-to-right order.
//        return new LRIterator<E>();
//    }
//
//    // //////////Inner class ////////////
//
//    private class LRIterator<E> implements Iterator<E> {
//
//        private SLLNode<E> place, curr;
//
//        private LRIterator() {
//            place = (SLLNode<E>) first;
//            curr = null;
//        }
//
//        public boolean hasNext() {
//            return (place != null);
//        }
//
//        public E next() {
//            if (place == null)
//                throw new NoSuchElementException();
//            E nextElem = place.element;
//            curr = place;
//            place = place.succ;
//            return nextElem;
//        }
//
//        public void remove() {
//            //Not implemented
//        }
//    }
//
//    public void mirror() {
//        if (first != null) {
//            //m=nextsucc, p=tmp,q=next
//            SLLNode<E> tmp = first;
//            SLLNode<E> newsucc = null;
//            SLLNode<E> next;
//
//            while (tmp != null) {
//                next = tmp.succ;
//                tmp.succ = newsucc;
//                newsucc = tmp;
//                tmp = next;
//            }
//            first = newsucc;
//        }
//    }
//
//    public void merge(SLL<E> in) {
//        if (first != null) {
//            SLLNode<E> tmp = first;
//            while (tmp.succ != null)
//                tmp = tmp.succ;
//            tmp.succ = in.getFirst();
//        } else {
//            first = in.getFirst();
//        }
//    }
//
//    public SLL<E> joinLists(SLL<E> list2) {
//        SLL<E> result = new SLL<>();
//        SLLNode<E> node1 = getFirst(); //mora vaka
//        SLLNode<E> node2 = list2.getFirst();
//
//        while (node1 != null && node2 != null) {
//            if (node1.element.compareTo(node2.element) < 0) {
//                result.insertLast(node1.element);
//                node1 = node1.succ;
//            } else {
//                result.insertLast(node2.element);
//                node2 = node2.succ;
//            }
//        }
//
//        while (node1 != null) {
//            result.insertLast(node1.element);
//            node1 = node1.succ;
//        }
//        while (node2 != null) {
//            result.insertLast(node2.element);
//            node2 = node2.succ;
//        }
//
//        return result;
//    }
//
//    public void deleteDuplicates(SLL<E> list) {
//        SLLNode<E> node = list.getFirst();
//
//        while (node != null && node.succ != null) { //tekovniot i posledovatelniot jazol
//            if (node.element.equals(node.succ.element)) {
//                node.succ = node.succ.succ;
//            } else
//                node = node.succ;
//        }
//    }
//
//    public SLL<E> specialJoin(SLL<E> list1, SLL<E> list2) {
//        //Треба да се спојат двете листи во една резултантна на тој начин што наизменично прво
//        // ќе се додаваат првите два јазли од првата листа во резултантната,
//        // па првите два од втората листа, па следните два од првата, па следните два од втората итн.
//        SLL<E> result = new SLL<>();
//        SLLNode<E> node1 = list1.getFirst();
//        SLLNode<E> node2 = list2.getFirst();
//
//        while (node1 != null && node2 != null) {
//            for (int i = 0; i < 2; i++) { //првите два јазли од првата листа
//                if (node1 != null) {
//                    result.insertLast(node1.element);
//                    node1 = node1.succ;
//                }
//            }
//            for (int i = 0; i < 2; i++) { //па првите два од втората листа
//                if (node2 != null) {
//                    result.insertLast(node2.element);
//                    node2 = node2.succ;
//                }
//            }
//        }
//
//        while (node1 != null) {
//            result.insertLast(node1.element);
//            node1 = node1.succ;
//        }
//        while (node2 != null) {
//            result.insertLast(node2.element);
//            node2 = node2.succ;
//        }
//        return result;
//    }
//
//}
//
