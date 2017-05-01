package br.edu.ifg.SistemaDeEncomendas.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "historico_salario")
public class HistoricoPagamento implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private Motoboy motoboy;
    @Column(length=10, nullable=false)
    private String mes;

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
    private double salarioCalculado;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Motoboy getMotoboy() {
        return motoboy;
    }

    public void setMotoboy(Motoboy motoboy) {
        this.motoboy = motoboy;
    }

    public double getSalarioCalculado() {
        return salarioCalculado;
    }

    public void setSalarioCalculado(double salarioCalculado) {
        this.salarioCalculado = salarioCalculado;
    }
            
}
