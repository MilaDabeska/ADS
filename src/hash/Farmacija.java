package hash;

/*
Во магацинот на една фармацевтска компанија се чуваат најразлични видови лекови.
За секој лек потребно е да се чуваат податоци за името на лекот, цената во денари и
намената на лекот. За поефикасен пристап до податоците за лековите, фармацевтската компанија
одлучила податоците да ги чува во хеш табела (CBHT) каде се сместуваат соодветните податоци.

Хеш табелата е достапна до крајните клиенти и истите може да пребаруваат низ внесените
податоци. Бидејќи на пазарот постојат повеќе лекови кои таргетираат иста болест, најчесто
клиентите го бараат оној лек кој има најниска цена. Па вашата задача е со користење на
хеш табелата, за дадена намена (болест), да го испечатите лекот кој има најниска цена на пазарот.
Доколку за бараната намена во магацинот нема лек се печати "Nema lek za baranata
namena vo magacin.".

Влез:

Најпрво е даден бројот на лекови -  за дадена намена (болест), да го испечатите лекот кој има најниска цена на пазарот.N, а потоа секој лек е даден во нов ред во форматот:

“Име на лек” “Намена” “Цена во денари”

На крај е дадена намената за која треба да се пронајде лекот со најниска цена.

Излез:

Името на лекот со најмала цена.

input:
5
Analgin Glavobolka 80
Daleron Glavobolka 90
Lineks Bolki_vo_stomak 150
Spazmeks Bolki_vo_stomak 150
Loratadin Alergija 150
Glavobolka

output:
Analgin

*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Cure {
    String name, purpose;
    int price;

    public Cure(String name, String purpose, int price) {
        this.name = name;
        this.purpose = purpose;
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Farmacija {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        //
        CBHT<String, Cure> pharmacy = new CBHT<>(N * N);

        for (int i = 0; i < N; i++) {
            String p[] = bf.readLine().split(" ");
            String ime = p[0];
            String namena = p[1];
            Integer cena = Integer.parseInt(p[2]);
            Cure cure = new Cure(ime, namena, cena);
            pharmacy.insert(namena, cure);
        }

        String namena = bf.readLine();
        SLLNode<MapEntry<String, Cure>> node = pharmacy.search(namena);
        String cureName = "";
        int min = Integer.MAX_VALUE;
        while (node != null) {
            if (node != null) {
                if (node.element.value.price <= min) {
                    min = node.element.value.price;
                    cureName = node.element.value.name;
                }
                node = node.succ;
            } else {
                System.out.println("Nema lek za baranata namena vo magacin.");
            }
        }
        String lek = cureName;
        System.out.println(lek);
    }
}

