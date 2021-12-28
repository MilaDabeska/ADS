package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// da ja doreshishh!!!

public class RoutingHashJava {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int routerNum = Integer.parseInt(br.readLine());
        CBHT<String, String[]> hash = new CBHT<>(100*100);
        for (int i = 0; i < routerNum; i++) {
            String[] parts = br.readLine().split("\\.");
            String ipInput = parts[0];
            String ip = parts[1];
            String[] ipNet = ip.split("\\.");
            hash.insert(ipInput, ipNet);
        }

        int routingPacket = Integer.parseInt(br.readLine());
        for (int i = 0; i < routingPacket; i++) {
            String[] parts = br.readLine().split("\\.");
            String inputInterface = parts[0];
            String ipDevice = parts[1];
            SLLNode<MapEntry<String, String[]>> node = hash.search(inputInterface);
            if (node != null) {
                System.out.println("ne postoi");
                continue;
            }
            String[] destination = ipDevice.split("\\.");
            String[] idk = node.element.value;
            boolean flag = false;
            for (int j = 0; j < idk.length; j++) {
                String[] table = idk[j].split("\\.");
                if (destination[0].equals(table[0]) && destination[1].equals(table[1]) && destination[2].equals(table[2])) {
                    flag = true;
                    break;
                }
            }
            if (flag == true) {
                System.out.println("postoi");
            } else System.out.println("ne postoi");
        }
    }
}
