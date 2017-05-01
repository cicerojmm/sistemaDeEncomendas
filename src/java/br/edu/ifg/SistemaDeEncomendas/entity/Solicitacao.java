package br.edu.ifg.SistemaDeEncomendas.entity;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name="Solicitacao.count", query="SELECT count(*) FROM Solicitacao"),
    @NamedQuery(name="Solicitacao.findID", query="SELECT s FROM Solicitacao s WHERE s.identificacao = :identificacao")
})
public class Solicitacao implements Serializable {
    @Id
    @Column(length=30)
    private String identificacao;
    @OneToOne
    private Usuario solicitante ;
    @OneToOne
    private Encomenda encomenda;
    @OneToOne
    private Endereco enderecoOrigem;
    @Column(nullable=false, precision=2)
    private double valor;

    public String getIdentificacao() {
            return identificacao;
    }
    public void setIdentificacao(String identificacao) {
            this.identificacao = identificacao;
    }
    public Usuario getSolicitante() {
            return solicitante;
    }
    public void setSolicitante(Usuario solicitante) {
            this.solicitante = solicitante;
    }
    public Encomenda getEncomenda() {
            return encomenda;
    }
    public void setEncomenda(Encomenda encomenda) {
            this.encomenda = encomenda;
    }
    public Endereco getEnderecoOrigem() {
            return enderecoOrigem;
    }
    public void setEnderecoOrigem(Endereco enderecoOrigem) {
            this.enderecoOrigem = enderecoOrigem;
    }

    public double getValor() {
            return valor;
    }
    public void setValor(double valor) {
            this.valor = valor;
    }
}
