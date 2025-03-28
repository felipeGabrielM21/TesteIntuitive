package com.IntuitiveCare.Teste.arquivo;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class ExtrairTextoPDF {

    public static void main(String[] args) {
        String caminhoArquivo = "arquivos/Anexo_I.pdf";

        try {

            PDDocument document = PDDocument.load(new File(caminhoArquivo));


            PDFTextStripper stripper = new PDFTextStripper();
            String texto = stripper.getText(document);


            System.out.println(texto);


            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}