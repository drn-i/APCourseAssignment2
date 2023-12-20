/*
 * Created by JFormDesigner on Tue Dec 19 22:34:26 AST 2023
 */

package Assignment2;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author hassa
 */
public class AdminPage extends JFrame {
    public AdminPage() {
        initComponents();
    }

    private void importButton(ActionEvent e) {
        //Import button Event
    }

    private void ImportButton(ActionEvent e) {
        // TODO add your code here
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/APCourseAssignment2", "root", "drn12345");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()){
                usersDetails.append(resultSet.getRow() + "- Username: " + resultSet.getString(1) + " - Password: " + resultSet.getString(2) + "\n");

            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (SQLException e3){
            e3.printStackTrace();
        }

    }

    private void LogoutButton(ActionEvent e) {
        // TODO add your code here
        LoginPage loginPage = new LoginPage();
        loginPage.getContentPane().setBackground(Color.DARK_GRAY);
        loginPage.setVisible(true);
        loginPage.setTitle("Movies Application 'Login Page' ");
        setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Hassan
        label1 = new JLabel();
        label2 = new JLabel();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        usersDetails = new JTextArea();
        loginButton = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Admin Page");
        label1.setIcon(new ImageIcon(getClass().getResource("/Assignment2/userIcon.png")));
        label1.setForeground(new Color(0x00cccc));
        label1.setFont(new Font("Segoe UI", Font.BOLD, 22));
        contentPane.add(label1);
        label1.setBounds(20, 15, 205, 30);

        //---- label2 ----
        label2.setText("Users Details");
        label2.setIcon(null);
        label2.setForeground(Color.white);
        label2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        contentPane.add(label2);
        label2.setBounds(25, 75, 160, 30);

        //---- button1 ----
        button1.setText("Import");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getStyle() | Font.BOLD));
        button1.addActionListener(e -> {
			importButton(e);
			ImportButton(e);
		});
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(140, 75), button1.getPreferredSize()));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(usersDetails);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(20, 115, 570, 280);

        //---- loginButton ----
        loginButton.setText("Logout");
        loginButton.setFont(loginButton.getFont().deriveFont(loginButton.getFont().getStyle() | Font.BOLD));
        loginButton.setForeground(new Color(0x00cccc));
        loginButton.addActionListener(e -> LogoutButton(e));
        contentPane.add(loginButton);
        loginButton.setBounds(490, 15, 105, loginButton.getPreferredSize().height);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        setSize(610, 445);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Hassan
    private JLabel label1;
    private JLabel label2;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTextArea usersDetails;
    private JButton loginButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String[] args) {
        AdminPage adminPage = new AdminPage();
        adminPage.setVisible(true);
    }

}
