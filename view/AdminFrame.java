package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by dandeac on 01/05/2017.
 */
public class AdminFrame extends JFrame {
    private JLabel jcomp1;
    private JLabel jcomp2;
    private JLabel jcomp3;
    private JLabel jcomp4;
    private JTextField usernameTF;
    private JTextField passwordTF;
    private JTextField typeTF;
    private JLabel jcomp8;
    private JLabel jcomp9;
    private JLabel jcomp10;
    private JLabel jcomp11;
    private JLabel jcomp12;
    private JLabel jcomp13;
    private JTextField titleTF;
    private JTextField authorTF;
    private JTextField genreTF;
    private JTextField quantityTF;
    private JTextField priceTF;
    private JButton addEmpB;
    private JButton updateEmpB;
    private JButton deleteEmpB;
    private JButton addBookB;
    private JButton updateBookB;
    private JButton deleteBookB;
    private JButton logoutB;
    private JButton csvB;
    private JButton pdfB;

    private JPanel contentPane;
    public AdminFrame() {
        super("ADMINISTRATOR");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        contentPane = new JPanel();
        setContentPane(contentPane);

        //construct components
        jcomp1 = new JLabel ("username:");
        jcomp2 = new JLabel ("password:");
        jcomp3 = new JLabel ("type:");
        jcomp4 = new JLabel ("EMPLOYEE");
        usernameTF = new JTextField (5);
        passwordTF = new JTextField (5);
        typeTF = new JTextField (5);
        jcomp8 = new JLabel ("BOOK");
        jcomp9 = new JLabel ("title:");
        jcomp10 = new JLabel ("author:");
        jcomp11 = new JLabel ("genre:");
        jcomp12 = new JLabel ("quantity:");
        jcomp13 = new JLabel ("price:");
        titleTF = new JTextField (5);
        authorTF = new JTextField (5);
        genreTF = new JTextField (5);
        quantityTF = new JTextField (5);
        priceTF = new JTextField (5);
        addEmpB = new JButton ("ADD");
        updateEmpB = new JButton ("UPDATE");
        deleteEmpB = new JButton ("DELETE");
        addBookB = new JButton ("ADD");
        updateBookB = new JButton ("UPDATE");
        deleteBookB = new JButton ("DELETE");
        logoutB = new JButton ("LOGOUT");
        csvB = new JButton ("CSVReport");
        pdfB = new JButton ("PDFReport");

        //adjust size and set layout
        contentPane.setPreferredSize (new Dimension(382, 408));
        contentPane.setLayout (null);

        //add components
        contentPane.add (jcomp1);
        contentPane.add (jcomp2);
        contentPane.add (jcomp3);
        contentPane.add (jcomp4);
        contentPane.add (usernameTF);
        contentPane.add (passwordTF);
        contentPane.add (typeTF);
        contentPane.add (jcomp8);
        contentPane.add (jcomp9);
        contentPane.add (jcomp10);
        contentPane.add (jcomp11);
        contentPane.add (jcomp12);
        contentPane.add (jcomp13);
        contentPane.add (titleTF);
        contentPane.add (authorTF);
        contentPane.add (genreTF);
        contentPane.add (quantityTF);
        contentPane.add (priceTF);
        contentPane.add (addEmpB);
        contentPane.add (updateEmpB);
        contentPane.add (deleteEmpB);
        contentPane.add (addBookB);
        contentPane.add (updateBookB);
        contentPane.add (deleteBookB);
        contentPane.add (logoutB);
        contentPane.add (csvB);
        contentPane.add (pdfB);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (10, 70, 100, 25);
        jcomp2.setBounds (10, 100, 100, 25);
        jcomp3.setBounds (10, 130, 100, 25);
        jcomp4.setBounds (50, 35, 100, 25);
        usernameTF.setBounds (115, 70, 100, 25);
        passwordTF.setBounds (115, 100, 100, 25);
        typeTF.setBounds (115, 130, 100, 25);
        jcomp8.setBounds (50, 170, 100, 25);
        jcomp9.setBounds (10, 205, 100, 25);
        jcomp10.setBounds (10, 235, 100, 25);
        jcomp11.setBounds (10, 265, 100, 25);
        jcomp12.setBounds (10, 295, 100, 25);
        jcomp13.setBounds (10, 325, 100, 25);
        titleTF.setBounds (115, 205, 100, 25);
        authorTF.setBounds (115, 235, 100, 25);
        genreTF.setBounds (115, 265, 100, 25);
        quantityTF.setBounds (115, 295, 100, 25);
        priceTF.setBounds (115, 325, 100, 25);
        addEmpB.setBounds (260, 70, 100, 25);
        updateEmpB.setBounds (260, 100, 100, 25);
        deleteEmpB.setBounds (260, 130, 100, 25);
        addBookB.setBounds (260, 235, 100, 25);
        updateBookB.setBounds (260, 265, 100, 25);
        deleteBookB.setBounds (260, 295, 100, 25);
        logoutB.setBounds (160, 5, 100, 25);
        csvB.setBounds (45, 375, 100, 25);
        pdfB.setBounds (195, 375, 100, 25);

        addEmpB.setActionCommand("Click");
        updateEmpB.setActionCommand("Click");
        deleteEmpB.setActionCommand("Click");
        addBookB.setActionCommand("Click");
        updateBookB.setActionCommand("Click");
        deleteBookB.setActionCommand("Click");
        logoutB.setActionCommand("Click");
        csvB.setActionCommand("Click");
        pdfB.setActionCommand("Click");

        this.pack();
    }

    public void displayMessage(String text){
        JOptionPane.showMessageDialog(null,text);
    }

    public void closeWindow(){
        setVisible(false);
    }

    public void blankTextfields(){
        usernameTF.setText("");
        passwordTF.setText("");
        typeTF.setText("");
        titleTF.setText("");
        authorTF.setText("");
        genreTF.setText("");
        quantityTF.setText("");
        priceTF.setText("");
    }

    public void addEmpoyeeListener(ActionListener cal){
        addEmpB.addActionListener(cal);
    }
    public void updateEmployeeListener(ActionListener cal){
        updateEmpB.addActionListener(cal);
    }
    public void deleteEmployeeListener(ActionListener cal){
        deleteEmpB.addActionListener(cal);
    }
    public void addBookListener(ActionListener cal){
        addBookB.addActionListener(cal);
    }
    public void updateBookListener(ActionListener cal){
        updateBookB.addActionListener(cal);
    }
    public void deleteBookListener(ActionListener cal){
        deleteBookB.addActionListener(cal);
    }
    public void generatePDFListener(ActionListener cal){
        pdfB.addActionListener(cal);
    }
    public void generateCSVListener(ActionListener cal){
        csvB.addActionListener(cal);
    }
    public void logoutListener(ActionListener cal){
        logoutB.addActionListener(cal);
    }


    public String getUsername(){
        return usernameTF.getText();
    }
    public String getPassword(){
        return passwordTF.getText();
    }
    public String getTypee(){
        return typeTF.getText();
    }
    public String getBookTitle(){
        return titleTF.getText();
    }
    public String getAuthor(){
        return authorTF.getText();
    }
    public String getGenre(){
        return genreTF.getText();
    }
    public String getQuantity(){
        return quantityTF.getText();
    }
    public String getPrice(){
        return priceTF.getText();
    }
}
