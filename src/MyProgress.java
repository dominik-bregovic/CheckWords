import javax.swing.*;

public class MyProgress {

    private JProgressBar bar;
    private JFrame frame;


    public MyProgress(){
        buildBar();
        buildFrame();
    }

    public void buildBar(){
        this.bar = new JProgressBar();
        bar.setValue(0);
        bar.setBounds(0,0,300,30);
        bar.setStringPainted(true);
    }

    public void buildFrame(){
        frame = new JFrame();
        this.frame.add(bar);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(300, 50);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
        this.frame.setLocationRelativeTo(null);

    }

    public void updateProgress(int prog){
            this.bar.setValue(prog);
    }

}
