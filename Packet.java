public class Packet {
    private int version, headerLength, differentiatedServices, totalLength;
    private int identification, fragmentation; // offset;
    private int ttl, protocol, checksum;

    private IPAddress sourceIP;
    private IPAddress destinationIP;

    public Packet(String src, String dest) {
        version = 4;
        headerLength = 5;
        differentiatedServices = 0;
        totalLength = 54;
        identification = 3;
        fragmentation = 5850;
        ttl = 20;
        protocol = 6;
        checksum = 0;

        sourceIP = new IPAddress(src);
        destinationIP = new IPAddress(dest);
    }

    public IPAddress getSourceIP() {
        return sourceIP;
    }

    public IPAddress getDestinationIP() {
        return destinationIP;
    }

    public IPAddress.Class getIPClass() {
        return destinationIP.getIPClass();
    }

    private String padInt(int property, int size) {
        String str = Integer.toBinaryString(property);
        while(str.length() < size) {
            str = "0" + str;
        }
        return str;
    }

    private String padIP(IPAddress ip) {
        String temp = ip.toBinaryString();
        if(temp.length() < 32) {
            while(temp.length() < 32) {
                temp = "0" + temp;
            }
        }
        return temp;
    }

    public void print() {
        String byteString = "";
        byteString += padInt(version, 4)                + " ";
        byteString += padInt(headerLength, 4)           + " ";
        byteString += padInt(differentiatedServices, 8) + " ";
        byteString += padInt(totalLength, 16)           + " ";
        byteString += padInt(identification, 16)        + " ";
        byteString += padInt(fragmentation, 16)         + " ";
        byteString += padInt(ttl, 8)                    + " ";
        byteString += padInt(protocol, 8)               + " ";
        byteString += padInt(checksum, 16)              + " ";
        byteString += padIP(sourceIP)                   + " ";
        byteString += padIP(destinationIP);

        System.out.println("Packet: ");
        System.out.println("-------\n");
        System.out.println("Packet source      : " + sourceIP);
        System.out.println("Packet destination : " + destinationIP);
        System.out.println("Binary Contents    : " + byteString);
        System.out.println("");
    }
}
