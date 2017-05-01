package br.edu.ifg.SistemaDeEncomendas.util;

import javax.persistence.*;


public class ConexaoBD {
    public EntityManager conectar() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("gravar");
        EntityManager manager = factory.createEntityManager();
          
        return manager;
    }
}
