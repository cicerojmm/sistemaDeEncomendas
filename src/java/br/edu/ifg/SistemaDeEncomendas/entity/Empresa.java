package br.edu.ifg.SistemaDeEncomendas.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Empresa implements Serializable {
    @Id
    @Column(length=20, nullable=false)
    private String cnpj;
    @Column(length=60, nullable=false)
    private String razaoSocial;
    @OneToOne
    private Endereco endereco;

    public String getRazaoSocial() {
            return razaoSocial;
    }
    public void setRazaoSocial(String razaoSocial) {
            this.razaoSocial = razaoSocial;
    }
    public String getCnpj() {
            return cnpj;
    }
    public void setCnpj(String cnpj) {
            this.cnpj = cnpj;
    }
    public Endereco getEndereco() {
            return endereco;
    }
    public void setEndereco(Endereco endereco) {
            this.endereco = endereco;
    }
}
