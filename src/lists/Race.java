package lists;

/*

Податоците за атлетичарите кои учествувале на трките на 100m се чуваат во две еднострано поврзани листи.

Во првата листа се чуваат податоците за атлетичарите кои победиле на трките во изминатите години (не вклучувајќи ја тековната година), а во втората листа се чуваат податоците за атлетичарите кои се натпреварувале во тековната година.

И кај двете листи, во секој од јазлите се чуваат број за идентификација (id) и време (во секунди како децимален број) за кое атлетичарот ја завршил трката.

Потребно е да се изберат атлетичари, за тековната година, кои ќе продолжат на следната Олимпијада.

За таа цел, потребно е од листата на атлетичари за тековната година да се отстранат (избришат) сите атлетичари кои имаат поголемо/полошо време од максималното (најлошото) време кое го остварил некој од победниците во изминатите години.

Влез:

Во првиот ред е даден бројот на победници од изминатите години.

Во вториот ред е даден бројот на атлетичари од тековната година.

Во следните редови се дадени паровите податоци за секој атлетичар, одделени со празно место, во формат id време.

Излез:

Во еден ред id на сите атлетичари кои ќе продолжат на Олимпијадата.

Забелешка: Даден е целосниот код на структурата којашто треба да се користи. Дадена е и тест класата Race.java, со целосно имплементиран input и output. Потребно е да се менува само во рамки на void competition(SLL<Athlete> prevWinners, SLL<Athlete> currYearRunners) функцијата. Притоа, бришењето треба да биде имплементирано како бришење на цел јазел!

Input
2
3
884 13.30
824 17.36
665 12.40
529 29.59
628 25.21

Result
665


*/


import java.util.Scanner;

class Athlete {
    private int id;
    private double time;

    public Athlete(int id, double time) {
        this.id = id;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public double getTime() {
        return time;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class SLL<E> {
    private SLLNode<E> first;

    public SLL() {
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            SLLNode<E> tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNode<E> tmp = first;
            ret += tmp;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += " " + tmp;
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void insertFirst(E o) {
        SLLNode<E> ins = new SLLNode<E>(o, first);
        first = ins;
    }

    public void insertAfter(E o, SLLNode<E> node) {
        if (node != null) {
            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Dadenot jazol e null");
        }
    }

    public void insertBefore(E o, SLLNode<E> before) {
        if (first != null) {
            SLLNode<E> tmp = first;
            if (first == before) {
                this.insertFirst(o);
                return;
            }
            while (tmp.succ != before)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                SLLNode<E> ins = new SLLNode<E>(o, before);
                tmp.succ = ins;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
    }

    public void insertLast(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode<E> ins = new SLLNode<E>(o, null);
            tmp.succ = ins;
        } else {
            insertFirst(o);
        }
    }

    public E deleteFirst() {
        if (first != null) {
            SLLNode<E> tmp = first;
            first = first.succ;
            return tmp.element;
        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public E delete(SLLNode<E> node) {
        if (first != null) {
            SLLNode<E> tmp = first;
            if (first == node) {
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node.element;
            } else {
                System.out.println("Elementot ne postoi vo listata");
                return null;
            }
        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public SLLNode<E> getFirst() {
        return first;
    }

    public SLLNode<E> find(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
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
}

public class Race {

    //todo: implement function
    public static void competition(SLL<Athlete> prevWinners, SLL<Athlete> currYearRunners) {
        SLLNode<Athlete> node2 = currYearRunners.getFirst();
        SLLNode<Athlete> tmp2 = currYearRunners.getFirst();

//        double time = 0;
//        int counter = 0;
//
//        while (node2 != null) {
//            time += node2.element.getTime();
//            counter++;
//            node2 = node2.succ;
//        }
//        time = time / counter;
//        while (tmp2 != null) {
//            if (time < tmp2.element.getTime())
//                currYearRunners.delete(tmp2);
//            tmp2 = tmp2.succ;
//        }


        while (node2 != null) {
            if (node2.element.getTime() >= tmp2.element.getTime()) {
                tmp2 = node2;
                currYearRunners.delete(tmp2);
            }
            node2 = node2.succ;
        }

        while (node2 != null) {
            node2 = node2.succ;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int prevWinnersCount = Integer.parseInt(scanner.nextLine());
        int currYearRunnersCount = Integer.parseInt(scanner.nextLine());
        SLL<Athlete> prevWinners = new SLL<Athlete>();
        SLL<Athlete> currYearRunners = new SLL<Athlete>();

        for (int i = 0; i < prevWinnersCount; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            prevWinners.insertLast(new Athlete(Integer.parseInt(parts[0]), Double.parseDouble(parts[1])));
        }

        for (int i = 0; i < currYearRunnersCount; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            currYearRunners.insertLast(new Athlete(Integer.parseInt(parts[0]), Double.parseDouble(parts[1])));
        }

        competition(prevWinners, currYearRunners);
        System.out.println(currYearRunners.toString());
    }
}

