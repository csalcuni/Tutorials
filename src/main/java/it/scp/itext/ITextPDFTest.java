package it.scp.itext;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class ITextPDFTest {

    public static void main(String[] args) {
        new ITextPDFTest().generate();
    }

    private void generate() {
        try {
            PdfReader pdfReader = new PdfReader("Template.pdf");
            PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("C:\\Users\\Utente\\Desktop\\Output.pdf"));
            AcroFields acroFields = pdfStamper.getAcroFields();
            Map<String, AcroFields.Item> fields = acroFields.getFields();
            for (String fieldName : fields.keySet()) {
                System.out.println("Field : " + fieldName);

            }
            acroFields.setField("Name2", "Carlooo3");
//            acroFields.setFieldProperty("Name2", "setflags", PdfAnnotation.FLAGS_INVISIBLE, null);
            acroFields.setFieldProperty("Name2", "setflags", PdfAnnotation.FLAGS_HIDDEN, null);
//            acroFields.regenerateField("Name2");


            pdfStamper.close();
            pdfReader.close();
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }
}
