package com.IntuitiveCare.Teste.arquivo;

import java.io.File;

public class LerArquivo {
    public static void main(String[] args) {

        String caminho = "arquivos/Anexo_I.pdf";


        File arquivo = new File(caminho);
        if (arquivo.exists()) {
            System.out.println("Arquivo encontrado: " + arquivo.getName());
        } else {
            System.out.println("Arquivo não encontrado.");
        }
    }
}