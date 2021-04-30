import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextAnalysis {

    private BufferedReader reader;
    private String copiedText = "";
    private String wordsOnly  = "";
    private String oneWord = "";
    private List<Character> specialCharacters = new ArrayList<>();
    private List<String> listOfWords = new ArrayList();
    private Set<String> uniqueWords = new HashSet<>();
    private List<String> uniqueList;

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
        notValidChars();
        boolean validChar;

        for (int i = 0; i < wordsOnly.length(); i++) {

              validChar = verifyChars(true, i);

            if (validChar == true){

                buildWord(i);
            }else {

                saveWord();
            }
        }
        cleanList();
        sortingListToUniqueElements();
    }

    public boolean verifyChars(boolean validChar, int i){

        for (Character specialCharacter : specialCharacters) {
            if (wordsOnly.charAt(i) == specialCharacter) {
                validChar = false;
                break;
            }
        }
        return validChar;
    }

    public void saveWord(){

            listOfWords.add(oneWord);
            String reseter = "";
            oneWord = reseter;
    }

    public void buildWord( int i){
        oneWord += wordsOnly.charAt(i);
    }

    public void notValidChars(){
        specialCharacters.add(' ');
        specialCharacters.add('.');
        specialCharacters.add('!');
        specialCharacters.add('?');
    }

    public void cleanList(){

        for (int i = 0; i < listOfWords.size(); i++) {
            if (listOfWords.get(i).equals("")){
                listOfWords.remove(i);
            }
        }
    }

    public void sortingListToUniqueElements(){
        uniqueWords.addAll(listOfWords);
        uniqueList = new ArrayList<>(uniqueWords);
    }

    public void wordCounter(){
        int count = 0;

        for (int i = 0; i < uniqueList.size(); i++) {
            count = Collections.frequency(listOfWords, uniqueList.get(i));
            uniqueList.set(i, uniqueList.get(i) + ": " + count);
        }
        System.out.println(uniqueList);
    }

    public String getText() {
        return copiedText;
    }

}
