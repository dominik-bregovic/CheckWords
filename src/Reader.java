import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {




    public String reader(String fileName){

        try {

            FileReader read = new FileReader(fileName);
            BufferedReader reading = new BufferedReader(read);
            String content;
            while ((content = reading.readLine()) != null){
                return content;
            }
            reading.close();
        }catch (IOException e){
            System.out.println("!!reading file gone wrong");
        }
        return "";

    }
}
