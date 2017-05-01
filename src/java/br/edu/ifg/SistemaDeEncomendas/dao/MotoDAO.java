package br.edu.ifg.SistemaDeEncomendas.dao;

import br.edu.ifg.SistemaDeEncomendas.entity.Moto;
import javax.persistence.EntityManager;
import br.edu.ifg.SistemaDeEncomendas.util.ConexaoBD;

public class MotoDAO {
    ConexaoBD conexao = new ConexaoBD();
    private final EntityManager manager;

    public MotoDAO() {
        this.manager = conexao.conectar();
    }
    
    public void salvar(Moto moto) {
        manager.getTransaction().begin();
        manager.persist(moto);
        manager.getTransaction().commit();  

        manager.close();
    }
}
