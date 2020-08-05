/*
 * Created by JFormDesigner on Mon May 25 13:31:40 CST 2020
 */

package login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author biturd
 */
public class LoginFrame extends JFrame {
    public LoginFrame() {
        initComponents();
        setVisible(true);
    }

    private void loginbuttonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void registryActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label3 = new JLabel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();
        label4 = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(600, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3,align center center",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label3 ----
        label3.setText("\u767b\u9646\u6ce8\u518c\u754c\u9762");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 8f));
        contentPane.add(label3, "cell 2 0");

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d\uff1a");
        contentPane.add(label1, "cell 0 1");
        contentPane.add(textField1, "cell 1 1 3 1");

        //---- label2 ----
        label2.setText("\u5bc6\u7801\uff1a");
        contentPane.add(label2, "cell 0 2");
        contentPane.add(passwordField1, "cell 1 2 3 1");

        //---- button1 ----
        button1.setText("\u767b\u9646");
        button1.addActionListener(e -> loginbuttonActionPerformed(e));
        contentPane.add(button1, "cell 1 3");

        //---- button2 ----
        button2.setText("\u6ce8\u518c");
        button2.addActionListener(e -> registryActionPerformed(e));
        contentPane.add(button2, "cell 3 3");

        //---- label4 ----
        label4.setText("text");
        label4.setVisible(false);
        contentPane.add(label4, "cell 2 4");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label3;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton button2;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
