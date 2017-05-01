package br.edu.ifg.SistemaDeEncomendas.dao;

import br.edu.ifg.SistemaDeEncomendas.entity.Encomenda;
import br.edu.ifg.SistemaDeEncomendas.entity.Endereco;
import br.edu.ifg.SistemaDeEncomendas.entity.Entrega;
import br.edu.ifg.SistemaDeEncomendas.entity.Motoboy;
import br.edu.ifg.SistemaDeEncomendas.entity.Solicitacao;
import java.util.*;
import javax.persistence.EntityManager;
import br.edu.ifg.SistemaDeEncomendas.util.ConexaoBD;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.persistence.Query;


public class EntregaDAO {
    ConexaoBD conexao = new ConexaoBD();
    private final EntityManager manager;

    public EntregaDAO() {
        this.manager = conexao.conectar();
    }
    
    public void salvar(Entrega entrega) {
        manager.getTransaction().begin();
        manager.persist(entrega);
        manager.getTransaction().commit();  

        manager.close();
    }
    
    public String inserirEntrega(String loginUsuario, Encomenda encomenda, 
                                Endereco endOrigem, Endereco endDestino, String cpfMotoboy) {
	Date date = new Date();
        DateFormat formato = new SimpleDateFormat("d/MM/YY-HH:mm:ss");
        String dateEhora = formato.format(date);  
        
        SolicitacaoDAO s = new SolicitacaoDAO();
        Entrega entrega = new Entrega();
        MotoboyDAO pesquisa = new MotoboyDAO();
        EnderecoDAO end = new EnderecoDAO();
        EnderecoDAO endDAO = new EnderecoDAO();
        SolicitacaoDAO sDAO = new SolicitacaoDAO();
        
        Motoboy motoboy = pesquisa.pesquisaPorCPF(cpfMotoboy);
        
        Solicitacao solicitacao = s.cadastrar(encomenda, loginUsuario, endOrigem);
        
        entrega.setMotoboy(motoboy);
        entrega.setSolicitacao(solicitacao);
        entrega.setStatus("EM ANDAMENTO");
        entrega.setInicio(dateEhora);
        entrega.setEnderecoDestino(endDestino);
        
        endDAO.salvar(endOrigem);
        end.salvar(endDestino);
        sDAO.salvar(solicitacao);
        salvar(entrega);
                
        calcularComissao(entrega, motoboy);
        
        
        return solicitacao.getIdentificacao();
    }
    
    public void calcularComissao (Entrega entrega, Motoboy motoboy){
        
        double salario;
        MotoboyDAO pesquisa = new MotoboyDAO();
        
        salario = motoboy.getSalario() + (entrega.getSolicitacao().getValor() * 0.6);
        
        String cpf = motoboy.getCpf();
        
         
        pesquisa.atualizaSalario(salario, cpf);
    }
    
    public Entrega buscar(String idSol) {
        Entrega ent;
        Solicitacao sol;
        SolicitacaoDAO solDAO =  new SolicitacaoDAO();
        
        Query query = manager.createNamedQuery("Solicitacao.findID");
        query.setParameter("identificacao", idSol); 
        sol = (Solicitacao) query.getSingleResult();
        
        Query query1 = manager.createNamedQuery("Entrega.findID");
        query1.setParameter("identificacao", sol); 
        ent = (Entrega) query1.getSingleResult();
        
        return ent;
    }
    
      public void finalizar(String idSol) { 
        Date date = new Date();
        DateFormat formato = new SimpleDateFormat("d/MM/YY-HH:mm:ss");
        String dateEhora = formato.format(date);  
        Solicitacao sol;
        
        manager.getTransaction().begin();
        
        try{
            Query query = manager.createNamedQuery("Solicitacao.findID");
            query.setParameter("identificacao", idSol); 
            sol = (Solicitacao) query.getSingleResult();

            Query query1 = manager.createNamedQuery("Entrega.finalizar");
            query1.setParameter("fim", dateEhora); 
            query1.setParameter("status", "ENTREGUE"); 
            query1.setParameter("identificacao", sol); 
            query1.executeUpdate();
            
        }finally {
            
             manager.getTransaction().commit(); 
             manager.close();
        }
    
    }
}
