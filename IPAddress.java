public class IPAddress {
    private String address;

    public enum Class { A, B, C, Invalid };

    public IPAddress(String input) {
        address = input;
    }

    public String toString() {
        return address;
    }

    public String toBinaryString() {
        String rv = "";
        for(String block: address.split("\\.")) {
            rv += Integer.toBinaryString(Integer.parseInt(block));
        }
        return rv;
    }

    public Class getIPClass() {
        int first_block = Integer.parseInt(address.split("\\.")[0]);

        if(first_block >= 0 && first_block <= 127) {
            return Class.A;
        } else if(first_block > 127 && first_block <= 191) {
            return Class.B;
        } else if(first_block > 191 && first_block <= 223) {
            return Class.C;
        } else {
            return Class.Invalid;
        }
    }
}
