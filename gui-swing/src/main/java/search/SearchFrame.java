/*
 * Created by JFormDesigner on Mon May 25 11:52:44 CST 2020
 */

package search;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author biturd
 */
public class SearchFrame extends JFrame {
    public SearchFrame() {
        initComponents();
    }

    private void searchActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        label2 = new JLabel();

        //======== this ========
        setFont(new Font("Dialog", Font.PLAIN, 23));
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(600, 400));
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3,align center center",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("\u5149\u76d8\u641c\u7d22\u754c\u9762");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 11f));
        contentPane.add(label1, "cell 5 1");
        contentPane.add(textField1, "cell 4 3 3 1");

        //---- button1 ----
        button1.setText("\u641c\u7d22");
        button1.addActionListener(e -> searchActionPerformed(e));
        contentPane.add(button1, "cell 5 4");

        //---- label2 ----
        label2.setVisible(false);
        contentPane.add(label2, "cell 5 5");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        SearchFrame searchFrame = new SearchFrame();
    }
}
