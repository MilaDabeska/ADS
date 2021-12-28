package lists;

import java.util.Scanner;

//  termin 2. Lista od torti dadena, koi imaat ceni-bez koristenje na pomosna lista da se najde
//  average(zbir od cenite na tortite/brojot na torti) i da se trgnat od listata site
//  torti koi se nad average

class SLLNode2 {
    String name;
    int price;
    SLLNode2 succ;

    public SLLNode2(String name, int price, SLLNode2 succ) {
        this.name = name;
        this.price = price;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return name + " " + price;
    }
}

class SLL2 {
    SLLNode2 first;

    public SLL2() {
        this.first = null;
    }

    public void insertFirst(String name, int price) {
        SLLNode2 ins = new SLLNode2(name, price, first);
        first = ins;
    }

    public void insertLast(String name, int price) {
        if (first != null) {
            SLLNode2 tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode2 ins = new SLLNode2(name, price, null);
            tmp.succ = ins;
        } else {
            insertFirst(name, price);
        }
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        if (first != null) {
            SLLNode2 tmp = first;
            ret.append(tmp).append("\n");
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret.append(tmp).append("\n");
            }
        } else
            ret = new StringBuilder("NO ELEMENTS");
        return ret.toString();
    }

    public SLLNode2 getFirst() {
        return first;
    }

    public SLLNode2 getPrice() {
        return getPrice();
    }
}

public class CakeShop {
    public static void removeCakes(SLL2 cakes) {
        //todo: implement method
        SLLNode2 prv = cakes.first;
        SLLNode2 dvizi = cakes.first;
        SLLNode2 temp = cakes.first;

        int sum = 0;
        float avg;
        int brojac = 0;
        boolean flag = true;

        while (dvizi != null) {
            sum += dvizi.price; //zbir od cenite na tortite
            brojac++; //brojot na torti
            dvizi = dvizi.succ;
        }

        avg = sum / brojac;
        dvizi = cakes.first;

        while (dvizi != null) {
            if (dvizi.price <= avg && flag) {
                prv = dvizi;
                temp = dvizi;
                flag = false;
            } else if (dvizi.price <= avg) {
                temp.succ = dvizi;
                temp = dvizi;
            }
            if (dvizi.succ == null) {
                temp.succ = null;
            }
            dvizi = dvizi.succ;
        }
        cakes.first = prv;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SLL2 cakes = new SLL2();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            cakes.insertLast(parts[0], Integer.parseInt(parts[1]));
        }

        removeCakes(cakes);
        System.out.println(cakes.toString());
    }
}
