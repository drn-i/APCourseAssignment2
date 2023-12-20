/*
 * Created by JFormDesigner on Wed Dec 20 00:36:31 AST 2023
 */

package Assignment2;

import com.mysql.cj.log.Log;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.nimbus.State;

/**
 * @author drn
 */
public class RegisterPage extends JFrame {
    public RegisterPage() {
        initComponents();
    }

    private void registerButton(ActionEvent e) {
        // TODO add your code here
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());
        boolean canRegister = true;

        if (username.equals("") || password.equals("")){
            JOptionPane.showMessageDialog(null, "Some fields are empty!", "Error", 1);
        }
        else if (username.equals("Admin")){
            JOptionPane.showMessageDialog(null, "YOU CAN'T USE THIS USERNAME", "Error", 1);
        }
        else {
            try{
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/APCourseAssignment2", "root", "drn12345");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

                while (resultSet.next()){
                    if (username.equals(resultSet.getString(1))){
                        JOptionPane.showMessageDialog(null, "User Already registered", "Error", 1);
                        canRegister = false;
                    }
                }
                if (resultSet.next() == false && canRegister == true){
                    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users VALUES (?,?)");
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, password);
                    int result = preparedStatement.executeUpdate();

                    if (result == 1){
                        JOptionPane.showMessageDialog(null, "Register Done! You can Login now", "Done", 1);
                        preparedStatement.close();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Failed Register", "Error", 1);
                        preparedStatement.close();
                    }

                }
                resultSet.close();
                statement.close();
                connection.close();

            }
            catch (SQLException e2){
                e2.printStackTrace();
            }
        }
    }

    private void loginButton2(ActionEvent e) {
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
        panel1 = new JPanel();
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        registerButton2 = new JButton();
        label2 = new JLabel();
        loginButton2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Register Page");
        label1.setIcon(new ImageIcon(getClass().getResource("/Assignment2/userIcon.png")));
        label1.setForeground(new Color(0x00cccc));
        label1.setFont(new Font("Segoe UI", Font.BOLD, 22));
        contentPane.add(label1);
        label1.setBounds(105, 5, 185, 27);

        //======== panel1 ========
        {
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax
            . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e" , javax. swing
            .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .
            Font ( "D\u0069al\u006fg", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red
            ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override
            public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062or\u0064er" .equals ( e. getPropertyName (
            ) ) )throw new RuntimeException( ) ;} } );
            panel1.setLayout(new BorderLayout());

            //---- usernameField ----
            usernameField.setBorder(new TitledBorder("Username"));
            panel1.add(usernameField, BorderLayout.NORTH);

            //---- passwordField ----
            passwordField.setBorder(new TitledBorder("Password"));
            panel1.add(passwordField, BorderLayout.SOUTH);
        }
        contentPane.add(panel1);
        panel1.setBounds(35, 50, 320, 130);

        //---- registerButton2 ----
        registerButton2.setText("Register");
        registerButton2.setFont(registerButton2.getFont().deriveFont(registerButton2.getFont().getStyle() | Font.BOLD));
        registerButton2.setForeground(new Color(0x00cccc));
        registerButton2.addActionListener(e -> registerButton(e));
        contentPane.add(registerButton2);
        registerButton2.setBounds(145, 195, 105, 30);

        //---- label2 ----
        label2.setText("Already have account?");
        label2.setIcon(null);
        label2.setForeground(Color.black);
        label2.setFont(new Font("Segoe UI", Font.BOLD, 12));
        contentPane.add(label2);
        label2.setBounds(130, 230, 140, 27);

        //---- loginButton2 ----
        loginButton2.setText("Login");
        loginButton2.setFont(loginButton2.getFont().deriveFont(loginButton2.getFont().getStyle() | Font.BOLD, loginButton2.getFont().getSize() - 4f));
        loginButton2.setForeground(new Color(0x00cccc));
        loginButton2.addActionListener(e -> loginButton2(e));
        contentPane.add(loginButton2);
        loginButton2.setBounds(160, 255, 75, 25);

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
        setSize(400, 320);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Hassan
    private JLabel label1;
    private JPanel panel1;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton2;
    private JLabel label2;
    private JButton loginButton2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
