import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    BufferedReader reader;
    String text = "";

    public void reader(String fileName){

        String lines = "";
        try {

            reader = new BufferedReader(new FileReader(fileName));
            while ((lines = reader.readLine()) != null){
                text += lines+"\n";
            }
            reader.close();
        }catch (IOException e){
            System.out.println("!!reading file gone wrong");
        }
    }


    public String getText() {
        return text;
    }
}
