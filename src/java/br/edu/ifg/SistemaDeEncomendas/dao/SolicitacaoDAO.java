package br.edu.ifg.SistemaDeEncomendas.dao;

import br.edu.ifg.SistemaDeEncomendas.entity.Encomenda;
import br.edu.ifg.SistemaDeEncomendas.entity.Endereco;
import br.edu.ifg.SistemaDeEncomendas.entity.Solicitacao;
import br.edu.ifg.SistemaDeEncomendas.entity.Usuario;
import javax.persistence.EntityManager;
import br.edu.ifg.SistemaDeEncomendas.util.ConexaoBD;
import javax.persistence.Query;

public class SolicitacaoDAO {
    ConexaoBD conexao = new ConexaoBD();
    private final EntityManager manager;

    public SolicitacaoDAO() {
        this.manager = conexao.conectar();
    }
    
    public void salvar(Solicitacao solicitacao) {
        manager.getTransaction().begin();
        manager.persist(solicitacao);
        manager.getTransaction().commit();  

        manager.close();
    }
    
    public Solicitacao cadastrar(Encomenda encomenda, String loginUsuario, Endereco endOrigem) {
        Solicitacao solicitacao = new Solicitacao();
        UsuarioDAO retorno = new UsuarioDAO();
        EncomendaDAO en = new EncomendaDAO();
        EnderecoDAO end = new EnderecoDAO();
        
        Usuario usuario = retorno.pesquisaLogin(loginUsuario);
        double valor = en.definirvalor(encomenda);
        
        String id = gerarId();
        
        solicitacao.setIdentificacao(id);
        solicitacao.setEncomenda(encomenda);
        solicitacao.setEnderecoOrigem(endOrigem);
        solicitacao.setSolicitante(usuario);
        solicitacao.setValor(valor);
        
        en.salvar(encomenda);
        
        return solicitacao;
    }
    
    public String gerarId() {
        String id;
        String r;
        long total;
        
        Query query = manager.createNamedQuery("Solicitacao.count");
        total = (long) query.getSingleResult();
        
        total +=1;
        id = "CNK-0" + Long.toString(total);
        
        return id;
    }
    
    /*
    public void inserir(Encomenda encomenda, String loginUsuario, Endereco endOrigem, Endereco endDestino, String cpfMotoboy) {
        Date agora = new Date();
        
        UsuarioDAO retorno = new UsuarioDAO();
        EncomendaDAO en = new EncomendaDAO();
        
        Solicitacao solicitacao = new Solicitacao();
        Entrega entrega = new Entrega();
        MotoboyDAO pesquisa = new MotoboyDAO();
        EnderecoDAO end = new EnderecoDAO();
        EntregaDAO enDAO = new EntregaDAO();
        EnderecoDAO endDAO = new EnderecoDAO();
        
        Motoboy motoboy = pesquisa.pesquisaPorCPF(cpfMotoboy);
        endDAO.salvar(endOrigem);
        end.salvar(endDestino);
        
        Usuario usuario = retorno.pesquisaLogin(loginUsuario);
        double valor = en.definirvalor(encomenda);
        
        solicitacao.setIdentificacao("CKN001");
        solicitacao.setEncomenda(encomenda);
        solicitacao.setEnderecoOrigem(endOrigem);
        solicitacao.setSolicitante(usuario);
        solicitacao.setValor(valor);
        
        entrega.setMotoboy(motoboy);
        entrega.setSolicitacao(solicitacao);
        entrega.setStatus("EM ANDAMENTO");
        entrega.setInicio(agora);
        entrega.setEnderecoDestino(endDestino);
        
        en.salvar(encomenda);
        salvar(solicitacao);
        enDAO.salvar(entrega);
        
        //enDAO.calcularComissao(entrega);
    }
    
    
    
   
     public void inserir(Encomenda encomenda, String loginUsuario, Endereco endOrigem, Endereco endDestino, String cpfMotoboy) {
        Date agora = new Date();
        
        UsuarioDAO retorno = new UsuarioDAO();
        EncomendaDAO en = new EncomendaDAO();
        
        Solicitacao solicitacao = new Solicitacao();
        Entrega entrega = new Entrega();
        MotoboyDAO pesquisa = new MotoboyDAO();
        EnderecoDAO end = new EnderecoDAO();
        EntregaDAO enDAO = new EntregaDAO();
        EnderecoDAO endDAO = new EnderecoDAO();
        
        Motoboy motoboy = pesquisa.pesquisaPorCPF(cpfMotoboy);
        endDAO.salvar(endOrigem);
        end.salvar(endDestino);
        
        Usuario usuario = retorno.pesquisaLogin(loginUsuario);
        double valor = en.definirvalor(encomenda);
        
        solicitacao.setIdentificacao("CKN001");
        solicitacao.setEncomenda(encomenda);
        solicitacao.setEnderecoOrigem(endOrigem);
        solicitacao.setSolicitante(usuario);
        solicitacao.setValor(valor);
        
        entrega.setMotoboy(motoboy);
        entrega.setSolicitacao(solicitacao);
        entrega.setStatus("EM ANDAMENTO");
        entrega.setInicio(agora);
        entrega.setEnderecoDestino(endDestino);
        
        en.salvar(encomenda);
        salvar(solicitacao);
        enDAO.salvar(entrega);
        
        //enDAO.calcularComissao(entrega);
    }*/
}
