import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextAnalysis {

    BufferedReader reader;
    String copiedText = "";
    String wordsOnly  = "";
    List<String> listOfWords = new ArrayList();

    public void reader(String fileName){

        String lines = "";
        try {

            this.reader = new BufferedReader(new FileReader(fileName));
            while ((lines = reader.readLine()) != null){
                this.copiedText += lines+"\n";
                this.wordsOnly += lines + " ";
            }
            this.reader.close();
        }catch (IOException e){
            System.out.println("!!reading file gone wrong");
        }
    }


    public void listWords(){
        String oneWord = "";

        for (int i = 0; i < wordsOnly.length(); i++) {

            if(wordsOnly.charAt(i) != ' ' && wordsOnly.charAt(i) != '.' && wordsOnly.charAt(i) != '!' &&wordsOnly.charAt(i) != '?'){

                oneWord += wordsOnly.charAt(i);

            } else{
                listOfWords.add(oneWord);
                String reseter = "";
                oneWord = reseter;
            }
        }

        for (int i = 0; i < listOfWords.size(); i++) {
            System.out.println(listOfWords.get(i));
        }
    }


    public String getText() {
        return copiedText;
    }

}
