/*
 * Created by JFormDesigner on Mon May 25 13:52:17 CST 2020
 */

package book;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author biturd
 */
public class BookDialog extends JDialog {
    public BookDialog(Frame owner) {
        super(owner);
        initComponents();
    }

    public BookDialog(Dialog owner) {
        super(owner);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3,align center center",
            // columns
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]"));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
