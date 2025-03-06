import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class P2_DetectSourceFrame extends JFrame {

    private JLabel jlblColor = new JLabel("COLOR");
    private JButton jbtBlue = new JButton("Blue");
    private JButton jbtRed = new JButton("Red");
    private JButton jbtGreen = new JButton("Green");

    public P2_DetectSourceFrame() {
        jlblColor.setFont(new Font("Cambria", Font.BOLD, 20));
        jlblColor.setHorizontalAlignment(JLabel.CENTER);
        add(jlblColor, BorderLayout.NORTH);

        JPanel jpButtons = new JPanel();
        jpButtons.add(jbtRed);
        jpButtons.add(jbtGreen);
        jpButtons.add(jbtBlue);
        add(jpButtons);
        
        ButtonListener listener = new ButtonListener();

        jbtRed.addActionListener(listener);
        jbtBlue.addActionListener(listener);
        jbtGreen.addActionListener(listener);

        setTitle("Primary Colors");
        setSize(300, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jbtRed) 
                jlblColor.setForeground(Color.RED);
            else if (e.getSource() == jbtBlue)
                jlblColor.setForeground(Color.BLUE);
            else if (e.getSource() == jbtGreen)
                jlblColor.setForeground(Color.GREEN);
        }
    }

    public static void main(String[] args) {
        new P2_DetectSourceFrame();
    }
}