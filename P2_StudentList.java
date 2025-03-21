import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class StudentListFrame extends JFrame {
    private ArrayList<String> studentList = new ArrayList<>();
    
    public StudentListFrame() {
        setLayout(new FlowLayout());

        JButton createButton = new JButton("Create");
        JButton retrieveButton = new JButton("Retrieve");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        createButton.addActionListener(new CreateListener());
        retrieveButton.addActionListener(new RetrieveListener());
        updateButton.addActionListener(new UpdateListener());
        deleteButton.addActionListener(new DeleteListener());

        add(createButton);
        add(retrieveButton);
        add(updateButton);
        add(deleteButton);

        setTitle("Maintain Students");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class CreateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = JOptionPane.showInputDialog("Enter student name:");
            if (name != null && !name.isEmpty()) {
                studentList.add(name);
                JOptionPane.showMessageDialog(null, "Student added: " + name);
            }
        }
    }

    private class RetrieveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (studentList.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No students found.");
            } else {
                JOptionPane.showMessageDialog(null, "Students:\n" + String.join("\n", studentList));
            }
        }
    }

    private class UpdateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String oldName = JOptionPane.showInputDialog("Enter student name to update:");
            if (studentList.contains(oldName)) {
                String newName = JOptionPane.showInputDialog("Enter new name:");
                studentList.set(studentList.indexOf(oldName), newName);
                JOptionPane.showMessageDialog(null, "Updated to: " + newName);
            } else {
                JOptionPane.showMessageDialog(null, "Student not found.");
            }
        }
    }

    private class DeleteListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = JOptionPane.showInputDialog("Enter student name to delete:");
            if (studentList.remove(name)) {
                JOptionPane.showMessageDialog(null, "Student deleted: " + name);
            } else {
                JOptionPane.showMessageDialog(null, "Student not found.");
            }
        }
    }

    public static void main(String[] args) {
        new StudentListFrame();
    }
}

             
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
