package parseur;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class ParseurPcap {
     public static void parsePCAP(byte[] byteArray) throws Exception {
        try {
            System.out.println("Parse header: ");
            byte[] header =  Arrays.copyOfRange(byteArray, 0, 24);
            parseur.ParseurHeader.parseHeader(header);

            int packetParser = 23;
            System.out.println(calcValueByte(Arrays.copyOfRange(byteArray, packetParser + 8, packetParser + 12)));
            while(packetParser < byteArray.length) {
                int TimestampS = calcValueByte(Arrays.copyOfRange(byteArray, packetParser, packetParser + 4));
                int TimestampMs = calcValueByte(Arrays.copyOfRange(byteArray, packetParser + 4, packetParser + 8));
                int cPacketLength = calcValueByte(Arrays.copyOfRange(byteArray, packetParser + 8, packetParser + 12));
                int oPacketLenght = calcValueByte(Arrays.copyOfRange(byteArray, packetParser + 12, packetParser + 16));
                byte[] packetData = Arrays.copyOfRange(byteArray, packetParser + 16, packetParser + cPacketLength);

                packetParser += 16 + cPacketLength;
                // System.out.println("TimestampsS: " + TimestampS);
                // System.out.println("TimestampsMs" + TimestampMs);

                System.out.println("cPackentLength: " + cPacketLength);
                System.out.println("Byte array: " + Arrays.toString(Arrays.copyOfRange(byteArray, packetParser + 8, packetParser + 12)));
                System.out.println(("Actuem byte: " + packetParser));
                // System.out.println("oPacketLength" + oPacketLenght);
            }
            // byte[] data = Arrays.copyOfRange(header, 24, byteArray.length);
            // parseur.ParseurData.parseData(data);
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    private static int calcValueByte(byte[] bytes) {
        int value = 0;
        for (byte b : bytes) {
            if (b != 0) {
                value = (value << 8) + (b & 0xFF);
            }
        }

        return value;
    }
}
