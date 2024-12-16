package UI;

import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;
import tools.*;

public class LoginFrame extends JFrame{

    Connection connection;
    JPanel loginPanel, msgPanel;

    public LoginFrame(){
        super("Login");
        this.setLayout(new BorderLayout());
        this.setSize(400,400);
        loginPanel = getLoginPanel();
        this.add(loginPanel,BorderLayout.CENTER);
        msgPanel = new JPanel();
        msgPanel.setLayout(new CardLayout());
        msgPanel.add(new JLabel("welcome"));
        this.add(msgPanel,BorderLayout.SOUTH);
    }

    JPanel getLoginPanel(){
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BorderLayout());
        JPanel inputField = new JPanel();
        inputField.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JTextField urlField = addInputField(inputField,gbc,0,0,"Data Base Url:","jdbc:mysql://localhost:3306/testdb");
        JTextField usernameField = addInputField(inputField,gbc,0,1,"User name:","root");
        JTextField passwordField = addInputField(inputField,gbc,0,2,"password:","root");
        loginPanel.add(inputField,BorderLayout.CENTER);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e ->{
            msgPanel.removeAll();
            msgPanel.revalidate();
            msgPanel.repaint();
            String url = urlField.getText();
            String password = passwordField.getText();
            String username = usernameField.getText();
            try{
                this.connection = Tools.getConnection(url,username,password);
                this.msgPanel.add(new JLabel("Login Successfully"));
                this.setVisible(false);
                MainFrame mainFrame = new MainFrame(connection);
                mainFrame.setVisible(true);
            }catch(SQLException ex){
                this.msgPanel.add(new JLabel("Login Faild"));
            }
        });
        loginPanel.add(loginButton,BorderLayout.SOUTH);
        return loginPanel;
    }

    public static JTextField addInputField(Container container, GridBagConstraints gbc, int gridx, int gridy, String label, String defaultInput) {

        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.anchor = GridBagConstraints.EAST;
        JLabel inputLabel = new JLabel(label);
        container.add(inputLabel, gbc);

        gbc.gridx = gridx + 1;
        gbc.gridy = gridy;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField inputField = new JTextField(defaultInput, 15);
        container.add(inputField, gbc);

        return inputField;
    }
}


