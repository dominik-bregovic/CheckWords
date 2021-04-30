import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextAnalysis {

    private BufferedReader reader;
    private String copiedInputText = "";
    private String wordsOnly  = "";
    private String oneWord = "";
    private List<Character> specialCharacters = new ArrayList<>();
    private List<String> listOfWords = new ArrayList();
    private Set<String> uniqueWords = new HashSet<>();
    private List<String> uniqueList;
    private List<String> analyzedList = new ArrayList<>();


    public void reader(String fileName){

        String lines = "";
        try {

            this.reader = new BufferedReader(new FileReader(fileName));
            while ((lines = reader.readLine()) != null){
                this.copiedInputText += lines+"\n";
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

            if (validChar){

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

            //Resetting oneWord to empty
            oneWord = "";
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
        Collections.sort(uniqueList);
    }

    public void wordCounter(){
        Integer count = 0;

        for (String s : uniqueList) {
            count = Collections.frequency(listOfWords, s);
            analyzedList.add(s);
            analyzedList.add(String.valueOf(count));
        }
    }

    //Output like in example, but when word over 16 characters then the output is shifted to the right
    public void printTable() {
        String space = " ";

        System.out.println("Wort            " + "Anzahl");
        for (int i = 0; i < analyzedList.size(); i += 2) {
            int spaces = 16;
            int wordLength = analyzedList.get(i).length();
            spaces = spaces-wordLength;

            System.out.print(analyzedList.get(i));
            for (int j = 0; j < spaces; j++) {
                System.out.print(space);
            }
            System.out.println(analyzedList.get(i+1));

        }
    }

}
