package lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpecialSLLJoin {

    private static SLL<Integer> specialJoin(SLL<Integer> list1, SLL<Integer> list2) {
        //Треба да се спојат двете листи во една резултантна на тој начин што наизменично прво
        // ќе се додаваат првите два јазли од првата листа во резултантната,
        // па првите два од втората листа, па следните два од првата, па следните два од втората итн.
        SLL<Integer> result = new SLL<>();
        SLLNode<Integer> node1 = list1.getFirst();
        SLLNode<Integer> node2 = list2.getFirst();

        while (node1 != null && node2 != null) {
            for (int i = 0; i < 2; i++) { //првите два јазли од првата листа
                if (node1 != null) {
                    result.insertLast(node1.element);
                    node1 = node1.succ;
                }
            }
            for (int i = 0; i < 2; i++) { //па првите два од втората листа
                if (node2 != null) {
                    result.insertLast(node2.element);
                    node2 = node2.succ;
                }
            }
        }

        while (node1 != null) {
            result.insertLast(node1.element);
            node1 = node1.succ;
        }
        while (node2 != null) {
            result.insertLast(node2.element);
            node2 = node2.succ;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        SLL<Integer> lista1 = new SLL<>();
        SLL<Integer> lista2 = new SLL<>();

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String[] pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista1.insertLast(Integer.parseInt(pomniza[i]));
        }

        s = stdin.readLine();
        N = Integer.parseInt(s);
        s = stdin.readLine();
        pomniza = s.split(" ");
        for (int i = 0; i < N; i++) {
            lista2.insertLast(Integer.parseInt(pomniza[i]));
        }

        SLL<Integer> merged = specialJoin(lista1, lista2);
        System.out.println(merged);

//        Iterator<Integer> it = merged.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//            if (it.hasNext())
//                System.out.println("");
//        }
////        System.out.println();
    }
}
