import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class P2_PrimaryColors extends JFrame {
    //declaration of components needed
    private JLabel jlblColor = new JLabel("COLOR");
    private JButton jbtBlue = new JButton("Blue");
    private JButton jbtRed = new JButton("Red");
    private JButton jbtGreen = new JButton("Green");
    
    public P2_PrimaryColors() {
        jlblColor.setFont(new Font("Cambria", Font.BOLD, 20));
        jlblColor.setHorizontalAlignment(JLabel.CENTER);
        add(jlblColor, BorderLayout.NORTH);
        
        JPanel jpButtons = new JPanel();
        jpButtons.add(jbtRed);
        jpButtons.add(jbtGreen);
        jpButtons.add(jbtBlue);
        add(jpButtons);
        
        //add actionlistener class 
        jbtRed.addActionListener(new RedButtonListener());
        jbtBlue.addActionListener(new BlueButtonListener());
        jbtGreen.addActionListener(new GreenButtonListener());
        
        setTitle("Primary Colors");
        setSize(300, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    //multiple inner class
    //create an inner class for redbutton
    private class RedButtonListener implements ActionListener{ //interface 

        @Override
        public void actionPerformed(ActionEvent e) {
            jlblColor.setForeground(Color.RED);
        }
    }
    
    private class GreenButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            jlblColor.setForeground(Color.GREEN);
        }
    }
    
    private class BlueButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            jlblColor.setForeground(Color.BLUE);
        }
    }
    
    public static void main(String[] args) {
        new P2_PrimaryColors();
    }
}