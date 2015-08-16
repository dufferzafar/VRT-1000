public class Router {
    private String name;

    // Classful Addressing requires 3 different
    // tables for three classes.
    private Table tableA;
    private Table tableB;
    private Table tableC;

    public Router(String str) {
        tableA = new Table();
        tableB = new Table();
        tableC = new Table();
        name = str;
    }

    public void printTables() {
        System.out.println("Routing table(s) for router: " + name);
        System.out.println("-------------------------------\n");

        if (!tableA.isEmpty()) {
            tableA.print();
        }

        if (!tableB.isEmpty()) {
            tableB.print();
        }

        if (!tableC.isEmpty()) {
            tableC.print();
        }
    }

    public void add(String destinationIP, String nextHop, Integer iface) {
        switch (new IPAddress(destinationIP).getIPClass()) {
            case A: tableA.add(destinationIP, nextHop, iface); break;
            case B: tableB.add(destinationIP, nextHop, iface); break;
            case C: tableC.add(destinationIP, nextHop, iface); break;
        }
    }

    public void receivePacket(Packet packet) {
        System.out.println("Recieving Packet: ");
        System.out.println("-----------------\n");

        Table table = new Table();
        switch (packet.getIPClass()) {
            case A: table = tableA; break;
            case B: table = tableB; break;
            case C: table = tableC; break;
            case Invalid: System.out.println("Packet Discarded!"); return;
        }

        Table.Entry entry = table.findDestinationIP(packet.getDestinationIP().getNetAddress());
        if (entry.iface == 0) {
            System.out.println("Network IP not found. Route to default IP.");
        } else {
            System.out.printf("Route packet to: %s through interface: %d", entry.nextHop, entry.iface);
        }
    }
}
