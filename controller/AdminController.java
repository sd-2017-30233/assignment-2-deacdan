package controller;


import model.*;
import view.AdminFrame;
import view.IntroFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by dandeac on 02/05/2017.
 */
public class AdminController {
    public AdminFrame adminFrame;

    public AdminController(AdminFrame frame){
        this.adminFrame=frame;

        adminFrame.addEmpoyeeListener(new AddEmpListener());
        adminFrame.updateEmployeeListener(new UpdateEmpListener());
        adminFrame.deleteEmployeeListener(new RemoveEmpListener());
        adminFrame.addBookListener(new AddBookListener());
        adminFrame.updateBookListener(new UpdateBookListener());
        adminFrame.deleteBookListener(new RemoveBookListener());
        adminFrame.generatePDFListener(new GeneratePDFListener());
        adminFrame.generateCSVListener(new GenerateCSVListener());
        adminFrame.logoutListener(new LogoutListener());
    }

    public class AddEmpListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(adminFrame.getUsername().equalsIgnoreCase("") || adminFrame.getPassword().equalsIgnoreCase("") || (!adminFrame.getTypee().equalsIgnoreCase("admin") && !adminFrame.getTypee().equalsIgnoreCase("employee")))
                adminFrame.displayMessage("Wrong input data!");
               else{
                if(event.getActionCommand().equalsIgnoreCase("click"))
                    if(!User.isUser(adminFrame.getUsername())){
                        User.addUser(adminFrame.getUsername(),adminFrame.getPassword(),adminFrame.getTypee());
                        adminFrame.blankTextfields();

                    }
                    else adminFrame.displayMessage("The user exists!");

            }

        }
    }

    public class UpdateEmpListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(adminFrame.getUsername().equalsIgnoreCase("") || adminFrame.getPassword().equalsIgnoreCase("") ||
                    (!adminFrame.getTypee().equalsIgnoreCase("admin") && !adminFrame.getTypee().equalsIgnoreCase("employee")))
                adminFrame.displayMessage("Wrong input data!");
            else{
                if(event.getActionCommand().equalsIgnoreCase("click"))
                    if(User.isUser(adminFrame.getUsername())){
                        User.updateUser(adminFrame.getUsername(),adminFrame.getPassword(),adminFrame.getTypee());
                        adminFrame.blankTextfields();

                    }
                    else adminFrame.displayMessage("The user dont't exist!");

            }
        }
    }

    public class RemoveEmpListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(adminFrame.getUsername().equalsIgnoreCase(""))
                adminFrame.displayMessage("Wrong input data!");
            else{
                if(event.getActionCommand().equalsIgnoreCase("click"))
                    if(User.isUser(adminFrame.getUsername())){
                        User.removeUser(adminFrame.getUsername());
                        adminFrame.blankTextfields();

                    }
                    else adminFrame.displayMessage("The user dont't exist!");

            }
        }
    }

    public class AddBookListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (adminFrame.getBookTitle().equalsIgnoreCase("") || adminFrame.getAuthor().equalsIgnoreCase("") ||
                    adminFrame.getGenre().equalsIgnoreCase("") || adminFrame.getQuantity().equalsIgnoreCase("") ||
                    adminFrame.getPrice().equalsIgnoreCase(""))
                adminFrame.displayMessage("Wrong input data!");
            else {
                if (event.getActionCommand().equalsIgnoreCase("click")) {
                    ArrayList<Book> listOfBooks = Book.searchByTitle(adminFrame.getBookTitle());

                    //doua carti pot avea acelasi nume dar autori diferiti
                        if (!Book.isBook(adminFrame.getBookTitle()) || !Book.duplicateAuthors(listOfBooks,adminFrame.getAuthor())) {
                            Book.addBook(adminFrame.getBookTitle(), adminFrame.getAuthor(), adminFrame.getGenre(), adminFrame.getQuantity(), adminFrame.getPrice());
                            adminFrame.blankTextfields();

                        } else adminFrame.displayMessage("The book exists!");
                    }

            }

        }
    }

    public class UpdateBookListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(adminFrame.getBookTitle().equalsIgnoreCase("") || adminFrame.getQuantity().equalsIgnoreCase("") ||
                    adminFrame.getPrice().equalsIgnoreCase(""))
                adminFrame.displayMessage("Wrong input data!");
            else{
                if(event.getActionCommand().equalsIgnoreCase("click"))
                    if(Book.isBook(adminFrame.getBookTitle())){
                        Book.updateBook(adminFrame.getBookTitle(),adminFrame.getQuantity(),adminFrame.getPrice());
                        adminFrame.blankTextfields();

                    }
                    else adminFrame.displayMessage("The book don't exist!");

            }

        }
    }


    public class RemoveBookListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(adminFrame.getBookTitle().equalsIgnoreCase(""))
                adminFrame.displayMessage("Wrong input data!");
            else{
                if(event.getActionCommand().equalsIgnoreCase("click"))
                    if(Book.isBook(adminFrame.getBookTitle())){
                       Book.removeBook(adminFrame.getBookTitle());
                        adminFrame.blankTextfields();

                    }
                    else adminFrame.displayMessage("The book don't exist!");

            }

        }
    }

    public class GenerateCSVListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(event.getActionCommand().equalsIgnoreCase("click")){
                Factory factory = new Factory();
                CSVFactory csvFactory = new CSVFactory();
                factory.getFactory("csv");
                CSV csv = (CSV) csvFactory.build();
                csv.generateReport();
            }
        }
    }

    public class GeneratePDFListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(event.getActionCommand().equalsIgnoreCase("click")){
                Factory factory = new Factory();
                PDFFactory pdfFactory = new PDFFactory();
                factory.getFactory("pdf");
                PDF pdf = (PDF) pdfFactory.build();
                pdf.generateReport();
            }
        }
    }

    public class LogoutListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(event.getActionCommand().equalsIgnoreCase("click")){
                adminFrame.closeWindow();
                adminFrame.displayMessage("GOODBYE");
                new MainController(new IntroFrame());
            }
        }
    }



}
