/*
 * Created by JFormDesigner on Wed Dec 20 00:15:32 AST 2023
 */

package Assignment2;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author drn
 */
public class LoginPage extends JFrame {
    public LoginPage() {
        initComponents();
    }

    private void registerButton(ActionEvent e) {
        // TODO add your code here
        RegisterPage registerPage = new RegisterPage();
        registerPage.getContentPane().setBackground(Color.DARK_GRAY);
        registerPage.setVisible(true);
        registerPage.setTitle("Movies Application 'Register Page' ");
        setVisible(false);
    }

    private void loginButtonEvent(ActionEvent e) {
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());
        boolean login = false;

        if (username.equals("") || password.equals("")){
            JOptionPane.showMessageDialog(null, "Some fields are empty!", "Empty Error", 1);
        }
        else if (username.equals("Admin") && password.equals("Admin")){
            AdminPage adminPage = new AdminPage();
            adminPage.getContentPane().setBackground(Color.DARK_GRAY);
            adminPage.setVisible(true);
            adminPage.setTitle("Movies Application 'Admin Page' ");
            setVisible(false);
        }
        else{
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/APCourseAssignment2", "root", "drn12345");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                while (resultSet.next()){
                    if (username.equals(resultSet.getString(1)) && password.equals(resultSet.getString(2))){
                        UserPage userPage = new UserPage();
                        userPage.getContentPane().setBackground(Color.DARK_GRAY);
                        userPage.setVisible(true);
                        setVisible(false);
                        userPage.setTitle("Movies Application 'Home Page' ");
                        login = true;
                    }
                }
                if (resultSet.next() == false && login == false){
                    JOptionPane.showMessageDialog(null, "No user found!", "Error", 1);
                }

                resultSet.close();
                statement.close();
                connection.close();

            }
            catch (SQLException e1){
                e1.printStackTrace();
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Hassan
        label1 = new JLabel();
        panel1 = new JPanel();
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton();
        button3 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Login Page");
        label1.setIcon(new ImageIcon(getClass().getResource("/Assignment2/userIcon.png")));
        label1.setForeground(new Color(0x00cccc));
        label1.setFont(new Font("Segoe UI", Font.BOLD, 22));
        contentPane.add(label1);
        label1.setBounds(105, 10, 185, 27);

        //======== panel1 ========
        {
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
            . EmptyBorder( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing. border. TitledBorder. CENTER, javax
            . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069al\u006fg" ,java .awt .Font .BOLD ,
            12 ), java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans
            . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062or\u0064er" .equals (e .
            getPropertyName () )) throw new RuntimeException( ); }} );
            panel1.setLayout(new BorderLayout());

            //---- usernameField ----
            usernameField.setBorder(new TitledBorder("Username"));
            panel1.add(usernameField, BorderLayout.NORTH);

            //---- passwordField ----
            passwordField.setBorder(new TitledBorder("Password"));
            panel1.add(passwordField, BorderLayout.SOUTH);
        }
        contentPane.add(panel1);
        panel1.setBounds(35, 55, 320, 130);

        //---- loginButton ----
        loginButton.setText("Login");
        loginButton.setFont(loginButton.getFont().deriveFont(loginButton.getFont().getStyle() | Font.BOLD));
        loginButton.setForeground(new Color(0x00cccc));
        loginButton.addActionListener(e -> loginButtonEvent(e));
        contentPane.add(loginButton);
        loginButton.setBounds(145, 195, 105, 30);

        //---- button3 ----
        button3.setText("Register");
        button3.setFont(button3.getFont().deriveFont(button3.getFont().getStyle() | Font.BOLD));
        button3.setForeground(Color.black);
        button3.addActionListener(e -> registerButton(e));
        contentPane.add(button3);
        button3.setBounds(145, 230, 105, 30);

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
        setSize(400, 300);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Hassan
    private JLabel label1;
    private JPanel panel1;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();
        loginPage.getContentPane().setBackground(Color.DARK_GRAY);
        loginPage.setVisible(true);
        loginPage.setTitle("Movies Application 'Login Page' ");
    }
}