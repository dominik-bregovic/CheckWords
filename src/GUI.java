import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private JFrame jFrame;
    private JPanel jPanel;
    private JButton jButton;
    private ChoseFile fileChoose;

    public GUI(){

        this.jFrame = new JFrame();
        this.jButton = new JButton("Search for file");
        this.jButton.addActionListener(this);

//        jLabel = new JLabel();

        this.jPanel = new JPanel();
        this.jPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        this.jPanel.setLayout(new GridLayout(1,1));
        this.jPanel.add(jButton);
//        jPanel.add(jLabel);


        this.jFrame.add(jPanel, BorderLayout.CENTER);
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jFrame.setTitle("Our Reader");
        this.jFrame.pack();
        this.jFrame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        this.fileChoose = new ChoseFile();
    }

}
