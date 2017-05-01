package br.edu.ifg.SistemaDeEncomendas.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name="Motoboy.findID", query="SELECT m FROM Motoboy m WHERE m.cpf = :cpf"),
        @NamedQuery(name="Motoboy.findAll", query="SELECT m FROM Motoboy m"),
        @NamedQuery(name="Motoboy.atualizaSal", query="UPDATE Motoboy m Set m.salario = :salario WHERE m.cpf = :cpf")
})
public class Motoboy implements Serializable {
    @Id
    @Column(length=11, nullable=false)
    private String cpf;
    @Column(length=60, nullable=false)
    private String nome;
    @Column(length=1, nullable=false)
    private String sexo;
    @Column(length=10, nullable=false)
    private String dataNasc;
    @OneToOne
    private Moto moto;
    @OneToOne
    private AreaDeAtuacao area;
    @Column(precision=2, nullable=false)
    private double salario;
    @OneToOne
    private Empresa empresa;

    public String getNome() {
            return nome;
    }
    public void setNome(String nome) {
            this.nome = nome;
    }
    public String getCpf() {
            return cpf;
    }
    public void setCpf(String cpf) {
            this.cpf = cpf;
    }
    public String getSexo() {
            return sexo;
    }
    public void setSexo(String sexo) {
            this.sexo = sexo;
    }
    public String getDataNasc() {
            return dataNasc;
    }
    public void setDataNasc(String dataNasc) {
            this.dataNasc = dataNasc;
    }
    public Moto getMoto() {
            return moto;
    }
    public void setMoto(Moto moto) {
            this.moto = moto;
    }
    public AreaDeAtuacao getArea() {
            return area;
    }
    public void setArea(AreaDeAtuacao area) {
            this.area = area;
    }
    
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
