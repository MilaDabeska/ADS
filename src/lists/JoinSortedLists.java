package lists;

public class JoinSortedLists<E extends Comparable<E>> {

    public SLL<E> join(SLL<E> list1, SLL<E> list2) {

        SLL<E> result = new SLL<>(); //rezultantna lista,onaa sto treba da ja vratime
        SLLNode<E> node1 = list1.getFirst();
        SLLNode<E> node2 = list2.getFirst();

        while (node1 != null && node2 != null) { //se dodeka imame elementi vo dvete listi(dur ne stigneme do nula elementi)
            if (node1.element.compareTo(node2.element) < 0) { //ako node1 e pomal
                result.insertLast(node1.element); //mora so insertLast za da ne gi prevrti;dodavanje vo redosled kako sto gi citame
                node1 = node1.succ; //odime na slenite jazli
            } else {
                result.insertLast(node2.element);
                node2 = node2.succ;
            }
        }

        while (node1 != null) { //iteracija
            result.insertLast(node1.element);
            node1 = node1.succ;
        }
        while (node2 != null) { //iteracija
            result.insertLast(node2.element);
            node2 = node2.succ;
        }
        return result;
    }

    public static void main(String[] args) {
//        SLL<String> list1 = new SLL<>();
//        list1.insertLast("Ana");
//        list1.insertLast("Bojana");
//        list1.insertLast("Dejan");
//        list1.insertLast("Mila");
//
//        SLL<String> list2 = new SLL<>();
//        list2.insertLast("Andrijana");
//        list2.insertLast("Biljana");
//        list2.insertLast("Darko");
//        list2.insertLast("Marija");
//
//        JoinSortedLists<String> joinSortedLists = new JoinSortedLists<>();
//        System.out.println(joinSortedLists.join(list1, list2));
        SLL<Integer> list1 = new SLL<>();
        list1.insertLast(5);
        list1.insertLast(2);
        list1.insertLast(9);
        list1.insertLast(15);

        SLL<Integer> list2 = new SLL<>();
        list2.insertLast(3);
        list2.insertLast(12);
        list2.insertLast(10);
        list2.insertLast(7);

        JoinSortedLists<Integer> joinSortedLists = new JoinSortedLists<>();
        System.out.println(joinSortedLists.join(list1, list2));
    }
}
