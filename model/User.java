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

/**
 * Created by dandeac on 24/04/2017.
 */
public class User {
    private String username;
    private String password;
    private String userType;

    public User(String username, String password, String userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public static boolean loginVerification(String username,String password){
        try
        {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("user.xml"));
            NodeList nodeList = document.getElementsByTagName("user");

            for (int i = 0; i < nodeList.getLength(); i++) {



                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) nodeList.item(i);
                    if(element.getElementsByTagName("username").item(0).getTextContent().equals(username) && element.getElementsByTagName("password").item(0).getTextContent().equals(password))


                            return true;
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }

    public static String getUserType(String username){
        try
        {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("user.xml"));
            NodeList nodeList = document.getElementsByTagName("user");

            for (int i = 0; i < nodeList.getLength(); i++) {


                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) nodeList.item(i);
                    if(element.getElementsByTagName("username").item(0).getTextContent().equals(username))
                    {
                        return element.getElementsByTagName("type").item(0).getTextContent();
                    }
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return "ERROR";
    }

    public static boolean isUser(String username){
        try
        {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("user.xml"));
            NodeList nodeList = document.getElementsByTagName("user");

            for (int i = 0; i < nodeList.getLength(); i++) {


                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) nodeList.item(i);
                    if(element.getElementsByTagName("username").item(0).getTextContent().equals(username)) return true;


                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public static void addUser(String usr,String pass, String t)
    {
        try
        {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("user.xml"));

            Element orig =document.getDocumentElement();

            Element element = document.createElement("user");
            orig.appendChild(element);

            Element username = document.createElement("username");
            username.setTextContent(usr);

            Element password = document.createElement("password");
            password.setTextContent(pass);

            Element type = document.createElement("type");
            type.setTextContent(t);



            element.appendChild(username);
            element.appendChild(password);
            element.appendChild(type);


            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(document), new StreamResult(new File("user.xml")));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void updateUser(String user,String newPassword, String newType)
    {
        try
        {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("user.xml"));



            NodeList nodeList = document.getElementsByTagName("user");

            for (int i = 0; i < nodeList.getLength(); i++) {


                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) nodeList.item(i);
                    if(element.getElementsByTagName("username").item(0).getTextContent().equals(user))
                    {

                        element.getElementsByTagName("password").item(0).setTextContent((newPassword));
                        element.getElementsByTagName("type").item(0).setTextContent((newType));
                    }
                }
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(document), new StreamResult(new File("user.xml")));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void removeUser(String user){
        try
        {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new FileInputStream("user.xml"));



            NodeList nodeList = document.getElementsByTagName("user");

            for (int i = 0; i < nodeList.getLength(); i++) {


                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) nodeList.item(i);
                    if(element.getElementsByTagName("username").item(0).getTextContent().equals(user))
                    {
                        element.getParentNode().removeChild(element);
                    }
                }
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(document), new StreamResult(new File("user.xml")));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

}
