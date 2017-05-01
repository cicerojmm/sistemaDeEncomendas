package br.edu.ifg.SistemaDeEncomendas.dao;

import br.edu.ifg.SistemaDeEncomendas.entity.Motoboy;
import javax.persistence.*;
import br.edu.ifg.SistemaDeEncomendas.util.ConexaoBD;


public class MotoboyDAO{
    ConexaoBD conexao = new ConexaoBD();
    private final EntityManager manager;

    public MotoboyDAO() {
        this.manager = conexao.conectar();
    }
    
    public void salvar(Motoboy motoboy) {
        manager.getTransaction().begin();
        manager.persist(motoboy);
        manager.getTransaction().commit();  

        manager.close();
    }
    
    public Motoboy pesquisarMotoboy(Motoboy motoboy){       
        Query query = manager.createNamedQuery("Motoboy.findID");
        query.setParameter("cpf", motoboy.getCpf());
        Motoboy retorno = (Motoboy) query.getSingleResult();
        
        return retorno;

    }
    
    public Motoboy pesquisaPorCPF(String cpf){       
        Query query = manager.createNamedQuery("Motoboy.findID");
        query.setParameter("cpf", cpf);
        Motoboy retorno = (Motoboy) query.getSingleResult();
        
        return retorno;

    }
    
     public void atualizaSalario(double salario, String cpf){
        manager.getTransaction().begin();
        
        try{
            Query query = manager.createNamedQuery("Motoboy.atualizaSal");
            query.setParameter("salario", salario); 
            query.setParameter("cpf", cpf);


            query.executeUpdate();
            
        }finally {
             manager.getTransaction().commit(); 
             manager.close();
        }
    }
}
