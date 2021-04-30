import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartProgram implements ActionListener {

    private JFrame jFrame;
    private JPanel jPanel;
    private JButton jButton;
    private MyFileChoser fileChoose;
    private MyProgress progress;

    public StartProgram(){
        buildButton();
        buildJpanel();
        buildJFrame();

    }

    public void buildButton(){
        this.jButton = new JButton("Search for file");
        this.jButton.addActionListener(this);
    }

    public void buildJpanel(){
        this.jPanel = new JPanel();
        this.jPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        this.jPanel.setLayout(new GridLayout(2,1));
        this.jPanel.add(jButton);
    }

    public void buildJFrame(){
        this.jFrame = new JFrame();
        this.jFrame.add(jPanel, BorderLayout.CENTER);
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jFrame.setTitle("Our Reader");
        this.jFrame.pack();
        this.jFrame.setLocationRelativeTo(null);
        this.jFrame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        this.progress = new MyProgress();
        this.fileChoose = new MyFileChoser(progress);
    }

}
