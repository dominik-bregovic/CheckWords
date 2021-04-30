import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Write {

    String text = "";

    public void writeString(){
        try{

            FileWriter fw = new FileWriter("firstText.txt");
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(text);
//            System.out.println("Should have written text");
            writer.close();
        }catch(IOException e){
            System.out.println("!!No content written into file!!");
        }



    }

}
