package UI;

import java.awt.*;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

    private Connection connection;

    public MainFrame(Connection connection) {
        this.connection = connection;  // 接收数据库连接
        setTitle("Main Frame");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 顶部菜单栏
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,20,10));
        topPanel.setBorder(new EmptyBorder(0, 150, 0, 0)); // 左侧留白20像素
        JButton editeButton = new JButton("Edite");
        JButton findButton = new JButton("Find");
        topPanel.add(editeButton);
        topPanel.add(findButton);

        // 添加下拉菜单（JPopupMenu）
        JPopupMenu editMenu = new JPopupMenu();
        JMenuItem addItem = new JMenuItem("Add");
        JMenuItem delItem = new JMenuItem("Del");
        JMenuItem updateItem = new JMenuItem("Update");

        editMenu.add(addItem);
        editMenu.add(delItem);
        editMenu.add(updateItem);

        editeButton.addActionListener(e -> editMenu.show(editeButton, 0, editeButton.getHeight()));

        // 左侧功能选择区域
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS)); // 垂直布局
        leftPanel.setBorder(new EmptyBorder(0, 10, 0, 0)); // 上、左、下、右边距

        // 添加按钮并左对齐
        JButton myClubButton = new JButton("My Club");
        JButton clubMemberButton = new JButton("Club Member");
        JButton clubActivityButton = new JButton("Club Activity");
        JButton notificationButton = new JButton("Notification");

        // 设置按钮左对齐
        myClubButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        clubMemberButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        clubActivityButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        notificationButton.setAlignmentX(Component.LEFT_ALIGNMENT);

        // 添加按钮及垂直间隔
        leftPanel.add(Box.createVerticalStrut(50)); // 顶部间隔
        leftPanel.add(myClubButton);
        leftPanel.add(Box.createVerticalStrut(30)); // 间隔
        leftPanel.add(clubMemberButton);
        leftPanel.add(Box.createVerticalStrut(30));
        leftPanel.add(clubActivityButton);
        leftPanel.add(Box.createVerticalStrut(30));
        leftPanel.add(notificationButton);

        // 添加面板到主窗口的左侧
        add(leftPanel, BorderLayout.WEST);
        add(topPanel, BorderLayout.NORTH);

        // 中央内容区域
        JPanel centerPanel = new JPanel();
        add(centerPanel, BorderLayout.CENTER);

        // 添加 ActionListener（函数内容暂时留空）
        myClubButton.addActionListener(e -> myClubAction());
        clubMemberButton.addActionListener(e -> clubMemberAction());
        clubActivityButton.addActionListener(e -> clubActivityAction());
        notificationButton.addActionListener(e -> notificationAction());

        addItem.addActionListener(e -> addAction());
        delItem.addActionListener(e -> delAction());
        updateItem.addActionListener(e -> updateAction());

        // 显示界面
        setVisible(true);
    }

    // 左侧按钮功能方法（内容留空）
    private void myClubAction() {
        // My Club 按钮操作
    }

    private void clubMemberAction() {
        // Club Member 按钮操作
    }

    private void clubActivityAction() {
        // Club Activity 按钮操作
    }

    private void notificationAction() {
        // Notification 按钮操作
    }

    // 编辑按钮下拉菜单功能方法（内容留空）
    private void addAction() {
        // Add 按钮操作
    }

    private void delAction() {
        // Del 按钮操作
    }

    private void updateAction() {
        // Update 按钮操作
    }
}
