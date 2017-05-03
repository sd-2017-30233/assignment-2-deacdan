package model;

import model.IRFactory;
import model.IReport;

/**
 * Created by dandeac on 01/05/2017.
 */
public class PDFFactory implements IRFactory {

    @Override
    public IReport build(){
        PDF pdf = new PDF();
        pdf.build();
        return pdf;
    }
}
