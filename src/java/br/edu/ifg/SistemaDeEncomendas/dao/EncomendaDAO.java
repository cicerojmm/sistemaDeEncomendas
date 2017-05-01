
package br.edu.ifg.SistemaDeEncomendas.dao;

import br.edu.ifg.SistemaDeEncomendas.entity.Encomenda;
import javax.persistence.*;
import br.edu.ifg.SistemaDeEncomendas.util.ConexaoBD;


public class EncomendaDAO {
    ConexaoBD conexao = new ConexaoBD();
    private final EntityManager manager;

    public EncomendaDAO() {
        this.manager = conexao.conectar();
    }
    
     public void salvar(Encomenda encomenda) {        
        manager.getTransaction().begin();
        manager.persist(encomenda);
        manager.getTransaction().commit();  

        manager.close();
    }
     
     public double definirvalor (Encomenda encomenda){
  
       double valor = 0;
         
       if(null != encomenda.getTamanho()) switch (encomenda.getTamanho()) {
            case "PEQUENO":
                valor = 10.00;
                break;
            case "MEDIO":
                valor = 20.00;
                break;
            case "GRANDE":
                valor = 30.00;
                break;
        }
       
        return valor;
     }
}
