package com.IntuitiveCare.Teste.operadoras;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "operadoras_ativas")
@Getter
@Setter
@NoArgsConstructor
public class OperadorasAtivas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registro_ANS")
    private String registroANS;
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String modalidade;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String ddd;
    private String telefone;
    private String fax;
    private String enderecoEletronico;
    private String representante;
    private String cargoRepresentante;
    private String regiaoComercializacao;
    private LocalDate dataRegistroANS;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistroANS() {
        return registroANS;
    }

    public void setRegistroANS(String registroANS) {
        this.registroANS = registroANS;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEnderecoEletronico() {
        return enderecoEletronico;
    }

    public void setEnderecoEletronico(String enderecoEletronico) {
        this.enderecoEletronico = enderecoEletronico;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getCargoRepresentante() {
        return cargoRepresentante;
    }

    public void setCargoRepresentante(String cargoRepresentante) {
        this.cargoRepresentante = cargoRepresentante;
    }

    public String getRegiaoComercializacao() {
        return regiaoComercializacao;
    }

    public void setRegiaoComercializacao(String regiaoComercializacao) {
        this.regiaoComercializacao = regiaoComercializacao;
    }

    public LocalDate getDataRegistroANS() {
        return dataRegistroANS;
    }

    public void setDataRegistroANS(LocalDate dataRegistroANS) {
        this.dataRegistroANS = dataRegistroANS;
    }

}
