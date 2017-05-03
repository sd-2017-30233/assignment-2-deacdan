package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.tools.internal.xjc.reader.Ring.add;

/**
 * Created by dandeac on 01/05/2017.
 */
public class IntroFrame extends JFrame{
    private JLabel jcomp1;
    private JLabel jcomp2;
    private JLabel jcomp3;
    private JTextField usernameTF;
    private JTextField passwordTF;
    private JButton loginB;
    private JPanel contentPane;

    public IntroFrame() {
        super("MAIN FRAME");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        contentPane = new JPanel();
        setContentPane(contentPane);

        //construct components
        jcomp1 = new JLabel ("Type your username and password!");
        jcomp2 = new JLabel ("username:");
        jcomp3 = new JLabel ("password:");
        usernameTF = new JTextField (5);
        passwordTF = new JTextField (5);
        loginB = new JButton ("LOGIN");

        //adjust size and set layout
        contentPane.setPreferredSize (new Dimension(229, 147));
        contentPane.setLayout (null);

        //add components
        contentPane.add (jcomp1);
        contentPane.add (jcomp2);
        contentPane.add (jcomp3);
        contentPane.add (usernameTF);
        contentPane.add (passwordTF);
        contentPane.add (loginB);


        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (5, 5, 230, 25);
        jcomp2.setBounds (0, 35, 100, 25);
        jcomp3.setBounds (0, 65, 100, 25);
        usernameTF.setBounds (110, 35, 100, 25);
        passwordTF.setBounds (110, 65, 100, 25);
        loginB.setBounds (60, 115, 100, 25);

        loginB.setActionCommand("Click");

        this.pack();
    }

    public String getUsername(){
        return usernameTF.getText();
    }
    public String getPassword(){
        return passwordTF.getText();
    }

    public void addLoginListener(ActionListener cal){
        loginB.addActionListener(cal);
    }
    public void displayMessage(String text){
        JOptionPane.showMessageDialog(null,text);
    }

    public void closeWindow(){
        setVisible(false);
    }


}
