package metier;

import java.util.List;


import java.awt.Color;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class ClientParticipantPdf {
	private List<Clients> listParticipant;

	public ClientParticipantPdf(List<Clients> listParticipant) {
		super();
		this.listParticipant = listParticipant;
	}

	public List<Clients> getListParticipant() {
		return listParticipant;
	}

	public void setListParticipant(List<Clients> listParticipant) {
		this.listParticipant = listParticipant;
	}
	
	
	private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Non", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Prénom", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Telephone", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Email", font));
        table.addCell(cell);      
    
	}
	
	private void writeTableData(PdfPTable table) {
        for (Clients user : listParticipant) {
            table.addCell(user.getNom_client());
            table.addCell(user.getPrenom_client());
            table.addCell(user.getTel_client());
            table.addCell(user.getEmail_client());
        }
    }
	
	public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("Liste des participants ", font);
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
