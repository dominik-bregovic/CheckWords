import javax.swing.*;

public class FileChoose {
//  File file;
//  Scanner fileIN;
    int response;
    JFileChooser chooser;

    public FileChoose(){
         chooser = new JFileChooser(".");
         chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
         response = chooser.showOpenDialog(null);

    }
}
