package br.edu.ifg.SistemaDeEncomendas.entity;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "moto")
public class Moto implements Serializable {
    @Id
    @Column(length=10, nullable=false)
    private String placa;
    @Column(length=20, nullable=false)
    private String marca;
    @Column(length=20, nullable=false)
    private String modelo;
    @Column(nullable=false)
    private int ano;

    public String getPlaca() {
            return placa;
    }
    public void setPlaca(String placa) {
            this.placa = placa;
    }
    public String getMarca() {
            return marca;
    }
    public void setMarca(String marca) {
            this.marca = marca;
    }
    public String getModelo() {
            return modelo;
    }
    public void setModelo(String modelo) {
            this.modelo = modelo;
    }
    public int getAno() {
            return ano;
    }
    public void setAno(int ano) {
            this.ano = ano;
    }
}
