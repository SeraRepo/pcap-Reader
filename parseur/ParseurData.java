package parseur;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;

public class ParseurData implements Data{
    public static void parseData(byte[] byteArray) throws Exception {
        try {
            HashMap<String, HashMap<String, String>> packets = new HashMap<String, HashMap<String, String>>();
            System.out.println(byteArray.length); 
            for (int i = 0; i < byteArray.length; i++) {
                int packetNumber = 0;
                System.out.println(packetNumber);
                HashMap<String,String> headerData = new HashMap<String,String>();
        
                headerData.put("Timestamp s", Arrays.toString(Arrays.copyOfRange(byteArray, 0, 4)));
                headerData.put("Timestamp ms", Arrays.toString(Arrays.copyOfRange(byteArray, 4, 8)));
                headerData.put("CPacket Length", Arrays.toString(Arrays.copyOfRange(byteArray, 8, 12)));
                headerData.put("OPacket Length", Arrays.toString(Arrays.copyOfRange(byteArray, 12, 16)));
                
                int packetLenght = ByteBuffer.wrap(Arrays.copyOfRange(byteArray, 8, 12)).getInt();

                packets.put("packet " + packetNumber, headerData);
                packetNumber += packetLenght + 16;
                // System.out.println(headerData);
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
