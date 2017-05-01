package br.edu.ifg.SistemaDeEncomendas.entity;
import java.io.Serializable;
import javax.persistence.*;


@NamedQueries({
        @NamedQuery(name="Usuario.findCPF", query="SELECT m FROM Usuario m WHERE m.login= :login"),
        @NamedQuery(name="Usuario.findAll", query="SELECT m FROM Usuario m")
})
@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column(length=60, nullable=false)
    private String nome;
    @Column(length=20, nullable=false)
    private String documento;
    @OneToOne
    private Endereco endereco;
    @Column(length=20, nullable=false)
    private String tipoUsuario;
    @Column(length=20, nullable=false)
    private String login;
    @Column(length=20, nullable=false)
    private String senha;
       

    public int getId() {
            return id;
    }
    public void setId(int id) {
            this.id = id;
    }
    public String getNome() {
            return nome;
    }
    public void setNome(String nome) {
            this.nome = nome;
    }
    public String getDocumento() {
            return documento;
    }
    public void setDocumento(String documento) {
            this.documento = documento;
    }
    public Endereco getEndereco() {
            return endereco;
    }
    public void setEndereco(Endereco endereco) {
            this.endereco = endereco;
    }
    public String getLogin() {
            return login;
    }
    public void setLogin(String login) {
            this.login = login;
    }
    public String getSenha() {
            return senha;
    }
    public void setSenha(String senha) {
            this.senha = senha;
    }
    
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

	
}
