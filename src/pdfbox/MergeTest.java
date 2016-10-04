package pdfbox;

import java.io.IOException;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

public class MergeTest {

	public static void main(String[] args) throws IOException {
		PDFMergerUtility mergeUtility = new PDFMergerUtility();
		mergeUtility
				.addSource("C:\\Users\\hgarg\\Desktop\\PDFBOX\\Imagetest.pdf");
		mergeUtility.addSource("C:\\Users\\hgarg\\Desktop\\PDFBOX\\test.pdf");
		mergeUtility
				.setDestinationFileName("C:\\Users\\hgarg\\Desktop\\PDFBOX\\Mergetest.pdf");
		mergeUtility.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
	}

}
