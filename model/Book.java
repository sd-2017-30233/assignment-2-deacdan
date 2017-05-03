package model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

/**
 * Created by dandeac on 24/04/2017.
 */
public class Book {

    private String title;
    private String author;
    private String genre;
    private String quantity;
    private String price;

    public Book(String title, String author, String genre, String quantity, String price) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.quantity = quantity;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public static void addBook(String title, String author, String genre, String quantity, String price)
    {
        try
        {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("book.xml"));

            Element orig =document.getDocumentElement();

            Element element = document.createElement("book");
            orig.appendChild(element);

            Element t = document.createElement("title");
            t.setTextContent(title);

            Element a = document.createElement("author");
            a.setTextContent(author);

            Element g = document.createElement("genre");
            g.setTextContent(genre);

            Element q = document.createElement("quantity");
            q.setTextContent(quantity);

            Element p= document.createElement("price");
            p.setTextContent(price);

            element.appendChild(t);
            element.appendChild(a);
            element.appendChild(g);
            element.appendChild(q);
            element.appendChild(p);


            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(document), new StreamResult(new File("book.xml")));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void updateBook(String title,String quantity, String price)
    {
        try
        {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("book.xml"));



            NodeList nodeList = document.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++) {


                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) nodeList.item(i);
                    if(element.getElementsByTagName("title").item(0).getTextContent().equals(title))
                    {

                        element.getElementsByTagName("quantity").item(0).setTextContent((quantity));
                        element.getElementsByTagName("price").item(0).setTextContent((price));
                    }
                }
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(document), new StreamResult(new File("book.xml")));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    public static void removeBook(String title){
        try
        {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("book.xml"));



            NodeList nodeList = document.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++) {


                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) nodeList.item(i);
                    if(element.getElementsByTagName("title").item(0).getTextContent().equals(title))
                    {
                        element.getParentNode().removeChild(element);
                    }
                }
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(document), new StreamResult(new File("book.xml")));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public static boolean isBook(String title){
        try
        {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("book.xml"));



            NodeList nodeList = document.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++) {


                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) nodeList.item(i);
                    if(element.getElementsByTagName("title").item(0).getTextContent().equals(title)) return true;
                }
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    return false;

    }

    public static ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> lista = null;
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("book.xml"));

            lista = new ArrayList<Book>();

            NodeList nodeList = document.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++) {


                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) nodeList.item(i);
                    if (element.getElementsByTagName("title").item(0).getTextContent().equals(title)) {
                        String t = element.getElementsByTagName("title").item(0).getTextContent();
                        String a = element.getElementsByTagName("author").item(0).getTextContent();
                        String g = element.getElementsByTagName("genre").item(0).getTextContent();
                        String q = element.getElementsByTagName("quantity").item(0).getTextContent();
                        String p = element.getElementsByTagName("price").item(0).getTextContent();

                        Book book = new Book(t, a, g, q, p);
                        lista.add(book);

                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;

    }

    public static ArrayList<Book> searchByGenre(String genre){
        ArrayList<Book> lista = null;
        try
        {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("book.xml"));

            lista = new ArrayList<Book>();

            NodeList nodeList = document.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++) {


                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) nodeList.item(i);
                    if(element.getElementsByTagName("genre").item(0).getTextContent().equals(genre))
                    {
                        String t = element.getElementsByTagName("title").item(0).getTextContent();
                        String a = element.getElementsByTagName("author").item(0).getTextContent();
                        String g = element.getElementsByTagName("genre").item(0).getTextContent();
                        String q = element.getElementsByTagName("quantity").item(0).getTextContent();
                        String p = element.getElementsByTagName("price").item(0).getTextContent();

                        Book book = new Book(t,a,g,q,p);
                        lista.add(book);

                    }
                }
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return lista;

    }

    public static ArrayList<Book> searchByAuthor(String author){
        ArrayList<Book> lista = null;
        try
        {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("book.xml"));

            lista = new ArrayList<Book>();

            NodeList nodeList = document.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++) {


                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) nodeList.item(i);
                    if(element.getElementsByTagName("author").item(0).getTextContent().equals(author))
                    {
                        String t = element.getElementsByTagName("title").item(0).getTextContent();
                        String a = element.getElementsByTagName("author").item(0).getTextContent();
                        String g = element.getElementsByTagName("genre").item(0).getTextContent();
                        String q = element.getElementsByTagName("quantity").item(0).getTextContent();
                        String p = element.getElementsByTagName("price").item(0).getTextContent();

                        Book book = new Book(t,a,g,q,p);
                        lista.add(book);

                    }
                }
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return lista;

    }

    public static ArrayList<Book> booksOutOfStock(){
        ArrayList<Book> lista = null;
        try
        {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("book.xml"));

            lista = new ArrayList<Book>();

            NodeList nodeList = document.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++) {


                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) nodeList.item(i);
                    if(element.getElementsByTagName("quantity").item(0).getTextContent().equalsIgnoreCase("0"))
                    {
                        String t = element.getElementsByTagName("title").item(0).getTextContent();
                        String a = element.getElementsByTagName("author").item(0).getTextContent();
                        String g = element.getElementsByTagName("genre").item(0).getTextContent();
                        String q = element.getElementsByTagName("quantity").item(0).getTextContent();
                        String p = element.getElementsByTagName("price").item(0).getTextContent();

                        Book book = new Book(t,a,g,q,p);
                        lista.add(book);

                    }
                }
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return lista;

    }

    public static boolean duplicateAuthors(ArrayList<Book> listOfBooks, String author){
        if(listOfBooks.isEmpty()) return false;
        for(int i=0;i<listOfBooks.size();i++){
            if(listOfBooks.get(i).getAuthor().equalsIgnoreCase(author)) return true;
        }
        return false;
    }

    public static void sell(String title,int sQuantity, String author){
        try{
            ArrayList<Book> list =searchByTitle(title);
            for(int i=0;i<list.size();i++) {
                Book book = list.get(i);

                if (Integer.parseInt(book.getQuantity()) >= sQuantity && book.getAuthor().equalsIgnoreCase(author)) {
                    book.setQuantity(Integer.toString(Integer.parseInt(book.getQuantity()) - sQuantity));
                    updateBook(book.getTitle(), book.getQuantity(), book.getPrice());

                    //Scrierea in fisierul sell.xml

                    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = builderFactory.newDocumentBuilder();
                    Document document = builder.parse(new FileInputStream("sell.xml"));

                    Element orig = document.getDocumentElement();

                    Element element = document.createElement("sell");
                    orig.appendChild(element);

                    Element t = document.createElement("title");
                    t.setTextContent(book.getTitle());

                    Element a = document.createElement("author");
                    a.setTextContent(book.getAuthor());

                    Element g = document.createElement("genre");
                    g.setTextContent(book.getGenre());

                    Element q = document.createElement("quantity");
                    q.setTextContent(Integer.toString(sQuantity));

                    Element p = document.createElement("price");
                    p.setTextContent(book.getPrice());

                    Element tp = document.createElement("totalPrice");
                    tp.setTextContent(Integer.toString(Integer.parseInt(book.getPrice()) * sQuantity));

                    element.appendChild(t);
                    element.appendChild(a);
                    element.appendChild(g);
                    element.appendChild(q);
                    element.appendChild(p);
                    element.appendChild(tp);


                    Transformer transformer = TransformerFactory.newInstance().newTransformer();
                    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    transformer.transform(new DOMSource(document), new StreamResult(new File("sell.xml")));

                }

            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
