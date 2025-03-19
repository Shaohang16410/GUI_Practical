

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class P2_StudentList {
    private ArrayList<String> studentList = new ArrayList<String>();
    private JButton btnCreate = new JButton("Create");
    private JButton btnGet = new JButton("Retrieve");
    private JButton btnUpdate = new JButton("Update");
    private JButton btnDelete = new JButton("Delete");
    private int currentArray = 0;

    class CreateStudent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            String studName = JOptionPane.showInputDialog(null, "Enter new student name: ");
            if (studName != ""){
            studentList.add(studName);
            JOptionPane.showMessageDialog(null, "Student " + studName + " added.");
            currentArray = studentList.size() - 1;
            
            RetrieveStudent retrieveStudent = new RetrieveStudent();
            retrieveStudent.actionPerformed(e);
            }
        }
    }

    class RetrieveStudent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String studentListText = "";
            for (int i = 0; i < studentList.size(); i++) {
                studentListText += i+1 + ". " + studentList.get(i) + "\n";
            }
            
            JOptionPane.showMessageDialog(null, "Student List: \n" + studentListText);
        }
    }

    class UpdateStudent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            var studentName = studentList.get(currentArray);
            String newStudentName = JOptionPane.showInputDialog(null,"Current student name is " + studentName + ". Enter new name: ");
            if (newStudentName != ""){
                studentList.set(currentArray, newStudentName);
                JOptionPane.showMessageDialog(null, "Student " + studentName + " updated to " + newStudentName);
                RetrieveStudent retrieveStudent = new RetrieveStudent();
                retrieveStudent.actionPerformed(e);
            }
        }
    }

    class DeleteStudent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            var studentName = studentList.get(currentArray);
            studentList.remove(currentArray);
            JOptionPane.showMessageDialog(null, "Student " + studentName + " deleted.");
            RetrieveStudent retrieveStudent = new RetrieveStudent();
            retrieveStudent.actionPerformed(e);
        }
    }



    public P2_StudentList() {
        JFrame frame = new JFrame("CRUD Array");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(btnCreate);
        panel.add(btnGet);
        panel.add(btnUpdate);
        panel.add(btnDelete);
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        P2_StudentList frame = new P2_StudentList();
        frame.btnCreate.addActionListener(frame.new CreateStudent());
        frame.btnGet.addActionListener(frame.new RetrieveStudent());
        frame.btnUpdate.addActionListener(frame.new UpdateStudent());
        frame.btnDelete.addActionListener(frame.new DeleteStudent());

    }

    
}

                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    