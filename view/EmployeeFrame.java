package view;

import model.Book;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by dandeac on 01/05/2017.
 */
public class EmployeeFrame extends JFrame {private JButton logoutB;
    private JLabel jcomp2;
    private JLabel jcomp3;
    private JLabel jcomp4;
    private JLabel jcomp5;
    private JLabel jcomp6;
    private JTextField titleTF;
    private JTextField authorTF;
    private JTextField genreTF;
    private JTextField quantityTF;
    private JTextField priceTF;
    private JLabel jcomp12;
    private JButton searchTitleB;
    private JButton searchGenreB;
    private JButton searchAuthorB;
    private JButton sellB;
    private JLabel jcomp17;

    private JPanel contentPane;


    public EmployeeFrame() {
        super("EMPLOYEE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        contentPane = new JPanel();
        setContentPane(contentPane);
        //construct components
        logoutB = new JButton ("LOGOUT");
        jcomp2 = new JLabel ("title:");
        jcomp3 = new JLabel ("author:");
        jcomp4 = new JLabel ("genre:");
        jcomp5 = new JLabel ("quantity:");
        jcomp6 = new JLabel ("price:");
        titleTF = new JTextField (5);
        authorTF = new JTextField (5);
        genreTF = new JTextField (5);
        quantityTF = new JTextField (5);
        priceTF = new JTextField (5);
        jcomp12 = new JLabel ("SEARCH BY:");
        searchTitleB = new JButton ("TITLE");
        searchGenreB = new JButton ("GENRE");
        searchAuthorB = new JButton ("AUTHOR");
        sellB = new JButton ("SELL");
        jcomp17 = new JLabel ("SELL BOOKS");

        //adjust size and set layout
        contentPane.setPreferredSize (new Dimension(331, 200));
        contentPane.setLayout (null);

        //add components
        contentPane.add (logoutB);
        contentPane.add (jcomp2);
        contentPane.add (jcomp3);
        contentPane.add (jcomp4);
        contentPane.add (jcomp5);
        contentPane.add (jcomp6);
        contentPane.add (titleTF);
        contentPane.add (authorTF);
        contentPane.add (genreTF);
        contentPane.add (quantityTF);
        contentPane.add (priceTF);
        contentPane.add (jcomp12);
        contentPane.add (searchTitleB);
        contentPane.add (searchGenreB);
        contentPane.add (searchAuthorB);
        contentPane.add (sellB);
        contentPane.add (jcomp17);

        //set component bounds (only needed by Absolute Positioning)
        logoutB.setBounds (95, 5, 100, 25);
        jcomp2.setBounds (5, 45, 100, 25);
        jcomp3.setBounds (5, 75, 100, 25);
        jcomp4.setBounds (5, 105, 100, 25);
        jcomp5.setBounds (5, 140, 100, 25);
        jcomp6.setBounds (5, 170, 100, 25);
        titleTF.setBounds (90, 45, 100, 25);
        authorTF.setBounds (90, 75, 100, 25);
        genreTF.setBounds (90, 105, 100, 25);
        quantityTF.setBounds (90, 140, 100, 25);
        priceTF.setBounds (90, 170, 100, 25);
        jcomp12.setBounds (240, 20, 100, 25);
        searchTitleB.setBounds (225, 50, 100, 25);
        searchGenreB.setBounds (225, 80, 100, 25);
        searchAuthorB.setBounds (225, 110, 100, 25);
        sellB.setBounds (225, 170, 100, 25);
        jcomp17.setBounds (240, 140, 100, 25);

        logoutB.setActionCommand("Click");
        searchAuthorB.setActionCommand("Click");
        searchGenreB.setActionCommand("Click");
        searchTitleB.setActionCommand("Click");
        sellB.setActionCommand("Click");

        this.pack();
    }

    public void displayMessage(String text){
        JOptionPane.showMessageDialog(null,text);
    }

    public void closeWindow(){
        setVisible(false);
    }

    public void searchTitleListener(ActionListener cal){
        searchTitleB.addActionListener(cal);
    }
    public void searchAuthorListener(ActionListener cal){
        searchAuthorB.addActionListener(cal);
    }
    public void searchGenreListener(ActionListener cal){
        searchGenreB.addActionListener(cal);
    }
    public void sellListener(ActionListener cal){
        sellB.addActionListener(cal);
    }
    public void logoutListener(ActionListener cal){
        logoutB.addActionListener(cal);
    }

    public void blankTextfields(){
        titleTF.setText("");
        authorTF.setText("");
        genreTF.setText("");
        quantityTF.setText("");
        priceTF.setText("");
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

    public void displayInfo(ArrayList<Book> listOfBooks){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Title");
        model.addColumn("Author");
        model.addColumn("Genre");
        model.addColumn("Quantity");
        model.addColumn("Price");




        for(int i=0;i<listOfBooks.size();i++)
        {
            model.addRow( new Object[]{listOfBooks.get(i).getTitle(),listOfBooks.get(i).getAuthor(),
                    listOfBooks.get(i).getGenre(),listOfBooks.get(i).getQuantity(),listOfBooks.get(i).getPrice()} );
        }

        JTable table = new JTable(model);

        table.setPreferredScrollableViewportSize(new Dimension(700,300));
        if(listOfBooks.isEmpty())
            displayMessage("THERE ARE NO BOOKS THAT ARE MATCHING YOUR SEARCH");
        else
            JOptionPane.showMessageDialog(null, new JScrollPane(table));

    }
}
