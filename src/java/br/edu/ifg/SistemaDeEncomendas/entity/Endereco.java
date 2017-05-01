package br.edu.ifg.SistemaDeEncomendas.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Endereco implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column(length=45, nullable=false)
    private String logradouro;
    @Column(length=6, nullable=false)
    private String numero;
    @Column(length=30, nullable=false)
    private String complemento;
    @Column(length=40, nullable=false)
    private String bairro;
    @Column(length=40, nullable=false)
    private String cidade;
    @Column(length=20, nullable=false)
    private String estado;
    @Column(length=10, nullable=false)
    private String cep;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public String getEstado() {
            return estado;
    }
    public void setEstado(String estado) {
            this.estado = estado;
    }
    public String getCep() {
            return cep;
    }
    public void setCep(String cep) {
            this.cep = cep;
    }

}
