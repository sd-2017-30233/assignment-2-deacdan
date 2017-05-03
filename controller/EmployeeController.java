package controller;

import model.Book;
import view.EmployeeFrame;
import view.IntroFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dandeac on 02/05/2017.
 */
public class EmployeeController {
    EmployeeFrame employeeFrame;

    public EmployeeController(EmployeeFrame frame){
        this.employeeFrame=frame;
        employeeFrame.searchTitleListener(new TitleSearchListener());
        employeeFrame.searchGenreListener(new GenreSearchListener());
        employeeFrame.searchAuthorListener(new AuthorSearchListener());
        employeeFrame.sellListener(new SellListener());

        employeeFrame.logoutListener(new LogoutListener());
    }

    public class TitleSearchListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(employeeFrame.getBookTitle().equalsIgnoreCase(""))
                employeeFrame.displayMessage("Wrong input data!");
            else if(event.getActionCommand().equalsIgnoreCase("click")){

                    employeeFrame.displayInfo(Book.searchByTitle(employeeFrame.getBookTitle()));
                    employeeFrame.blankTextfields();

            }
        }
    }

    public class GenreSearchListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(employeeFrame.getGenre().equalsIgnoreCase(""))
                employeeFrame.displayMessage("Wrong input data!");
            else if(event.getActionCommand().equalsIgnoreCase("click")){

                    employeeFrame.displayInfo(Book.searchByGenre(employeeFrame.getGenre()));
                    employeeFrame.blankTextfields();

            }
        }
    }

    public class AuthorSearchListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(employeeFrame.getAuthor().equalsIgnoreCase(""))
                employeeFrame.displayMessage("Wrong input data!");
            else if(event.getActionCommand().equalsIgnoreCase("click")){

                    employeeFrame.displayInfo(Book.searchByAuthor(employeeFrame.getAuthor()));
                    employeeFrame.blankTextfields();

            }
        }
    }


    public class SellListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(employeeFrame.getBookTitle().equalsIgnoreCase("") ||employeeFrame.getAuthor().equalsIgnoreCase("")|| Integer.parseInt(employeeFrame.getQuantity())<=0)
                employeeFrame.displayMessage("Wrong input data!");
            else if(event.getActionCommand().equalsIgnoreCase("click")){
                if(Book.isBook(employeeFrame.getBookTitle())){
                    Book.sell(employeeFrame.getBookTitle(),Integer.parseInt(employeeFrame.getQuantity()),employeeFrame.getAuthor());
                    employeeFrame.blankTextfields();

                }else employeeFrame.displayMessage("The book don't exist!");
            }
        }
    }



    public class LogoutListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(event.getActionCommand().equalsIgnoreCase("click")){
                employeeFrame.closeWindow();
                employeeFrame.displayMessage("GOODBYE");
                new MainController(new IntroFrame());
            }
        }
    }
}
