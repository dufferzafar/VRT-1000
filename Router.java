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
}
