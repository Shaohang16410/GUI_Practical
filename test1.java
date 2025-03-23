import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StudentInfo extends JFrame {
    private JTextField idField, nameField, ageField;

    public StudentInfo() {
        setTitle("Student Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the main panel
        JPanel mainPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add components to the main panel
        mainPanel.add(new JLabel("Student ID:"));
        idField = new JTextField();
        mainPanel.add(idField);

        mainPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        mainPanel.add(nameField);

        mainPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        mainPanel.add(ageField);

        // Create button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton createButton = new JButton("Create");
        JButton searchButton = new JButton("Search");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        buttonPanel.add(createButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        // Add action listeners with try-catch blocks
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = idField.getText();
                    String name = nameField.getText();
                    String ageText = ageField.getText();

                    // Parse age (this will throw an exception if age is not a number)
                    int age = Integer.parseInt(ageText);

                    // Display success message
                    JOptionPane.showMessageDialog(null, "Student created successfully!\nID: " + id + "\nName: " + name + "\nAge: " + age);

                    // Clear fields after creation
                    idField.setText("");
                    nameField.setText("");
                    ageField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid age! Please enter a valid number for age.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage());
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = idField.getText();

                    // Display search message
                    JOptionPane.showMessageDialog(null, "Searching for student with ID: " + id);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage());
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = idField.getText();
                    String name = nameField.getText();
                    String ageText = ageField.getText();

                    // Parse age (this will throw an exception if age is not a number)
                    int age = Integer.parseInt(ageText);

                    // Display success message
                    JOptionPane.showMessageDialog(null, "Student updated successfully!\nID: " + id + "\nName: " + name + "\nAge: " + age);

                    // Clear fields after update
                    idField.setText("");
                    nameField.setText("");
                    ageField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid age! Please enter a valid number for age.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage());
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = idField.getText();

                    // Display delete message
                    JOptionPane.showMessageDialog(null, "Student with ID: " + id + " deleted successfully!");

                    // Clear fields after deletion
                    idField.setText("");
                    nameField.setText("");
                    ageField.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage());
                }
            }
        });

        // Add panels to the frame
        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set frame properties
        pack();
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentInfo();
    }
}
