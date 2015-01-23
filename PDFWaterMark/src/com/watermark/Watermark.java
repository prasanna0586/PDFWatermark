package com.watermark;


import java.io.FileOutputStream;

import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
public class Watermark {
    public static void main(String[] args) {
        try {
            PdfReader Read_PDF_To_Watermark = new PdfReader("C:\\Users\\prasannakumarr\\Desktop\\Sample.pdf");
            int number_of_pages = Read_PDF_To_Watermark.getNumberOfPages();
            PdfStamper stamp = new PdfStamper(Read_PDF_To_Watermark, new FileOutputStream("C:\\Users\\prasannakumarr\\Desktop\\SamplePDFWithWaterMark.pdf"));
            int i = 0;
            String watermark_text = "JAVA program to add watermark";
            /*Image watermark_image = Image.getInstance("watermark.jpg");
            watermark_image.setAbsolutePosition(200, 400);*/
            BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, 
                    BaseFont.WINANSI, BaseFont.EMBEDDED);
            PdfContentByte add_watermark;            
            while (i < number_of_pages) {
              i++;
              /*add_watermark = stamp.getUnderContent(i);
              add_watermark.addImage(watermark_image);*/
              add_watermark = stamp.getOverContent(i);
              add_watermark.beginText();
              add_watermark.setFontAndSize(bf, 18);
              add_watermark.showTextAligned(PdfContentByte.ALIGN_CENTER, watermark_text, 300, 450, 45);
              //add_watermark.showText(watermark_text);
              add_watermark.endText();
            }
            stamp.close();
            System.out.println("Completed.....");
        }
        catch (Exception i1) {
            i1.printStackTrace();
        }
    }
}