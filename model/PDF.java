package model;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import model.Book;
import model.IReport;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * Created by dandeac on 01/05/2017.
 */
public class PDF implements IReport {
    Font font = new Font();

    Document document =  new Document();
    public void build(){
        try{
            PdfWriter.getInstance(document,new FileOutputStream(new File("report.pdf")));
            document.open();

            Paragraph paragraph = new Paragraph();

            font.setSize(14);

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void generateReport(){
        ArrayList<Book> list = Book.booksOutOfStock();

        for(int i=0;i<list.size();i++){
            String text = new String("Cartea "+list.get(i).getTitle()+", scrisa de autorul "+list.get(i).getAuthor()+", nu este in stoc!");
            try{
                document.add(new Paragraph(text,font));
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        document.close();
    }

}
