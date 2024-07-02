package DDT;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchingDatafromPdf {

	public static void main(String[] args) throws Throwable
	{
		// TODO Auto-generated method stub
		File fil = new File("./src\\test\\resources\\\\Day01.pdf");
	
		  
		           PDDocument doc = PDDocument.load(fil);	
			
		           int pages = doc.getNumberOfPages();
			       System.out.println(pages);
			       
			       PDFTextStripper pdfData = new PDFTextStripper();
			    //   String Data = pdfData.getText(doc);
			    //   System.out.println(Data);
			
			      // pdfData.setStartPage(4);
			      // String pageData = pdfData.getText(doc);
			       
			       pdfData.setStartPage(1);
			       pdfData.setEndPage(2);//we can give the inbetween page numbers
			       String pageData1 = pdfData.getText(doc);
			       System.out.println(pageData1);
			
			
			}

		 
	

}
