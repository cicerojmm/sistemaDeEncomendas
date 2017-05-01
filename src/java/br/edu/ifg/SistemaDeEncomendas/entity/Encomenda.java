package br.edu.ifg.SistemaDeEncomendas.entity;
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Encomenda implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column(length=45, nullable=false)
    private String descricao;
    @Column(precision=2, nullable=false)
    private double peso;
    @Column(length=20, nullable=false)
    private String tamanho;

    public int getId() {
            return id;
    }
    public void setId(int id) {
            this.id = id;
    }
    public String getDescricao() {
            return descricao;
    }
    public void setDescricao(String descricao) {
            this.descricao = descricao;
    }
    public double getPeso() {
            return peso;
    }
    public void setPeso(double peso) {
            this.peso = peso;
    }
    public String getTamanho() {
            return tamanho;
    }
    public void setTamanho(String tamanho) {
            this.tamanho = tamanho;
    }
}
