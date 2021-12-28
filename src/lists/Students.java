package lists;

/*
Во еднострано поврзана листа се чуваат податоци за студентите на курсот АиПС.
Во секој јазол од листата се чува број на индекс, име на студентот и поените што
ги освоил на испитот. Потребно е од листата да се отстрани (избрише) студентот кој
има најмал број на поени (секогаш има само еден ваков студент).

Влез: Во првиот ред е даден бројот на студенти. Во секој следен ред дадени се
тројките податоци за секој студент, одделени со празно место, во формат индекс име поени.

Излез: Имињата на студентите, после отстранувањето според условот на задачата.

Забелешка: Даден е целосниот код на структурата која треба да се користи.
Дадена е и тест класата Students.java, со целосно имплементиран input и output.

Потребно е да се менува само во рамки на public static void removeStudent(SLL students) функцијата.
Притоа, не смее да се користи дополнителна листа.

Input:
3
161501 Peter 100
171010 Sarah 50
181018 Joe 70
Output:
Peter
Joe

3
161515 Joe 56
131010 Mark 78
141517 Emily 99
Output:
Mark
Emily

4
161414 Luke 100
151515 Sarah 89
131414 Emily 99
171717 Tom 67
Output:
Luke
Sarah
Emily

5
151615 Jessica 55
161718 Joe 89
161719 Mike 79
121315 Luke 80
131467 Peter 90
Output:
Joe
Mike
Luke
Peter

*/

import java.util.Scanner;

class SLLNode1 {
    String index;
    String name;
    int points;
    SLLNode1 succ;

    public SLLNode1(String index, String name, int points, SLLNode1 succ) {
        this.index = index;
        this.name = name;
        this.points = points;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return name;
    }

}

class SLL1 {
    SLLNode1 first;

    public SLL1() {
        this.first = null;
    }

    public void insertFirst(String index, String name, int points) {
        SLLNode1 ins = new SLLNode1(index, name, points, first);
        first = ins;
    }


    public void insertLast(String index, String name, int points) {
        if (first != null) {
            SLLNode1 tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode1 ins = new SLLNode1(index, name, points, null);
            tmp.succ = ins;
        } else {
            insertFirst(index, name, points);
        }

    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        if (first != null) {
            SLLNode1 tmp = first;
            ret.append(tmp).append("\n");
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret.append(tmp).append("\n");
            }
        } else
            ret = new StringBuilder("NO ELEMENTS");
        return ret.toString();
    }

    public void deleteNode(SLLNode1 node) {
        SLLNode1 tmp = node.succ;
        node.points = tmp.points;
        node.succ = tmp.succ;
    }
}

public class Students {

    public static void removeStudent(SLL1 students) {
        //VASHIOT CODE TUKA

        //Потребно е од листата да се отстрани (избрише) студентот кој
        //има најмал број на поени (секогаш има само еден ваков студент)

        SLLNode1 node = students.first;
        SLLNode1 node2 = students.first;

        while (node != null && node2 != null) {
            if (node.points >= node2.points) {
                node2 = node.succ;
                node.points = node2.points;
                node.succ = node2.succ;
                node=node.succ;
            } else {
                node = node2.succ;
                node2.points = node.points;
                node2.succ = node.succ;
                node2=node2.succ;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SLL1 students = new SLL1();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            students.insertLast(parts[0], parts[1], Integer.parseInt(parts[2]));
        }

        removeStudent(students);
        System.out.println(students.toString());
    }
}

