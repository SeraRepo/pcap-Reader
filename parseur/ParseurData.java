package parseur;

import java.util.Arrays;
import java.util.HashMap;

public class ParseurData implements Data{
    public static void parseData(byte[] byteArray) throws Exception {
            try {
                HashMap<String, HashMap<String, String>> packets = new HashMap<String, HashMap<String, String>>(); 
                for (int i = 0; i < byteArray.length; i++) {
                    int packetNumber = 0;
                    HashMap<String,String> headerData = new HashMap<String,String>();
            
                    headerData.put("Timestamp s", Arrays.toString(Arrays.copyOfRange(byteArray, 0, 4)));
                    headerData.put("Timestamp ms", Arrays.toString(Arrays.copyOfRange(byteArray, 4, 8)));
                    headerData.put("CPacket Length", Arrays.toString(Arrays.copyOfRange(byteArray, 8, 12)));
                    headerData.put("OPacket Length", Arrays.toString(Arrays.copyOfRange(byteArray, 12, 16)));

                    packets.put("packet " + packetNumber, headerData);
                    packetNumber++;
                }
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        }
}
