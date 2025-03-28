package com.IntuitiveCare.Teste.arquivo;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class SalvarCSV {

    private static final String SEU_NOME = "intuitive";
    private static final String DIRETORIO_BASE = "arquivos/";
    private static final String ARQUIVO_PDF = DIRETORIO_BASE + "Anexo_I.pdf";
    private static final String ARQUIVO_CSV = DIRETORIO_BASE + "Rol_Procedimentos.csv";
    private static final String ARQUIVO_ZIP = DIRETORIO_BASE + "Teste_" + SEU_NOME + ".zip";

    public static void main(String[] args) {
        try {

            List<String[]> dados = extrairDadosDoPDF();

            salvarComoCSV(dados);

            compactarParaZIP();

            System.out.println("Processo concluído com sucesso!");
            System.out.println("Arquivo CSV: " + new File(ARQUIVO_CSV).getAbsolutePath());
            System.out.println("Arquivo ZIP: " + new File(ARQUIVO_ZIP).getAbsolutePath());

        } catch (Exception e) {
            System.err.println("Erro no processamento: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static List<String[]> extrairDadosDoPDF() throws IOException {
        List<String[]> dados = new ArrayList<>();

        try (PDDocument documento = PDDocument.load(new File(ARQUIVO_PDF))) {
            PDFTextStripper stripper = new PDFTextStripper();

            for (int pagina = 1; pagina <= documento.getNumberOfPages(); pagina++) {
                stripper.setStartPage(pagina);
                stripper.setEndPage(pagina);
                String texto = stripper.getText(documento);
                processarTexto(texto, dados);
            }
        }
        return dados;
    }

    private static void processarTexto(String texto, List<String[]> dados) {
        String[] linhas = texto.split("\\r?\\n");

        for (String linha : linhas) {
            if (validarLinhas(linha)) {
                String[] colunas = Linha(linha);
                if (colunas.length >= 3) {
                    dados.add(colunas);
                }
            }
        }
    }

    private static boolean validarLinhas(String linha) {
        // Filtra linhas que contêm padrões de procedimentos
        return linha.matches(".*\\d{4,}.*") &&
                linha.matches(".*[A-Z]{2,}.*") &&
                !linha.trim().isEmpty();
    }

    private static String[] Linha(String linha) {

        String linhaProcessada = linha.trim()
                .replaceAll("\\s{2,}", "|")
                .replaceAll("\\s(?=\\d)", "|");

        String[] colunas = linhaProcessada.split("\\|");


        for (int i = 0; i < colunas.length; i++) {
            colunas[i] = substituir(colunas[i].trim());
        }

        return colunas;
    }

    private static String substituir(String texto) {
        return texto.replace("OD", "Odontológico")
                .replace("AMB", "Ambulatorial");
    }

    private static void salvarComoCSV(List<String[]> dados) throws IOException {
        Files.createDirectories(Paths.get(DIRETORIO_BASE));

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(ARQUIVO_CSV));
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                     .withHeader("Código", "Descrição", "Tipo", "Vigência", "Detalhes"))) {

            for (String[] linha : dados) {
                csvPrinter.printRecord((Object[]) linha);
            }
        }
    }

    private static void compactarParaZIP() throws IOException {
        try (FileOutputStream fos = new FileOutputStream(ARQUIVO_ZIP);
             ZipOutputStream zos = new ZipOutputStream(fos);
             FileInputStream fis = new FileInputStream(ARQUIVO_CSV)) {

            ZipEntry zipEntry = new ZipEntry(new File(ARQUIVO_CSV).getName());
            zos.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }
        }
    }
}