package pdfbox;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class HeaderTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		// the document
		PDDocument doc = null;
		try {
			doc = PDDocument.load(new File(
					"C:\\Users\\hgarg\\Desktop\\PDFBOX\\Mergetest.pdf"));

			PDPageTree allPages = doc.getDocumentCatalog().getPages();
			// PDFont font = PDType1Font.HELVETICA_BOLD;

			for (int i = 0; i < allPages.getCount(); i++) {
				PDPage page = (PDPage) allPages.get(i);
				PDRectangle pageSize = page.getMediaBox();
				PDPageContentStream contentStream = new PDPageContentStream(
						doc, page, true, true, true);
				page.getResources().getFontNames(); // <<<<<<<<
				PDFont font = PDType1Font.TIMES_ROMAN;
				float fontSize = 15.0f;
				contentStream.beginText();
				// set font and font size
				contentStream.setFont(font, fontSize);
				contentStream.moveTextPositionByAmount(700, 1150);
				contentStream.drawString("This header is for test purpose");
				contentStream.endText();

				// contentStream.
				contentStream.close();
			}
			doc.save("C:\\Users\\hgarg\\Desktop\\PDFBOX\\MergetestWithHeader.pdf");
		} finally {
			if (doc != null) {
				doc.close();
			}
		}
	}

}
