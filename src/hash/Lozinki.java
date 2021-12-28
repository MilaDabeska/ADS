package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lozinki {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        CBHT<String, String> hash = new CBHT<>(N);
        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split("\\s+");
            String username = parts[0];
            String password = parts[1];
            hash.insert(username, password);
        }
        String line = br.readLine();
        String[] parts = line.split("\\s+");
        while (!parts[0].equals("KRAJ")) { //За означување на крај на обидите во редицата се дава зборот KRAJ
            SLLNode<MapEntry<String, String>> node = hash.search(parts[0]); //go bara usernameot
            if (node == null || !node.element.value.equals(parts[1])) { //доколку не одговара
                System.out.println("Nenajaven");
                line = br.readLine();
                parts = line.split("\\s+");
                continue; // на корисникот му се дава повторна шанса на корисникот да внесе корисничко име и лозинка.
            }
            System.out.println("Najaven");
            break;
        }
    }
}
