package com.IntuitiveCare.Teste.operadoras;

public record ListarOperadora(Long id, String registroANS, String cnpj, String razaoSocial, String nomeFantasia) {

    public ListarOperadora(OperadorasAtivas operadora) {
        this(operadora.getId(), operadora.getRegistroANS(), operadora.getCnpj(), operadora.getRazaoSocial(), operadora.getNomeFantasia());
    }
}
