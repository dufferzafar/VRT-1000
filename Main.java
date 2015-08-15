public class Main {
    public static void main(String[] args) {
        Table tbl = new Table();

        tbl.add("102.254.131.248" , "145.254.106.234" , 1);
        tbl.add("119.254.131.248" , "145.254.106.234" , 2);
        tbl.add("119.254.131.248" , "145.254.106.234" , 5);
        tbl.add("47.254.131.248"  , "145.254.106.234" , 3);
        tbl.print();

        System.out.println("\n");

        Packet pkt = new Packet("169.254.131.248", "137.254.131.248");
        pkt.print();
    }
}
