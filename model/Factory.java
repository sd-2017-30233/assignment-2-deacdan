package model;

import model.IRFactory;

/**
 * Created by dandeac on 01/05/2017.
 */
public class Factory {

    public IRFactory getFactory(String type){
        if (type.equalsIgnoreCase("pdf")) return new PDFFactory();
        else if(type.equalsIgnoreCase("csv")) return new CSVFactory();
        else return null;
    }
}
