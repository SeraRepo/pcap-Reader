package parseur;

import java.util.Arrays;
import java.util.HashMap;

public class ParseurHeader {
    public static void parseHeader(byte[] byteArray) throws Exception {
        try {
            HashMap<String,String> headerData = new HashMap<String,String>();
            
            headerData.put("Magic Number", Arrays.toString(Arrays.copyOfRange(byteArray, 0, 4)));
            headerData.put("Major Version", Arrays.toString(Arrays.copyOfRange(byteArray, 4, 6)));
            headerData.put("Minor Version", Arrays.toString(Arrays.copyOfRange(byteArray, 6, 8)));
            headerData.put("Reserved1", Arrays.toString(Arrays.copyOfRange(byteArray, 8, 12)));
            headerData.put("Reserved2", Arrays.toString(Arrays.copyOfRange(byteArray, 12, 16)));
            headerData.put("SnapLen", Arrays.toString(Arrays.copyOfRange(byteArray, 16, 20)));
            headerData.put("FCS", Arrays.toString(Arrays.copyOfRange(byteArray, 20, 21)));
            headerData.put("LinkType", Arrays.toString(Arrays.copyOfRange(byteArray, 21, 24)));
            
            System.out.println(headerData);
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
