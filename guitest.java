import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class TouristApp extends JFrame implements ActionListener {
    // GUI Components
    private JTextField txtTouristId, txtDocument, txtName, txtGender, txtCountry;
    private JButton btnAdd, btnFind, btnUpdate, btnDelete;
    private JLabel lblResult;

    // Database connection
    private Connection conn;

    public TouristApp() {
        // Initialize database connection
        connectToDatabase();

        // Set up the GUI
        setTitle("Tourist Management System");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        // Add components
        add(new JLabel("Tourist ID:"));
        txtTouristId = new JTextField();
        add(txtTouristId);

        add(new JLabel("Document:"));
        txtDocument = new JTextField();
        add(txtDocument);

        add(new JLabel("Name:"));
        txtName = new JTextField();
        add(txtName);

        add(new JLabel("Gender (1=Male, 2=Female):"));
        txtGender = new JTextField();
        add(txtGender);

        add(new JLabel("Country:"));
        txtCountry = new JTextField();
        add(txtCountry);

        btnAdd = new JButton("Add Tourist");
        btnAdd.addActionListener(this);
        add(btnAdd);

        btnFind = new JButton("Find Tourist");
        btnFind.addActionListener(this);
        add(btnFind);

        btnUpdate = new JButton("Update Tourist");
        btnUpdate.addActionListener(this);
        add(btnUpdate);

        btnDelete = new JButton("Delete Tourist");
        btnDelete.addActionListener(this);
        add(btnDelete);

        lblResult = new JLabel("");
        add(lblResult);

        setVisible(true);
    }

    private void connectToDatabase() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TouristDB", "root", "password");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to connect to database: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            addTourist();
        } else if (e.getSource() == btnFind) {
            findTourist();
        } else if (e.getSource() == btnUpdate) {
            updateTourist();
        } else if (e.getSource() == btnDelete) {
            deleteTourist();
        }
    }

    private void addTourist() {
        try {
            String touristId = txtTouristId.getText();
            String document = txtDocument.getText();
            String name = txtName.getText();
            int gender = Integer.parseInt(txtGender.getText());
            String country = txtCountry.getText();

            // Validate gender
            if (gender != 1 && gender != 2) {
                throw new invalidGenderException("Invalid gender. Only 1 (Male) or 2 (Female) are allowed.");
            }

            // Insert into database
            String sql = "INSERT INTO Tourist (Tourist_Id, Tourist_Document, Tourist_Name, Tourist_Gender, Tourist_Country) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, touristId);
            pstmt.setString(2, document);
            pstmt.setString(3, name);
            pstmt.setInt(4, gender);
            pstmt.setString(5, country);
            pstmt.executeUpdate();

            lblResult.setText("Tourist added successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Gender must be an integer.");
        } catch (invalidGenderException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed to add tourist: " + ex.getMessage());
        }
    }

    private void findTourist() {
        try {
            String touristId = txtTouristId.getText();

            // Query database
            String sql = "SELECT * FROM Tourist WHERE Tourist_Id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, touristId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                txtDocument.setText(rs.getString("Tourist_Document"));
                txtName.setText(rs.getString("Tourist_Name"));
                txtGender.setText(String.valueOf(rs.getInt("Tourist_Gender")));
                txtCountry.setText(rs.getString("Tourist_Country"));
                lblResult.setText("Tourist found!");
            } else {
                lblResult.setText("No such tourist ID.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed to find tourist: " + ex.getMessage());
        }
    }

    private void updateTourist() {
        try {
            String touristId = txtTouristId.getText();
            String document = txtDocument.getText();
            String name = txtName.getText();
            int gender = Integer.parseInt(txtGender.getText());
            String country = txtCountry.getText();

            // Validate gender
            if (gender != 1 && gender != 2) {
                throw new invalidGenderException("Invalid gender. Only 1 (Male) or 2 (Female) are allowed.");
            }

            // Update database
            String sql = "UPDATE Tourist SET Tourist_Document = ?, Tourist_Name = ?, Tourist_Gender = ?, Tourist_Country = ? WHERE Tourist_Id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, document);
            pstmt.setString(2, name);
            pstmt.setInt(3, gender);
            pstmt.setString(4, country);
            pstmt.setString(5, touristId);
            pstmt.executeUpdate();

            lblResult.setText("Tourist updated successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Gender must be an integer.");
        } catch (invalidGenderException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed to update tourist: " + ex.getMessage());
        }
    }

    private void deleteTourist() {
        try {
            String touristId = txtTouristId.getText();

            // Confirm deletion
            int confirm = JOptionPane.showConfirmDialog(null, "Delete Tourist Record " + touristId + "?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Delete from database
                String sql = "DELETE FROM Tourist WHERE Tourist_Id = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, touristId);
                pstmt.executeUpdate();

                lblResult.setText("Tourist deleted successfully!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Failed to delete tourist: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new TouristApp();
    }
}