public class Main {
    public static void main(String[] args) {
        Router r1 = new Router("R1");
        r1.add("102.254.131.248" , "145.254.106.234" , 1);
        r1.add("119.254.131.248" , "145.254.106.234" , 2);
        r1.add("119.254.131.248" , "145.254.106.234" , 5);
        r1.add("47.254.131.248"  , "145.254.106.234" , 3);
        r1.add("147.254.131.248"  , "145.254.106.234" , 3);
        r1.add("201.254.131.248"  , "145.254.106.234" , 3);
        r1.printTables();

        System.out.println("\n");

        Packet pkt = new Packet("169.254.131.248", "137.254.131.248");
        pkt.print();
    }
}
