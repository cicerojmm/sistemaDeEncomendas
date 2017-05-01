package br.edu.ifg.SistemaDeEncomendas.dao;

import br.edu.ifg.SistemaDeEncomendas.entity.AreaDeAtuacao;
import javax.persistence.*;
import br.edu.ifg.SistemaDeEncomendas.util.ConexaoBD;


public class AreaDeAtuacaoDAO {
    ConexaoBD conexao = new ConexaoBD();
    private final EntityManager manager;

    public AreaDeAtuacaoDAO() {
        this.manager = conexao.conectar();
    }
    
    public void salvar(AreaDeAtuacao area) {
        manager.getTransaction().begin();
        manager.persist(area);
        manager.getTransaction().commit();  

        manager.close();
    }
}
