package hash;

/*
Поради ковид пандемијата при секое тестирање на даден пациент се зачувува општината во која живее,
неговото презиме и дали е позитивен или негативен на корoна вирусот.
Потребни се статистички податоци во коишто ќе се одреди ризик факторот за дадена општина.
За таа цел се чуваат две хеш табели (CBHT) едната за позитивни, а другата за негативни
пациенти од корона вирусот. Ваша задача е за дадена општина на излез да го испечатите
ризик факторот во дадената општина.
Ризик фактор = (број на позитивни пациенти)/(број на негативни пациенти+број на позитивни пациенти)
Забелешка: Можно е да се појават пациенти со исто презиме. Истите треба да се земат како
посебни вредности во статистиката.

Влез:
На влез најпрво е даден бројот на пациенти - N, а потоа секој пациент е даден во нов
ред во форматот:
“Општина во која живее”  “Презиме на пациент”  “Резултати од тестот(позитивен/негативен)”
На крај е дадена општината за која треба да се пресмета ризик факторот

Излез:
Децимален број заокружен на две децимали кој го претставува ризик факторот за дадената општина

input:
5
Centar Trajko pozitiven
Centar Vladislav negativen
Karpos Svetoslava pozitiven
Centar Trajan negativen
Karpos Darko pozitiven
Centar

output:
0.33

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoronaRiskFactor {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        CBHT<String, String> positive = new CBHT<>(N * N);
        CBHT<String, String> negative = new CBHT<>(N * N);

        for (int i = 0; i < N; i++) {
            String p = bf.readLine();
            String[] cut = p.split(" ");
            String opstina = cut[0];
            String prezime = cut[1];
            String rezultat = cut[2];
            if (rezultat.equals("pozitiven")) {
                positive.insert(opstina, prezime);
            } else if (rezultat.equals("negativen")) {
                negative.insert(opstina, prezime);
            }
        }

        String opshitina = bf.readLine();

        int positiveCount = 0;
        SLLNode<MapEntry<String, String>> node = positive.search(opshitina);
        while (node != null) {
            if (node != null) {
                positiveCount++;
                node = node.succ;
            }
        }

        int negativeCount = 0;
        SLLNode<MapEntry<String, String>> node2 = positive.search(opshitina);
        while (node2 != null) {
            if (node2 != null) {
                negativeCount++;
                node2 = node2.succ;
            }
        }

        //Ризик фактор = (број на позитивни пациенти)/(број на негативни пациенти+број на позитивни пациенти)
        float riskFactor = (float) positiveCount / (negativeCount + positiveCount);
        System.out.printf("%.2f", riskFactor);
    }
}
