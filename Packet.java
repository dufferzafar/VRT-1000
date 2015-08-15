import java.net.InetAddress;
import java.net.UnknownHostException;

public class Packet {
    private int version, headerLength, differentiatedServices, totalLength;
    private int identification, fragmentation; // offset;
    private int ttl, protocol, checksum;

    private InetAddress sourceIP;
    private InetAddress destinationIP;

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

        try {
            sourceIP = InetAddress.getByName(src);
            destinationIP = InetAddress.getByName(dest);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public String getSourceIP() {
        return sourceIP.getHostAddress();
    }

    public String getDestinationIP() {
        return destinationIP.getHostAddress();
    }

    private String padInt(int property, int size) {
        String str = Integer.toBinaryString(property);
        while(str.length() < size) {
            str = "0" + str;
        }
        return str;
    }

    private String toBinaryString(InetAddress ip) {
        String rv = "";
        for(String block: ip.getHostAddress().split("\\.")) {
            rv += Integer.toBinaryString(Integer.parseInt(block));
        }
        return rv;
    }

    private String padIP(InetAddress ip) {
        String temp = toBinaryString(ip);
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
        System.out.println("Packet source      : " + sourceIP.getHostAddress());
        System.out.println("Packet destination : " + destinationIP.getHostAddress());
        System.out.println("Binary Contents    : " + byteString);
    }
}
