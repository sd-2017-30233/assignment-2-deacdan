package model;

import model.Book;
import model.IReport;

import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Created by dandeac on 01/05/2017.
 */
public class CSV implements IReport {
    FileWriter file = null;

    public void build(){
        try{
            file = new FileWriter("report.csv");
            file.append("TITLE,AUTHOR,GENRE,PRICE".toString());
            file.append("\n");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void generateReport(){
        ArrayList<Book> list =Book.booksOutOfStock();
        try{
        for(int i=0;i<list.size();i++){
            file.append(list.get(i).getTitle()); file.append(",");
            file.append(list.get(i).getAuthor()); file.append(",");
            file.append(list.get(i).getGenre()); file.append(",");
            file.append(list.get(i).getPrice()); file.append(",");
            file.append("\n");
        }

         }catch (Exception e){
            e.printStackTrace();
        }
        try {
            file.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
