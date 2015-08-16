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

    // Note: I am not sure if this is technically called a net address
    // but for IP Address   : 112.245.182.222
    // return value will be : 112.0.0.0
    // since it is a class A address
    public IPAddress getNetAddress() {
        switch (getIPClass()) {
            case A: return new IPAddress(String.format("%s.0.0.0", address.substring(0,3)));
            case B: return new IPAddress(String.format("%s.0.0"  , address.substring(0,7)));
            case C: return new IPAddress(String.format("%s.0"    , address.substring(0,15)));
        }
        return new IPAddress("0.0.0.0");
    }
}
