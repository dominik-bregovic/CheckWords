import javax.swing.*;
import java.io.File;

public class ChoseFile {

    private Reader readFile;
    private JFileChooser chooser;
    private File file;
    private int response;

    public ChoseFile(){
         chooser = new JFileChooser(".");
         chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
         chooser.setDialogTitle("Choose your textfile: ");
         response = chooser.showOpenDialog(null); // if you have choosen a txt. file the 0, otherwise 1

        gettingTextFilePath();
        readChosenDoc();
    }

    public void gettingTextFilePath(){

        if (this.response == JFileChooser.APPROVE_OPTION){
            this.file = new File(this.chooser.getSelectedFile().getAbsolutePath()); // here we are getting the choosen docs path over out gui
        }
    }

    public void readChosenDoc(){
        this.readFile = new Reader();
        readFile.reader(file.toString());
        System.out.println(readFile.getText());
    }


}
