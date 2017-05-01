package br.edu.ifg.SistemaDeEncomendas.bean;

import br.edu.ifg.SistemaDeEncomendas.dao.SolicitacaoDAO;
import br.edu.ifg.SistemaDeEncomendas.entity.Encomenda;
import br.edu.ifg.SistemaDeEncomendas.entity.Endereco;
import br.edu.ifg.SistemaDeEncomendas.entity.Solicitacao;
import javax.faces.application.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class SolicitacaoBean {
    private Solicitacao solicitacao = new Solicitacao();
    private SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
    
     public void salvar() {
         solicitacaoDAO.salvar(solicitacao);
         solicitacao = new Solicitacao();
    }
     
    public void mensagem(String titulo, String msg, FacesMessage.Severity tipo){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage mensagem = new FacesMessage(tipo, titulo, msg);
        context.addMessage(null, mensagem);
    }
    
     public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    public SolicitacaoDAO getSolicitacaoDAO() {
        return solicitacaoDAO;
    }

    public void setSolicitacaoDAO(SolicitacaoDAO solicitacaoDAO) {
        this.solicitacaoDAO = solicitacaoDAO;
    }
}
