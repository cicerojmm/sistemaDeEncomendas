package br.edu.ifg.SistemaDeEncomendas.dao;

import br.edu.ifg.SistemaDeEncomendas.entity.Empresa;
import javax.persistence.*;
import br.edu.ifg.SistemaDeEncomendas.util.ConexaoBD;

public class EmpresaDAO {
    ConexaoBD conexao = new ConexaoBD();
    private final EntityManager manager;

    public EmpresaDAO() {
        this.manager = conexao.conectar();
    }
    
    public void salvar(Empresa empresa) {      
        manager.getTransaction().begin();
        manager.persist(empresa);
        manager.getTransaction().commit();  

        manager.close();
    }
}
