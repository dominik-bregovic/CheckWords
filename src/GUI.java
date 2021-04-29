import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    JFrame jFrame;
    JLabel jLabel;
    JPanel jPanel;
    int count = 0;

    public GUI(){

        jFrame = new JFrame();
        JButton button = new JButton("read file");
        button.addActionListener(this);

        jLabel = new JLabel("Number of clicks " + count);

        jPanel = new JPanel();
        jPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        jPanel.setLayout(new GridLayout(0,1));
        jPanel.add(button);
        jPanel.add(jLabel);


        jFrame.add(jPanel, BorderLayout.CENTER);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("Our Reader");
        jFrame.pack();
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FileChoose fileChoose = new FileChoose();


    }
}
