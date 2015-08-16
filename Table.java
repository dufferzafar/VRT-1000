import java.net.*;
import java.util.*;

public class Table {
    Map<Integer, List> table;

    public Table() {
        table = new HashMap();
    }

    public void add(String destinationIP, String nextHop, Integer iface) {
        try {
            table.put(iface, Arrays.asList(IPAddress(destinationIP), IPAddress(nextHop)));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public boolean isEmpty() {
        return table.size() == 0;
    }

    public void print() {
        System.out.println("-------------------------------------------------");
        System.out.println("|   Destination   |     Next Hop    | Interface |");
        System.out.println("-------------------------------------------------");

        for (Map.Entry<Integer, List> item : table.entrySet()) {
            List<IPAddress> values = item.getValue();
            System.out.printf(
                "| %15s | %15s | %5d     |\n",
                values.get(0),
                values.get(1),
                item.getKey()
            );
        }

        System.out.println("-------------------------------------------------\n");
    }
}

