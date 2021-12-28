package lists;

import java.util.Scanner;

public class PalindromeDLL {
    public static int isItPalindrome(DLL<Integer> list) {
        //Vashiot kod tuka...
        DLLNode<Integer> first = list.getFirst();
        DLLNode<Integer> last = list.getLast();

        while (first != last) {
            if (!first.element.equals(last.element)) {
                return -1;
            } else {
                first = first.succ;
                last = last.succ;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        DLL<Integer> list = new DLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(in.nextInt());
        }
        in.close();
        System.out.println(isItPalindrome(list));
    }
}
