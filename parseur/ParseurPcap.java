package parseur;

import java.util.Arrays;

public class ParseurPcap {
     public static void parsePCAP(byte[] byteArray) throws Exception {
        try {
            byte[] header =  Arrays.copyOfRange(byteArray, 0, 24);
            parseur.ParseurHeader.parseHeader(header);
            byte[] data = Arrays.copyOfRange(header, 24, byteArray.length);
            parseur.ParseurData.parseData(data);
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
