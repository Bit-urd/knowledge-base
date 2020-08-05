/*
 * Created by JFormDesigner on Mon May 25 13:52:17 CST 2020
 */

package disk;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

import dao.DiskDao;
import dao.UserdiskDao;
import entity.Disk;
import entity.User;
import net.miginfocom.swing.*;

/**
 * @author biturd
 */
public class DiskBorrowDialog extends JDialog {

    UserdiskDao userdiskDao = new UserdiskDao();
    Disk disk = null;
    User user = null;
    DiskDao diskDao = new DiskDao();

    public DiskBorrowDialog(Frame owner, String diskName) {
        super(owner);
        initComponents();   // 将书籍信息封装进 BookDialog实体
    }

    public DiskBorrowDialog(Dialog owner) {
        super(owner);
        initComponents();
    }

    public DiskBorrowDialog(JFrame owner, Disk disk, User user) {
        super(owner);
        initComponents();   // 将书籍信息封装进 BookDialog实体
        this.disk = disk;
        this.user = user;
        try {
            changeMessage(disk, user, 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // 弹窗上的数据
    private void changeMessage(Disk disk, User user, int... a) throws SQLException {
        boolean flag;
        flag = userdiskDao.queryByName(user.getUsername(), disk.getName());
        if (a.length == 0) {

            if (flag) {  // 查到了,归还操作
                label9.setText("未借阅");
                diskDao.updateByName(disk.getName(), disk.getNum() + 1);
            } else {
                label9.setText("已借阅");
                if (disk.getNum() == 0) {  // 考虑到万一借到0了后，不能为负数
                    label9.setText("缺货中");
                }
                diskDao.updateByName(disk.getName(), disk.getNum() <= 0 ? 0 : disk.getNum() - 1);
            }
        }else {
            if (!flag){
                label9.setText("已借阅");
            }else {
                label9.setText("未借阅");
            }
        }

        disk = diskDao.queryByName(disk.getName());
        this.disk = disk;
        label6.setText(disk.getName());
        label7.setText(disk.getMessage());
        label8.setText(String.valueOf(disk.getNum()));
    }

    private void borrowActionPerformed(ActionEvent e) {
        label10.setText("");
        try {
            // 关系表中 插入这条记录
            if (1 == (userdiskDao.insert(user.getUsername(), disk.getName()))) {
                changeMessage(this.disk, this.user);
            } else {
                label10.setText("借阅失败");
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

    private void revertActionPerformed(ActionEvent e) {
        label10.setText("");
        try {
            if (1 == userdiskDao.delete(user.getUsername(), disk.getName())) {
                changeMessage(this.disk, this.user);
            } else {
                label10.setText("归还失败");
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label6 = new JLabel();
        label3 = new JLabel();
        label7 = new JLabel();
        label4 = new JLabel();
        label8 = new JLabel();
        label5 = new JLabel();
        label9 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        label10 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
        label1.setText("\u5149\u76d8\u8be6\u60c5");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));
        contentPane.add(label1, "cell 3 0");

        //---- label2 ----
        label2.setText("\u5149\u76d8\u540d\uff1a");
        contentPane.add(label2, "cell 1 1");

        //---- label6 ----
        label6.setText("label6");
        contentPane.add(label6, "cell 2 1");

        //---- label3 ----
        label3.setText("\u7b80\u4ecb\uff1a");
        contentPane.add(label3, "cell 1 2");

        //---- label7 ----
        label7.setText("label7");
        contentPane.add(label7, "cell 2 2");

        //---- label4 ----
        label4.setText("\u5269\u4f59\u6570\u91cf\uff1a");
        contentPane.add(label4, "cell 1 3");

        //---- label8 ----
        label8.setText("label8");
        contentPane.add(label8, "cell 2 3");

        //---- label5 ----
        label5.setText("\u72b6\u6001\uff1a");
        contentPane.add(label5, "cell 1 4");

        //---- label9 ----
        label9.setText("label9");
        contentPane.add(label9, "cell 2 4");

        //---- button1 ----
        button1.setText("\u501f\u9605");
        button1.addActionListener(e -> borrowActionPerformed(e));
        contentPane.add(button1, "cell 2 5");

        //---- button2 ----
        button2.setText("\u5f52\u8fd8");
        button2.addActionListener(e -> revertActionPerformed(e));
        contentPane.add(button2, "cell 4 5");
        contentPane.add(label10, "cell 3 6");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label6;
    private JLabel label3;
    private JLabel label7;
    private JLabel label4;
    private JLabel label8;
    private JLabel label5;
    private JLabel label9;
    private JButton button1;
    private JButton button2;
    private JLabel label10;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
