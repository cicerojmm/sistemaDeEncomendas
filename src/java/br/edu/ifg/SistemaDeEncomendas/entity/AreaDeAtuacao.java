package br.edu.ifg.SistemaDeEncomendas.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class AreaDeAtuacao implements Serializable {
    @Id
    private int numero;
    @Column(length=30, nullable=false)
    private String descricao;

    public int getNumero() {
            return numero;
    }
    public void setNumero(int numero) {
            this.numero = numero;
    }
    public String getDescricao() {
            return descricao;
    }
    public void setDescricao(String descricao) {
            this.descricao = descricao;
    }
}
