package br.edu.ifg.SistemaDeEncomendas.dao;

import br.edu.ifg.SistemaDeEncomendas.entity.Endereco;
import br.edu.ifg.SistemaDeEncomendas.entity.Usuario;
import javax.persistence.*;
import br.edu.ifg.SistemaDeEncomendas.util.ConexaoBD;

public class UsuarioDAO {
    ConexaoBD conexao = new ConexaoBD();
    private final EntityManager manager;

    public UsuarioDAO() {
        this.manager = conexao.conectar();
    }
        
    public void salvar(Usuario usuario) {
        manager.getTransaction().begin();
        manager.persist(usuario);
        manager.getTransaction().commit();  

        manager.close();
    }
    
    public void cadastrar(Usuario u, Endereco end) {
        EnderecoDAO endDAO = new EnderecoDAO();

        u.setEndereco(end);
        
        endDAO.salvar(end);
        salvar(u);
        
    }
    
    public Usuario pesquisaLogin(String login) {
        Query query = manager.createNamedQuery("Usuario.findCPF");
        query.setParameter("login", login);
        Usuario retorno = (Usuario) query.getSingleResult();
        
        return retorno;
    }
    
    
}
