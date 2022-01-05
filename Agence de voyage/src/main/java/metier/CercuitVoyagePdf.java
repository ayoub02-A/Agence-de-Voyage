package metier;

import java.util.List;


import java.awt.Color;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;


public class CercuitVoyagePdf {
	private List<Voyage> listVoyage;

	public CercuitVoyagePdf(List<Voyage> listVoyage) {
		super();
		this.listVoyage = listVoyage;
	}

	public List<Voyage> getListVoyage() {
		return listVoyage;
	}

	public void setListVoyage(List<Voyage> listVoyage) {
		this.listVoyage = listVoyage;
	}
	
	private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Non voyage", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Destination", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Duree", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Date", font));
        table.addCell(cell);      
    }
	
	private void writeTableData(PdfPTable table) {
        for (Voyage user : listVoyage) {
            table.addCell(user.getNom_voyage());
            table.addCell(user.getDestination());
            table.addCell(user.getDuree());
            Format formatter = new SimpleDateFormat("yyyy-MM-dd");
    		String s = formatter.format(user.getDate_depart());
            table.addCell(s);
        }
    }
	
	public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("Liste de Vos voyages ", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }

}
