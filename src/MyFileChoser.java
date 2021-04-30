import javax.swing.*;
import java.io.File;

public class MyFileChoser {

    private TextAnalysis readFile = new TextAnalysis();
    private JFileChooser chooser;
    private File file;
    private int response;
    private MyProgress myProgress;

    public MyFileChoser(MyProgress progress){
        this.myProgress = progress;
        progressHandling(25);
        defineJFileChosser();
        gettingTextFilePath();
        progressHandling(50);
        readChosenDoc();
        progressHandling(75);
        builtTable();
        progressHandling(100);

    }

    public void defineJFileChosser(){
        this.chooser = new JFileChooser(".");
        this.chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        this.chooser.setDialogTitle("Choose your \"file.txt\" ");
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

    public void builtTable(){
        readFile.listWords();
        readFile.wordCounter();
        readFile.printTable();
    }

    public void progressHandling(int p){
        myProgress.updateProgress(p);
        try {
            Thread.sleep(500);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
