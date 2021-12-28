package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Medicine {
    String name;
    int list, price, numPieces;

    public Medicine(String name, int list, int price, int numPieces) {
        this.name = name;
        this.list = list;
        this.price = price;
        this.numPieces = numPieces;
    }

    @Override
    public int hashCode() {
        //h(w)=(29∗(29∗(29∗0+ASCII(c1))+ASCII(c2))+ASCII(c3))%102780
        // каде зборот w=c1c2c3c4c5…. е составен од сите големи букви.
        return (29 * (29 * (29 * 0 + name.charAt(0)) + name.charAt(1)) + name.charAt(2)) % 102780;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + "\n");
        if (list == 1) sb.append("POZ" + "\n");
        else sb.append("NEG" + "\n");
        sb.append(price + "\n").append(numPieces);
        return sb.toString();
    }
}

public class Apteka {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        CBHT<String, Medicine> pharmacy = new CBHT<>(N * N);

        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(" ");
            String name = parts[0].toUpperCase();
            int list = Integer.parseInt(parts[1]);
            int price = Integer.parseInt(parts[2]);
            int numPieces = Integer.parseInt(parts[3]);
            Medicine medicine = new Medicine(name, list, price, numPieces);
            pharmacy.insert(name, medicine);
        }

        String line;
        while (!(line = br.readLine()).equals("KRAJ")) {
            String cureName = line.toUpperCase();
            int number = Integer.parseInt(br.readLine()); //број на парчиња нарачани од клиентот

            SLLNode<MapEntry<String, Medicine>> node = pharmacy.search(cureName);
            SLLNode<MapEntry<String, Medicine>> node2 = pharmacy.search(cureName.toLowerCase());

            if (node != null && node.element.value.numPieces >= number) {
                System.out.println(node.element.value);
                node.element.value.numPieces -= number;
                System.out.println("Napravena naracka");
            } else if (node != null && node.element.value.numPieces < number) { //Доколку нарачката на клиентот е поголема од залихата
                System.out.println(node.element.value);
                System.out.println("Nema dovolno lekovi");
            } else {
                if (node2 != null && node2.element.value.numPieces >= number) {
                    System.out.println(node2.element.value);
                    node.element.value.numPieces -= number;
                    System.out.println("Napravena naracka");
                } else if (node2 != null && node2.element.value.numPieces < number) { //Доколку нарачката на клиентот е поголема од залихата
                    System.out.println(node2.element.value);
                    System.out.println("Nema dovolno lekovi");
                } else {
                    System.out.println("Nema takov lek");
                }
            }
        }
    }
}

