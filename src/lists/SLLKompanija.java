package lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SLLNodeLab {
    protected int id;
    protected int plata;
    protected SLLNodeLab succ;

    public SLLNodeLab(int id, int plata, SLLNodeLab succ) {
        this.id = id;
        this.plata = plata;
        this.succ = succ;
    }
}

class SLLLab {
    private SLLNodeLab first;

    public SLLLab() {
        // Construct an empty SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            SLLNodeLab tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;
    }

    public void insertFirst(int id, int plata) {
        SLLNodeLab ins = new SLLNodeLab(id, plata, first);
        first = ins;
    }

    public void insertLast(int id, int plata) {
        if (first != null) {
            SLLNodeLab tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNodeLab ins = new SLLNodeLab(id, plata, null);
            tmp.succ = ins;
        } else {
            insertFirst(id, plata);
        }
    }

    public SLLNodeLab getFirst() {
        return first;
    }

    public SLLLab brisi_pomali_od(int iznos) {
        // Vasiot kod tuka

        //Потребно е да се отстранат сите вработени со помали плати од даден износ,

        SLLNodeLab node = first;
        SLLNodeLab pred = first;

        while (node != null) {
            if (iznos <= node.plata) {
                pred = node;
                node = node.succ;
            } else {
                if (node == first) {
                    first = node.succ;
                    pred = first;
                    node = first;
                } else {
                    pred.succ = node.succ;
                    node = node.succ;
                }
            }
        }
        return this;
    }

    public SLLLab sortiraj_opagacki() {
        // Vasiot kod tuka

        // а остатокот да се прикажат во опаѓачки редослед во однос на ID-то.

        SLLNodeLab node, tmp, pred1, pred2;

        for (int i = 0; i < length(); i++) {
            node = first.succ; //posledovatelen
            pred1 = first; //tekoven
            pred2 = first; //tekoven

            while (node != null) {
                if (pred1.id < node.id) {
                    tmp = node.succ;
                    node.succ = pred1;
                    pred1.succ = tmp;

                    if (pred1 == first) {
                        first = node;
                    } else {
                        pred2.succ = node;
                    }
                    pred2 = node;
                    node = tmp;
                } else {
                    if (pred1 != first) {
                        pred2 = pred2.succ;
                    }
                    pred1 = pred1.succ;
                    node = node.succ;
                }
            }
        }
        return this;
    }

    public void pecati(SLLLab lista) {
        SLLNodeLab p = lista.first;
        while (p != null) {
            System.out.println(p.id + " " + p.plata);
            p = p.succ;
        }
        if (lista.first == null) {
            System.out.println("nema");
        }
    }
}

public class SLLKompanija {
    public static void main(String[] args) throws IOException {

        SLLLab lista1 = new SLLLab();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);

        for (int i = 0; i < N; i++) {
            s = stdin.readLine();
            String s1 = stdin.readLine();
            lista1.insertLast(Integer.parseInt(s), Integer.parseInt(s1));
        }
        s = stdin.readLine();

        lista1 = lista1.brisi_pomali_od(Integer.parseInt(s));
        if (lista1 != null) {
            lista1 = lista1.sortiraj_opagacki();
            lista1.pecati(lista1);
        }
    }
}
