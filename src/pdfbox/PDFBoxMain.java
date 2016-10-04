package pdfbox;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class PDFBoxMain {
	
	static String imagePath = "C:\\Users\\hgarg\\Desktop\\87357.jpg";

	public static void main(String[] args) throws IOException {
		PDDocument document = new PDDocument();
		InputStream in = new FileInputStream(imagePath);
		BufferedImage bimg = ImageIO.read(in);
		float width = bimg.getWidth();
		float height = bimg.getHeight();
		PDPage page = new PDPage(new PDRectangle(width, height));
		document.addPage(page); 
		PDImageXObject img = PDImageXObject.createFromFile(imagePath, document);
		PDPageContentStream contentStream = new PDPageContentStream(document, page);
		contentStream.drawImage(img, 0, 0);
		contentStream.close();
		in.close();

		document.save("C:\\Users\\hgarg\\Desktop\\PDFBOX\\Imagetest.pdf");
		document.close();
	}
}
