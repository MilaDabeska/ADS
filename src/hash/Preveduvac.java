package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Preveduvac {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        OBHT<String, String> dictionary = new OBHT<>(n*n);
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split("\\s+");
            String mk = parts[0];
            String eng = parts[1];
            dictionary.insert(eng, mk);
        }
        String line = br.readLine();
        while (!line.equals("KRAJ")) {
            int node = dictionary.search(line);
            if (node == -1) {
                System.out.println("/");
                line = br.readLine();
                continue;
            }
            System.out.println(dictionary.getValue(node));
            line = br.readLine();
        }
    }
}
