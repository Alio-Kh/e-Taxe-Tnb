/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fstg.eTaxe.Tnb.service.util;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alikhyatti
 */
public class PdfUtil {

    public static Document createPdf() {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("/Users/alikhyatti/iTextHelloWorld2.pdf"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PdfUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(PdfUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return document;
    }

    public static void editPdf(Document document, String word) {
        document.open();
//        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
//        Chunk chunk = new Chunk(word, font);

        try {
            document.add(new Paragraph(word));

        } catch (DocumentException ex) {
            Logger.getLogger(PdfUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void pdfClose(Document document) {
        document.close();
    }

//    public static void pdfTable(Document document) {
//        PdfPTable table = new PdfPTable(3);
//        addTableHeader(table);
//        
//        addRows(table);
//        addCustomRows(table);
//
//        document.add(table);
//    }
}
