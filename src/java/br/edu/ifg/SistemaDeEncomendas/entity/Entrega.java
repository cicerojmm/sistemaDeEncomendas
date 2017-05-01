package br.edu.ifg.SistemaDeEncomendas.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name="Entrega.findID", query="SELECT e FROM Entrega e WHERE e.solicitacao = :identificacao"),
    @NamedQuery(name="Entrega.finalizar", query="Update Entrega e SET e.fim = :fim, e.status = :status WHERE e.solicitacao = :identificacao")
})
public class Entrega implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column(length=20, nullable=false)
    private String inicio;
    @Column(length=20)
    private String fim;
    @OneToOne
    private Solicitacao solicitacao;
    @OneToOne
    private Endereco enderecoDestino;
    @OneToOne
    private Motoboy motoboy;
    @Column(length=30, nullable=false)
    private String status;

    public Endereco getEnderecoDestino() {
        return enderecoDestino;
    }

    public void setEnderecoDestino(Endereco enderecoDestino) {
        this.enderecoDestino = enderecoDestino;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    public Motoboy getMotoboy() {
        return motoboy;
    }

    public void setMotoboy(Motoboy motoboy) {
        this.motoboy = motoboy;
    }
   
    
}

