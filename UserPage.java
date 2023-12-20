/*
 * Created by JFormDesigner on Tue Dec 19 22:43:54 AST 2023
 */

package Assignment2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author hassa
 */
public class UserPage extends JFrame {
    public UserPage() {
        initComponents();
    }

    private void loginButtonEvent(ActionEvent e) {
        // TODO add your code here
    }

    private void LogoutButton(ActionEvent e) {
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
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        loginButton = new JButton();

        //======== this ========
        setTitle("Movies Home Page");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Home");
        label1.setIcon(null);
        label1.setForeground(new Color(0x00cccc));
        label1.setFont(new Font("Segoe UI", Font.BOLD, 22));
        contentPane.add(label1);
        label1.setBounds(20, 15, 160, 30);

        //---- label2 ----
        label2.setText("Top 10 Movies");
        label2.setIcon(null);
        label2.setForeground(Color.white);
        label2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        contentPane.add(label2);
        label2.setBounds(15, 50, 160, 30);

        //---- label3 ----
        label3.setText("New Movies");
        label3.setIcon(null);
        label3.setForeground(Color.white);
        label3.setFont(new Font("Segoe UI", Font.BOLD, 16));
        contentPane.add(label3);
        label3.setBounds(15, 360, 160, 30);

        //---- label4 ----
        label4.setIcon(new ImageIcon(getClass().getResource("/Assignment2/Screenshot 2023-12-19 225308.png")));
        contentPane.add(label4);
        label4.setBounds(20, 385, 490, 220);

        //---- label5 ----
        label5.setIcon(new ImageIcon(getClass().getResource("/Assignment2/Screenshot 2023-12-19 225534.png")));
        contentPane.add(label5);
        label5.setBounds(15, 85, 475, 265);

        //---- label6 ----
        label6.setText("Jazan Cinema Website");
        label6.setIcon(null);
        label6.setForeground(Color.white);
        label6.setFont(new Font("Segoe UI", Font.BOLD, 12));
        contentPane.add(label6);
        label6.setBounds(190, 615, 155, 30);

        //---- label7 ----
        label7.setText("https://ksa.empirecinemas.com/");
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() - 2f));
        label7.setForeground(new Color(0x0099cc));
        contentPane.add(label7);
        label7.setBounds(170, 640, 205, label7.getPreferredSize().height);

        //---- loginButton ----
        loginButton.setText("Logout");
        loginButton.setFont(loginButton.getFont().deriveFont(loginButton.getFont().getStyle() | Font.BOLD));
        loginButton.setForeground(new Color(0x00cccc));
        loginButton.addActionListener(e -> LogoutButton(e));
        contentPane.add(loginButton);
        loginButton.setBounds(425, 15, 105, loginButton.getPreferredSize().height);

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
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Hassan
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JButton loginButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
