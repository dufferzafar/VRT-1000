import java.util.*;

public class Table {

    public static class Entry {
        public Integer iface;
        public IPAddress destinationIP;
        public IPAddress nextHop;

        public Entry(String d, String n, Integer i) {
            iface = i;
            destinationIP = new IPAddress(d);
            nextHop = new IPAddress(n);
        }
    }

    HashMap<String, Entry> table;

    public Table() {
        table = new HashMap<String, Entry>();
    }

    public void add(String destinationIP, String nextHop, Integer iface) {
        table.put(destinationIP, new Entry(destinationIP, nextHop, iface));
    }

    public boolean isEmpty() {
        return table.size() == 0;
    }

    public void print() {
        System.out.println("-------------------------------------------------");
        System.out.println("|   Destination   |     Next Hop    | Interface |");
        System.out.println("-------------------------------------------------");

        for (Map.Entry<String, Entry> item : table.entrySet()) {
            Entry e = item.getValue();
            System.out.printf("| %15s | %15s | %5d     |\n", e.destinationIP, e.nextHop, e.iface);
        }

        System.out.println("-------------------------------------------------\n");
    }

    public Entry findDestinationIP(IPAddress ip) {
        if (table.containsKey(ip.toString())) {
            return table.get(ip.toString());
        } else  {
            return new Entry("0.0.0.0", "0.0.0.0", 0);
        }
    }
}

