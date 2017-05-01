package br.edu.ifg.SistemaDeEncomendas.dao;

import br.edu.ifg.SistemaDeEncomendas.entity.HistoricoPagamento;
import br.edu.ifg.SistemaDeEncomendas.entity.Motoboy;
import javax.persistence.EntityManager;
import br.edu.ifg.SistemaDeEncomendas.util.ConexaoBD;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.persistence.Query;

public class HistoricoPagamentoDAO {
    ConexaoBD conexao = new ConexaoBD();
    private final EntityManager manager;

    public HistoricoPagamentoDAO() {
        this.manager = conexao.conectar();
    }
    
    public void salvar(HistoricoPagamento historico) {
        manager.getTransaction().begin();
        manager.persist(historico);
        manager.flush();
        manager.clear();
        manager.getTransaction().commit();  

        manager.close();
    }
    
    public void fecharFolhaPagamento() {
        HistoricoPagamento historico = new HistoricoPagamento();
        MotoboyDAO mDAO = new MotoboyDAO();
        
        Date date = new Date();
        DateFormat formato = new SimpleDateFormat("MM/YY");
        String mesEano = formato.format(date);  
        
        Query query = manager.createNamedQuery("Motoboy.findAll");
        List<Motoboy> motoboys = query.getResultList();
        
        for(Motoboy m : motoboys) {
            historico.setMotoboy(m);
            historico.setSalarioCalculado(m.getSalario());
            historico.setMes(mesEano);
            
            mDAO.atualizaSalario(0.0, m.getCpf());
            salvar(historico);
        }
        
    }
}
