package metier;

import java.util.List;


import java.awt.Color;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;




public class CircuitPdf {
	private List<Circuit_accompagnes> listCircuit;
	
	public CircuitPdf(List<Circuit_accompagnes> listCircuit) {
		super();
		this.listCircuit = listCircuit;
	}

	public List<Circuit_accompagnes> getListCircuit() {
		return listCircuit;
	}

	public void setListCircuit(List<Circuit_accompagnes> listCircuit) {
		this.listCircuit = listCircuit;
	}
	
	private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Nom Complet", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Email", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Telephone", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("langues", font));
        table.addCell(cell);      
    }
	
	private void writeTableData(PdfPTable table) {
        for (Circuit_accompagnes user : listCircuit) {
            table.addCell(user.getNom_circuit());
            table.addCell(user.getEmail_circuit());
            table.addCell(user.getTel_circuit());
            table.addCell(user.getLangues_circuit());
        }
    }
	
	public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("Liste des Circuit accompagnés ", font);
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
