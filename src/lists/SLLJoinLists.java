//package lists;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Iterator;
//
//public class SLLJoinLists {
//    public static void main(String[] args) throws IOException {
//        SLL<Integer> lista1 = new SLL<Integer>();
//        SLL<Integer> lista2 = new SLL<Integer>();
//
//        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
//        String s = stdin.readLine();
//        int N = Integer.parseInt(s);
//        s = stdin.readLine();
//        String[] pomniza = s.split(" ");
//        for (int i = 0; i < N; i++) {
//            lista1.insertLast(Integer.parseInt(pomniza[i]));
//        }
//
//        s = stdin.readLine();
//        N = Integer.parseInt(s);
//        s = stdin.readLine();
//        pomniza = s.split(" ");
//        for (int i = 0; i < N; i++) {
//            lista2.insertLast(Integer.parseInt(pomniza[i]));
//        }
//
//        SLL<Integer> merged = lista1.joinLists(lista2);
//        merged.deleteDuplicates(merged);
//
//        Iterator<Integer> iterator = merged.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//            if (iterator.hasNext()) System.out.println(" ");
//        }
//        System.out.println();
//    }
//}
