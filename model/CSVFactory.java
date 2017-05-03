package model;

import model.IRFactory;
import model.IReport;

/**
 * Created by dandeac on 01/05/2017.
 */
public class CSVFactory implements IRFactory {
    public IReport build(){
        CSV csv = new CSV();
        csv.build();
        return csv;
    }
}
