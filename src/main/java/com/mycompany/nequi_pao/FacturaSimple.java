package com.mycompany.nequi_pao;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

public class FacturaSimple {

    public static void generarFacturaPdf(Cliente cliente, Banco banco) {
        String nombreArchivo = "Factura_" + cliente.getDocumento() + ".pdf";
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));
            document.open();

            // Encabezado
            document.add(new Paragraph("Factura de Movimientos - Nequi"));
            document.add(new Paragraph("==============================="));
            document.add(new Paragraph("Cliente: " + cliente.getNombre()));
            document.add(new Paragraph("Documento: " + cliente.getDocumento()));
            document.add(new Paragraph("Número de Cuenta: " + cliente.getCuenta().getNumeroCuenta()));
            document.add(new Paragraph("Banco: " + banco.getNombreBanco()));
            document.add(new Paragraph("Fecha emisión: " + 
                new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date())));
            document.add(new Paragraph("\n"));

            // Tabla de movimientos
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);

            // Encabezados de la tabla
            table.addCell(new PdfPCell(new Phrase("Tipo Movimiento")));
            table.addCell(new PdfPCell(new Phrase("Monto")));
            table.addCell(new PdfPCell(new Phrase("Fecha")));

            List<Movimiento> movimientos = cliente.getCuenta().getMovimientos();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            for (Movimiento mov : movimientos) {
                table.addCell(mov.getTipo());
                table.addCell("$" + String.format("%.2f", mov.getMonto()));
                table.addCell(sdf.format(mov.getFecha()));
            }

            document.add(table);

            // Saldo final
            document.add(new Paragraph("\nSaldo final: $" + cliente.getCuenta().getSaldo()));

            document.close();
            System.out.println("Factura generada exitosamente en PDF: " + nombreArchivo);

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
    }
}
