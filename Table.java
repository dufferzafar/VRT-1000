import java.net.*;
import java.util.*;

public class Table {
    Map<Integer, List> table;

    public Table() {
        table = new HashMap();
    }

    public void add(String destinationIP, String nextHop, Integer iface) {
        try {
            table.put(iface, Arrays.asList(InetAddress.getByName(destinationIP), InetAddress.getByName(nextHop)));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public void print() {
        System.out.println("-------------------------------------------------");
        System.out.println("|   Destination   |     Next Hop    | Interface |");
        System.out.println("-------------------------------------------------");

        for (Map.Entry<Integer, List> item : table.entrySet()) {
            List<InetAddress> values = item.getValue();
            System.out.printf(
                "| %15s | %15s | %5d     |\n",
                values.get(0).getHostAddress(),
                values.get(1).getHostAddress(),
                item.getKey()
            );
        }

        System.out.println("-------------------------------------------------");
    }
}

