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

        jFrame = new JFrame();
        jButton = new JButton("Search for file");
        jButton.addActionListener(this);

//        jLabel = new JLabel();

        jPanel = new JPanel();
        jPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        jPanel.setLayout(new GridLayout(1,1));
        jPanel.add(jButton);
//        jPanel.add(jLabel);


        jFrame.add(jPanel, BorderLayout.CENTER);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("Our Reader");
        jFrame.pack();
        jFrame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        fileChoose = new ChoseFile();
    }

}
