import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws Exception {

        try{
                Path path = Paths.get(args[0]);
                byte[] arr = Files.readAllBytes(path);
                parseur.ParseurPcap.parsePCAP(arr);
        }catch(Exception e){
            System.out.println("Error "+ e.getMessage());
        }
    }
}  