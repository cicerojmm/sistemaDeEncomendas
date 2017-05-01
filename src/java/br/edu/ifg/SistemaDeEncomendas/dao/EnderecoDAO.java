package br.edu.ifg.SistemaDeEncomendas.dao;

import br.edu.ifg.SistemaDeEncomendas.entity.Endereco;
import br.edu.ifg.SistemaDeEncomendas.util.ConexaoBD;
import javax.persistence.EntityManager;


public class EnderecoDAO {
    ConexaoBD conexao = new ConexaoBD();
    private final EntityManager manager;
    
    public EnderecoDAO() {
        this.manager = conexao.conectar();
    }
    
    public void salvar(Endereco endereco) {
        manager.getTransaction().begin();
        manager.persist(endereco);
        manager.getTransaction().commit();  

        manager.close();

    }


}
