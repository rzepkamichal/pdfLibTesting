
package pdfTesting;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {

        //creating an empty pdf with 3 pages
        int pageNumber = 3;
        PDDocument blankDoc = new PDDocument();

        for(int i=0; i<pageNumber; i++){
            PDPage page = new PDPage();
            blankDoc.addPage(page);
        }

        blankDoc.save("C:\\Users\\sysoper\\Desktop\\dev\\pdfLibTesting\\data\\emptyDoc.pdf");
        blankDoc.close();


        //loading the empty pdf as a file
        File file = new File ("C:\\Users\\sysoper\\Desktop\\dev\\pdfLibTesting\\data\\emptyDoc.pdf");
        PDDocument document = PDDocument.load(file);

        //getting the chosen page
        PDPage page = document.getPage(0);

        //creating a content stream
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        //beginning the content stream and setting some properties
        contentStream.beginText();
        contentStream.setFont(PDType1Font.TIMES_ROMAN,14);
        contentStream.newLineAtOffset(120,600);

        //initializing a chosen text and adding it to the stream
        String text = "Testing the power of this PDF Library from Apache. ;)";
        contentStream.showText(text);
        contentStream.endText();

        System.out.println("Well done!");
        contentStream.close();

        //saving the document
        document.save(new File("C:\\Users\\sysoper\\Desktop\\dev\\pdfLibTesting\\data\\nowyPdf.pdf"));
    }
}
