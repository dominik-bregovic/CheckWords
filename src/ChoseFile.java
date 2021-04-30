import javax.swing.*;
import java.io.File;

public class ChoseFile {

    private TextAnalysis readFile = new TextAnalysis();
    private JFileChooser chooser;
    private File file;
    private int response;

    public ChoseFile(){
        defineJFileChosser();
        gettingTextFilePath();
        readChosenDoc();
        buildTable();

    }

    public void defineJFileChosser(){
        this.chooser = new JFileChooser(".");
        this.chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        this.chooser.setDialogTitle("Choose your textfile: ");
        this.response = this.chooser.showOpenDialog(null); // if you have choosen a txt. file the 0, otherwise 1

    }

    public void gettingTextFilePath(){

        if (this.response == JFileChooser.APPROVE_OPTION){
            this.file = new File(this.chooser.getSelectedFile().getAbsolutePath()); // here we are getting the choosen docs path over out gui
        }
    }

    public void readChosenDoc(){
        this.readFile.reader(this.file.toString());
    }

    public void buildTable(){
        readFile.listWords();
        readFile.wordCounter();

    }


}
