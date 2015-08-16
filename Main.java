public class Main {
    public static void main(String[] args) {
        Router r1 = new Router("R1");
        r1.add("102.0.0.0"     , "145.254.196.234" , 1);
        r1.add("119.0.0.0"     , "145.191.116.97"  , 2);
        r1.add("47.0.0.0"      , "145.18.186.134"  , 3);
        r1.add("184.221.0.0"   , "145.254.106.234" , 4);
        r1.add("201.254.189.0" , "145.254.106.234" , 5);
        r1.printTables();

        Packet pkt = new Packet("169.254.131.248", "119.254.131.248");
        pkt.print();

        r1.receivePacket(pkt);
    }
}
