package lists;

import java.util.Scanner;

public class ListaOdListi {
    public static long findMagicNumber(DLL<DLL<Integer>> list) {
        //Vashiot kod tuka...
        DLLNode<DLL<Integer>> outside = list.getFirst(); //lista od listi
        long product = 1;

        while (outside != null) {
            DLLNode<Integer> inside = outside.element.getFirst(); //vnatreshnata lista
            long sum = 0;
            while (inside != null) {
                //сума на секоја од подлистите
                sum += inside.element;
                inside = inside.succ;
            }
            //производ на овие суми
            product *= sum;
            outside = outside.succ;
        }
        return product;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        DLL<DLL<Integer>> list = new DLL<DLL<Integer>>();
        for (int i = 0; i < n; i++) {
            DLL<Integer> tmp = new DLL<Integer>();
            for (int j = 0; j < m; j++) {
                tmp.insertLast(in.nextInt());
            }
            list.insertLast(tmp);
        }
        in.close();
        System.out.println(findMagicNumber(list));
    }
}
