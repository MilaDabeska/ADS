package lists;

class DLLNodeAud<E extends Comparable<E>> {
    protected E element;
    protected int num_appearances;
    protected DLLNodeAud<E> pred, succ;

    public DLLNodeAud(E element, DLLNodeAud<E> pred, DLLNodeAud<E> succ) {
        this.element = element;
        this.num_appearances = 1;
        this.pred = pred;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString() + "Broj na pojavuvanja:" + num_appearances;
    }
}

public class DLLAud<E extends Comparable<E>> {
    private DLLNodeAud<E> first, last;

    public DLLAud() {
        // Construct an empty SLL
        this.first = null;
        this.last = null;
    }

    public void deleteList() {
        first = null;
        last = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            DLLNodeAud<E> tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }

    public DLLNodeAud<E> find(E o) {
        if (first != null) {
            DLLNodeAud<E> tmp = first;
            while (tmp.element != o && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element == o) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return first;
    }

    public void insertFirst(E o) {
        DLLNodeAud<E> ins = new DLLNodeAud<E>(o, null, first);
        if (first == null)
            last = ins;
        else
            first.pred = ins;
        first = ins;
    }

    public void insertLast(E o) {
        if (first == null)
            insertFirst(o);
        else {
            DLLNodeAud<E> ins = new DLLNodeAud<E>(o, last, null);
            last.succ = ins;
            last = ins;
        }
    }

    public void insertAfter(E o, DLLNodeAud<E> after) {
        if (after == last) {
            insertLast(o);
            return;
        }
        DLLNodeAud<E> ins = new DLLNodeAud<E>(o, after, after.succ);
        after.succ.pred = ins;
        after.succ = ins;
    }

    public void insertBefore(E o, DLLNodeAud<E> before) {
        if (before == first) {
            insertFirst(o);
            return;
        }
        DLLNodeAud<E> ins = new DLLNodeAud<E>(o, before.pred, before);
        before.pred.succ = ins;
        before.pred = ins;
    }

    public E deleteFirst() {
        if (first != null) {
            DLLNodeAud<E> tmp = first;
            first = first.succ;
            if (first != null) first.pred = null;
            if (first == null)
                last = null;
            return tmp.element;
        } else
            return null;
    }

    public E deleteLast() {
        if (first != null) {
            if (first.succ == null)
                return deleteFirst();
            else {
                DLLNodeAud<E> tmp = last;
                last = last.pred;
                last.succ = null;
                return tmp.element;
            }
        }
        // else throw Exception
        return null;
    }

    public E delete(DLLNodeAud<E> node) {
        if (node == first) {
            deleteFirst();
            return node.element;
        }
        if (node == last) {
            deleteLast();
            return node.element;
        }
        node.pred.succ = node.succ;
        node.succ.pred = node.pred;
        return node.element;
    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            DLLNodeAud<E> tmp = first;
            ret += tmp + "<->";
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += tmp + "<->";
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public String toStringR() {
        String ret = new String();
        if (last != null) {
            DLLNodeAud<E> tmp = last;
            ret += tmp + "<->";
            while (tmp.pred != null) {
                tmp = tmp.pred;
                ret += tmp + "<->";
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public DLLNodeAud<E> getFirst() {
        return first;
    }

    public DLLNodeAud<E> getLast() {
        return last;
    }

    public void izvadiDupliIPrebroj() {
        //ќе ги
        //исфрли повеќекратните појавувања на една
        //вредност и ќе остави само еден јазел со оваа во
        //кој ќе се запише колку пати првобитно се
        //појавила вредноста во листата.
        if (first != null) {
            DLLNodeAud<E> tmp = first;
            DLLNodeAud<E> tmp2 = tmp.succ;

            while (tmp != null && tmp2 != null) {
                if (tmp.element.compareTo(tmp2.element) == 0) {
                    tmp.num_appearances++;
                    tmp2 = tmp2.succ;
                    delete(tmp2.pred);
                } else {
                    tmp2 = tmp2.succ;
                }
                tmp = tmp.succ;
                tmp2 = tmp2.succ;
            }
        }
    }
}
